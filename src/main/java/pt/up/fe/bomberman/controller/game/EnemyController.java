package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.io.IOException;

public class EnemyController extends GameController {
    public EnemyController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        for (Enemy enemy : getModel().getEnemies()) {
            if (time - enemy.getLastMovementTime() < 1000 / getSpeed(enemy.getType())) {
                    continue;
            }
            if (getSmart(enemy.getType()) == 1) {
                if (!canMove(enemy, enemy.getPosition().getDirectionalNeighbour(enemy.getDirection())))
                    invertDirection(enemy);
                if (!canMove(enemy, enemy.getPosition().getDirectionalNeighbour(enemy.getDirection())))
                    rotateDirection(enemy);
                moveEnemy(enemy, enemy.getPosition().getDirectionalNeighbour(enemy.getDirection()));
            }
            if (getSmart(enemy.getType()) == 2)
                moveEnemy(enemy, enemy.getPosition().getRandomDirectionalNeighbour(enemy.getDirection()));
            if (getSmart(enemy.getType()) == 3)
                moveEnemy(enemy, enemy.getPosition().getRandomNeighbour());
            enemy.setLastMovementTime(time);

        }
    }

    private boolean canMove(Enemy enemy, Position position) {
        return getModel().inArena(position) && !getModel().isWall(position) && (!getModel().isObstacle(position) || canWallpass(enemy.getType())) && !getModel().isBomb(position) && !getModel().isEnemy(position) && !getModel().isPowerup(position);
    }


    private void moveEnemy(Enemy enemy, Position position) {
        if (canMove(enemy, position)) {
            enemy.setPosition(position);
            if (getModel().getBomberman().getPosition().equals(position))
                getModel().getBomberman().setHp(getModel().getBomberman().getHp() - 1);
        }

    }

    public void invertDirection(Enemy enemy) {
        char direction = enemy.getDirection();
        switch (direction) {
            case 'U':
                enemy.setDirection('D');
                break;
            case 'D':
                enemy.setDirection('U');
                break;
            case 'L':
                enemy.setDirection('R');
                break;
            case 'R':
                enemy.setDirection('L');
                break;
        }
    }

    public void rotateDirection(Enemy enemy) {
        char direction = enemy.getDirection();
        switch (direction) {
            case 'U':
                enemy.setDirection('R');
                break;
            case 'R':
                enemy.setDirection('D');
                break;
            case 'D':
                enemy.setDirection('L');
                break;
            case 'L':
                enemy.setDirection('U');
                break;
        }
    }

    private int getSpeed(Enemy.Type type) {
        switch (type) {
            case Doll:
            case Oneal:
                return 3;
            case Kondria:
                return 1;
            case Minvo:
            case Pontan:
            case Pass:
                return 4;
            case Ovapi:
            case Balloom:
            default:
                return 2;
        }
    }

    private int getSmart(Enemy.Type type){
        switch(type){

            case Kondria:
            case Pass:
            case Pontan:
                return 3;
            case Minvo:
            case Oneal:
            case Ovapi:
                return 2;
            case Doll:
            case Balloom:
            default:
                return 1;

        }

    }
    private boolean canWallpass(Enemy.Type type){

        switch (type) {
            case Kondria:
            case Ovapi:
            case Pontan:
                return true;
            case Balloom:
            case Doll:
            case Minvo:
            case Oneal:
            case Pass:
            default:
                return false;

        }
    }
}

