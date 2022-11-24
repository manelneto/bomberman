package pt.up.fe.bomberman.model.elements.powerup;

import pt.up.fe.bomberman.model.elements.Bomberman;
import pt.up.fe.bomberman.model.elements.Powerup;

public class Speed extends Powerup {
    public Speed(int x, int y) {
        super(x, y);
    }

    @Override
    public void applyEffect(Bomberman bomberman) {
        bomberman.increaseSpeed();
    }
}
