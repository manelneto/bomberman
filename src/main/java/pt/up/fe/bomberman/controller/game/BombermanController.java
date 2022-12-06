
package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;

import pt.up.fe.bomberman.model.game.arena.Arena;

public class BombermanController extends GameController {
    public BombermanController(Arena arena) {
        super(arena);
    }

    public void moveBombermanLeft() {
        moveBomber(getModel().getBomberman().getPosition().getLeft());
    }

    public void moveBombermanRight() {
        moveBomber(getModel().getBomberman().getPosition().getRight());
    }

    public void moveBombermanUp() {
        moveBomber(getModel().getBomberman().getPosition().getUp());
    }

    public void moveBombermanDown() {
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
        if (action == GUI.ACTION.UP) moveBombermanUp();
        if (action == GUI.ACTION.RIGHT) moveBombermanRight();
        if (action == GUI.ACTION.DOWN) moveBombermanDown();
        if (action == GUI.ACTION.LEFT) moveBombermanLeft();
    }


}

