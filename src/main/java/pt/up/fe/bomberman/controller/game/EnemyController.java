package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Enemy;
import pt.up.fe.bomberman.model.game.elements.enemy.*;

import java.io.IOException;

public class EnemyController extends GameController {
    public EnemyController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        for (Enemy enemy : getModel().getEnemies()) {
            if (time - enemy.getLastMovementTime() < 1000 / enemy.getSpeed()) {
                    continue;
            }

            moveEnemy(enemy);
            enemy.setLastMovementTime(time);

        }
    }

    private boolean canMove(Enemy enemy, Position position) {
        return getModel().inArena(position) && !getModel().isWall(position) && (!getModel().isObstacle(position) || enemy.canWallpass()) && !getModel().isBomb(position) && !getModel().isEnemy(position) && !getModel().isPowerup(position);
    }


    private void moveEnemy(Enemy enemy) {
        Position position=enemy.getPosition().getDirectionalNeighbour(enemy.getNextmovement());
        for (int i = 0; i < 10; i++){
            if(canMove(enemy, position)) break;
            position=enemy.getPosition().getDirectionalNeighbour(enemy.getNextmovement());


        }
        if (canMove(enemy, position)) {
            enemy.setPosition(position);
            if (getModel().getBomberman().getPosition().equals(position))
                getModel().getBomberman().setHp(getModel().getBomberman().getHp() - 1);
        }

    }


}

