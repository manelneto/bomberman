package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomb;
import pt.up.fe.bomberman.model.game.elements.Enemy;
import pt.up.fe.bomberman.model.game.elements.Flame;
import pt.up.fe.bomberman.model.game.elements.Obstacle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BombController extends GameController {
    public BombController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        List<Bomb> bombs = new ArrayList<>();
        for (Bomb bomb : getModel().getBombs())
            if (time - 2000 > bomb.getTime())
                explodeBomb(bomb, time);
            else
                bombs.add(bomb);
        getModel().setBombs(bombs);
    }
    public void createFlames(Bomb bomb, long time){
        List<Flame> flames = new ArrayList<>();
        flames.add(new Flame(bomb.getPosition().getX(), bomb.getPosition().getY(), time, 'C'));
        for (int up = 1; up <= bomb.getFlames() && !getModel().isWall(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() - up)); up++) {
            flames.add(new Flame(bomb.getPosition().getX(), bomb.getPosition().getY() - up, time, 'V'));
            if (getModel().isObstacle(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() - up)))
                break;

        }
        for (int down = 1; down <= bomb.getFlames()&& getModel().inArena(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() + down)) && !getModel().isWall(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() + down)); down++) {
            flames.add(new Flame(bomb.getPosition().getX(), bomb.getPosition().getY() + down, time, 'V'));
            if (getModel().isObstacle(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() + down)))
                break;
        }
        for (int left = 1; left <= bomb.getFlames() && getModel().inArena(new Position(bomb.getPosition().getX() - left, bomb.getPosition().getY()))&& !getModel().isWall(new Position(bomb.getPosition().getX() - left, bomb.getPosition().getY())); left++) {
            flames.add(new Flame(bomb.getPosition().getX() - left, bomb.getPosition().getY(), time, 'H'));
            if (getModel().isObstacle(new Position(bomb.getPosition().getX() - left, bomb.getPosition().getY())))
                break;
        }
        for (int right = 1; right <= bomb.getFlames() && !getModel().isWall(new Position(bomb.getPosition().getX() + right, bomb.getPosition().getY())); right++) {
            flames.add(new Flame(bomb.getPosition().getX() + right, bomb.getPosition().getY(), time, 'H'));
            if (getModel().isObstacle(new Position(bomb.getPosition().getX() + right, bomb.getPosition().getY())))
                break;
        }
        getModel().addflames(flames);
    }

    public void explodeBomb(Bomb bomb, long time) {
        createFlames(bomb,time);

        for (Flame flame : getModel().getFlames()) {
            destroyObstacle(flame.getPosition());
            killEnemy(flame.getPosition());
            if (flame.getPosition().equals(getModel().getBomberman().getPosition()) && !getModel().getBomberman().canFlamepass())
                getModel().getBomberman().setHp(getModel().getBomberman().getHp() - 1);
        }
    }

    public void destroyObstacle(Position position) {
        for (Obstacle obstacle : getModel().getObstacles())
            if (obstacle.getPosition().equals(position)) {
                getModel().removeobstacles(obstacle);
                break;
            }
    }

    public void killEnemy(Position position) {
        for (Enemy enemy : getModel().getEnemies())
            if (enemy.getPosition().equals(position)) {
                getModel().removeEnemies(enemy);
                break;
            }
    }
}
