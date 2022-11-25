package pt.up.fe.bomberman.model.game.elements.powerup;

import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.game.elements.Powerup;

public class Flames extends Powerup {
    public Flames(int x, int y) {
        super(x, y);
    }

    @Override
    public void applyEffect(Bomberman bomberman) {
        bomberman.increaseBombRange();
    }
}
