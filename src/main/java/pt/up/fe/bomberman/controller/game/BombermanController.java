
package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;

import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomb;

public class BombermanController extends GameController {
    private long lastMovementTime;
    public BombermanController(Arena arena) {
        super(arena);
    }

    public void moveBombermanLeft() {

        getModel().getBomberman().Face_left();
        moveBomber(getModel().getBomberman().getPosition().getLeft());
    }

    public void moveBombermanRight() {
        getModel().getBomberman().Face_right();
        moveBomber(getModel().getBomberman().getPosition().getRight());
    }

    public void moveBombermanUp() {
        getModel().getBomberman().Face_Up();
        moveBomber(getModel().getBomberman().getPosition().getUp());
    }

    public void moveBombermanDown() {

        getModel().getBomberman().Face_down();
        moveBomber(getModel().getBomberman().getPosition().getDown());
    }

    private void moveBomber(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getBomberman().setPosition(position);
            if (getModel().isEnemy(position)) getModel().getBomberman().TakesHit();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMovementTime > (250/getModel().getBomberman().getSpeed())) {



            if (action == GUI.ACTION.UP) {moveBombermanUp();this.lastMovementTime = time;}
            if (action == GUI.ACTION.RIGHT){ moveBombermanRight();this.lastMovementTime = time;}
            if (action == GUI.ACTION.DOWN){ moveBombermanDown();this.lastMovementTime = time;}
            if (action == GUI.ACTION.LEFT){ moveBombermanLeft();this.lastMovementTime = time;}
            if (getModel().HasBomb()==false && action == GUI.ACTION.SPACE ){ getModel().CreateBomb(time);this.lastMovementTime = time;}
        }
    }


}

