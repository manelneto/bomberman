
package pt.up.fe.bomberman.controller.game;


import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class EnemyController extends GameController {
    long lastMovementTimeBallons = 0;
    long lastMovementTimeOneal = 0;
    long lastMovementTimeDoll = 0;



    public EnemyController(Arena arena) {

        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovementTimeBallons > 350) {
            for (Enemy monster : getModel().getEnemies())
                if(monster.getType()=='B')
                    moveEnemy(monster, monster.movePatern());
            this.lastMovementTimeBallons = time;
        }
        if (time - lastMovementTimeOneal > 100) {
            for (Enemy monster : getModel().getEnemies())
                if(monster.getType()=='O')
                    moveEnemy(monster, monster.movePatern());
            this.lastMovementTimeOneal = time;
        }
        if (time - lastMovementTimeDoll > 450) {
            for (Enemy monster : getModel().getEnemies())
                if(monster.getType()=='D')
                    moveEnemy(monster, monster.movePatern());
            this.lastMovementTimeDoll = time;
        }
    }


    protected void moveEnemy(Enemy monster, Position position) {

        if (getModel().inArena(position) && !getModel().isObstacle(position) && (!getModel().isWall(position) || monster.canWallpass()) && !getModel().isEnemy(position) && !getModel().isBomb(position)) {
            monster.setPosition(position);
            if (getModel().getBomberman().getPosition().equals(position))
                getModel().getBomberman().decreaseHp();

        }else{
            position=monster.getPosition().getRandomNeighbour();
            if (getModel().inArena(position) && ((!getModel().isWall(position) && !getModel().isObstacle(position)) || monster.canWallpass()) && !getModel().isEnemy(position) && !getModel().isBomb(position)) {
                monster.setPosition(position);
                if (getModel().getBomberman().getPosition().equals(position))
                    getModel().getBomberman().decreaseHp();

            }
        }

    }

}

