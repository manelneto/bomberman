package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Powerup;
import pt.up.fe.bomberman.model.game.elements.powerup.*;

public class BombermanController extends GameController {
    private long lastMovementTime;
    public BombermanController(Arena arena) {
        super(arena);
    }

    public void moveBombermanUp() {
        getModel().getBomberman().setDirection('U');
        moveBomberman(getModel().getBomberman().getPosition().getUp());
    }

    public void moveBombermanDown() {
        getModel().getBomberman().setDirection('D');
        moveBomberman(getModel().getBomberman().getPosition().getDown());
    }

    public void moveBombermanLeft() {
        getModel().getBomberman().setDirection('L');
        moveBomberman(getModel().getBomberman().getPosition().getLeft());
    }

    public void moveBombermanRight() {
        getModel().getBomberman().setDirection('R');
        moveBomberman(getModel().getBomberman().getPosition().getRight());
    }

    private void moveBomberman(Position position) {
        if (getModel().inArena(position) && !getModel().isWall(position) && (!getModel().isObstacle(position) || getModel().getBomberman().canWallpass()) && (!getModel().isBomb(position) || getModel().getBomberman().canBombpass())) {
            getModel().getBomberman().setPosition(position);
            if (getModel().isEnemy(position))
                getModel().getBomberman().setHp(getModel().getBomberman().getHp() - 1);
            if (getModel().isPowerup(position)) {
                applyEffect(getModel().findPowerup(position));
                getModel().removePowerup(position);
            }
        }
    }

    private void applyEffect(Powerup powerup) {
        if (powerup instanceof Bombs)
            getModel().getBomberman().setBombs(getModel().getBomberman().getBombs() + 1);
        if (powerup instanceof Flames)
            getModel().getBomberman().setFlames(getModel().getBomberman().getFlames() + 1);
        if (powerup instanceof Speed)
            getModel().getBomberman().setSpeed(getModel().getBomberman().getSpeed() + 1);
        if (powerup instanceof Wallpass)
            getModel().getBomberman().setWallpass(true);
        if (powerup instanceof Bombpass)
            getModel().getBomberman().setBombpass(true);
        if (powerup instanceof Flamepass)
            getModel().getBomberman().setFlamepass(true);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMovementTime > (10/getModel().getBomberman().getSpeed())) {
            if (action == GUI.ACTION.UP)
                moveBombermanUp();
            if (action == GUI.ACTION.RIGHT)
                moveBombermanRight();
            if (action == GUI.ACTION.DOWN)
                moveBombermanDown();
            if (action == GUI.ACTION.LEFT)
                moveBombermanLeft();
            lastMovementTime = time;
        }
        if (action == GUI.ACTION.SPACE && getModel().getBomberman().getBombs() - getModel().getBombs().size() > 0)
            getModel().createBomb(time);
    }
}
