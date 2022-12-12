package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BombController extends GameController {
    public BombController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        List<Bomb> bombs = new ArrayList<>();
        for (Bomb bomb : getModel().getBombs())
            if (time - 2000 > bomb.getTime())
                getModel().explodeBomb(bomb, time);
            else
                bombs.add(bomb);
        getModel().setBombs(bombs);
    }
}
