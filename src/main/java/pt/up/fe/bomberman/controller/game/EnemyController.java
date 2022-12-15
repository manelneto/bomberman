
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
                    moveEnemy(monster, movePaternrandom(monster));
            this.lastMovementTime = time;
        }
    }
    protected Position movePaternrandom(Enemy monster){

        int n = (int) (Math.random() * 4);

        switch (n) {
            case 0:
                monster.setDirection('U');
                return monster.getPosition().getUp();
            case 1:
                monster.setDirection('D');
                return monster.getPosition().getDown();
            case 2:
                monster.setDirection('R');
                return monster.getPosition().getRight();
            default:
                monster.setDirection('L');
                return monster.getPosition().getLeft();


        }
    }
    protected boolean canmoveto(Enemy monster,Position position){
        return getModel().inArena(position) && !getModel().isWall(position) && (!getModel().isObstacle(position)  || monster.canWallpass()) && !getModel().isEnemy(position) && !getModel().isBomb(position);
    }
    protected Position getmovePatern(Enemy monster){
        return movePaternrandom(monster);
    }

    protected void moveEnemy(Enemy monster, Position position) {
        if (canmoveto(monster,position)) {
            monster.setPosition(position);
            if (getModel().getBomberman().getPosition().equals(position))
                getModel().getBomberman().decreaseHp();
        }

    }
}

