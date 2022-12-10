package pt.up.fe.bomberman.model.game.elements.powerup;

import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.game.elements.Powerup;

public class Bombs extends Powerup {
    public Bombs(int x, int y) {
        super(x, y, Effect.Bombs);
    }

}

