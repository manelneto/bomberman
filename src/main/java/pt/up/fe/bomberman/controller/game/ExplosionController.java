package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;

import java.io.IOException;

public class ExplosionController extends GameController {
    public ExplosionController(Arena arena) {
        super(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if ((time-getModel().GetExplosion().get(0).GetTime())>2000) {
            getModel().ClearExplosion();
        }
    }
}
