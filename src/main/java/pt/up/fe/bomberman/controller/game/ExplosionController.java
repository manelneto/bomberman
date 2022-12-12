package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomb;
import pt.up.fe.bomberman.model.game.elements.Explosion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExplosionController extends GameController {
    public ExplosionController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        List<Explosion> explosions = new ArrayList<>();
        for (Explosion explosion : getModel().getExplosions())
            if (time - 1000 <= explosion.getTime())
                explosions.add(explosion);
        getModel().setExplosions(explosions);
    }
}
