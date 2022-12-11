package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;

import java.io.IOException;

public class BombController extends GameController {
    public BombController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        /*if ((time-getModel().getBomb().getTime())>2000) {
            getModel().Explode(time);
        }*/
    }
}
