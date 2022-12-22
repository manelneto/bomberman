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
                applyEffect(getModel().getPowerup(position));
                getModel().removePowerup(position);
            }
        }
    }

    public void applyEffect(Powerup powerup) {
        if (powerup.getType() == Powerup.Type.Bombs)
            getModel().getBomberman().setBombs(getModel().getBomberman().getBombs() + 1);
        if (powerup.getType() == Powerup.Type.Flames)
            getModel().getBomberman().setFlames(getModel().getBomberman().getFlames() + 1);
        if (powerup.getType() == Powerup.Type.Speed)
            getModel().getBomberman().setSpeed(getModel().getBomberman().getSpeed() + 1);
        if (powerup.getType() == Powerup.Type.Wallpass)
            getModel().getBomberman().setWallpass(true);
        if (powerup.getType() == Powerup.Type.Health)
            getModel().getBomberman().setHp(getModel().getBomberman().getHp() + 1);
        if (powerup.getType() == Powerup.Type.Bombpass)
            getModel().getBomberman().setBombpass(true);
        if (powerup.getType() == Powerup.Type.Flamepass)
            getModel().getBomberman().setFlamepass(true);
    }

    @Override

    //if (!isBomb(bomberman.getPosition()) && !isObstacle(bomberman.getPosition()) && !isWall(bomberman.getPosition()) && !isPowerup(bomberman.getPosition()) && !isPowerup(bomberman.getPosition()))

    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.SPACE && getModel().getBomberman().getBombs() - getModel().getBombs().size() > 0)
            getModel().createBomb(time);
        if (time - lastMovementTime < (150/getModel().getBomberman().getSpeed())) return;
        if (action == GUI.ACTION.UP) {moveBombermanUp(); this.lastMovementTime = time;}
        if (action == GUI.ACTION.RIGHT){moveBombermanRight(); this.lastMovementTime = time;}
        if (action == GUI.ACTION.DOWN) {moveBombermanDown(); this.lastMovementTime = time;}
        if (action == GUI.ACTION.LEFT) {moveBombermanLeft(); this.lastMovementTime = time;}


    }


}
