package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Flame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlameController extends GameController {
    public FlameController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        List<Flame> flames = new ArrayList<>();
        for (Flame flame : getModel().getFlames())
            if (time - 250 < flame.getTime())
                flames.add(flame);
        getModel().setFlames(flames);
    }
}
