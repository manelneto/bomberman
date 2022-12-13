
package pt.up.fe.bomberman.controller.game;


import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.io.IOException;

public abstract class EnemyController extends GameController {

    protected long lastMovementTime = 0;

    public EnemyController(Arena arena) {

        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovementTime > 350) {
            for (Enemy monster : getModel().getEnemies())
                    moveEnemy(monster, monster.getmovePatern());
            this.lastMovementTime = time;
        }
    }


    protected void moveEnemy(Enemy monster, Position position) {
        for(int i=0;i<4;i++)
            if (getModel().inArena(position) && !getModel().isWall(position) && (!getModel().isObstacle(position)  || monster.canWallpass()) && !getModel().isEnemy(position) && !getModel().isBomb(position)) {
                monster.setPosition(position);
                if (getModel().getBomberman().getPosition().equals(position))
                    getModel().getBomberman().decreaseHp();

            }
            monster.movePaternrandom();


    }
}

