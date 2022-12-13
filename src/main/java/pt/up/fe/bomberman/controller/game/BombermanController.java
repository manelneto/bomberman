
package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Powerup;

public class BombermanController extends GameController {
    private long lastMovementTime;
    public BombermanController(Arena arena) {
        super(arena);
    }

    public void moveBombermanLeft() {
        getModel().getBomberman().faceLeft();
        moveBomberman(getModel().getBomberman().getPosition().getLeft());
    }

    public void moveBombermanRight() {
        getModel().getBomberman().faceRight();
        moveBomberman(getModel().getBomberman().getPosition().getRight());
    }

    public void moveBombermanUp() {
        getModel().getBomberman().faceUp();
        moveBomberman(getModel().getBomberman().getPosition().getUp());
    }

    public void moveBombermanDown() {
        getModel().getBomberman().faceDown();
        moveBomberman(getModel().getBomberman().getPosition().getDown());
    }

    private void moveBomberman(Position position) {
        if (getModel().inArena(position)&& !getModel().isObstacle(position) &&(!getModel().isWall(position) || getModel().getBomberman().canWallpass() )&& (!getModel().isBomb(position) || getModel().getBomberman().canBombpass())) {
            getModel().getBomberman().setPosition(position);
            if (getModel().isEnemy(position)) getModel().getBomberman().decreaseHp();
            if (getModel().isPowerup(position)) {applyEffect(getModel().findPowerup(position));getModel().removePowerup(position);}
        }
    }

    private void applyEffect(Powerup powerup) {
        switch (powerup.getEffect()) {
            case Bombpass : {getModel().getBomberman().ableBombpass();break;}
            case Bombs : {getModel().getBomberman().increaseUsableBombs();break;}
            case Detonator:{ getModel().getBomberman().ableDetonate();break;}
            case Flamepass :{getModel().getBomberman().ableFlamepass();break;}
            case Flames : {getModel().getBomberman().increaseBombRange();break;}
            case Speed : {getModel().getBomberman().increaseSpeed();break;}
            case Wallpass :{ getModel().getBomberman().ableWallpass();break;}
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMovementTime > (250/getModel().getBomberman().getSpeed())) {
            if (action == GUI.ACTION.UP) {moveBombermanUp(); this.lastMovementTime = time;}
            if (action == GUI.ACTION.RIGHT){ moveBombermanRight(); this.lastMovementTime = time;}
            if (action == GUI.ACTION.DOWN) {moveBombermanDown(); this.lastMovementTime = time;}
            if (action == GUI.ACTION.LEFT) {moveBombermanLeft(); this.lastMovementTime = time;}
            if (action == GUI.ACTION.SPACE && getModel().getBomberman().getUsableBombs() - getModel().getBombs().size() > 0) {getModel().createBomb(time); this.lastMovementTime = time;}
        }
    }
}
