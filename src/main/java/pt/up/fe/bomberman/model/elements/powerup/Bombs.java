package pt.up.fe.bomberman.model.elements.powerup;

import pt.up.fe.bomberman.model.elements.Bomberman;
import pt.up.fe.bomberman.model.elements.Powerup;

public class Bombs extends Powerup {
    public Bombs(int x, int y) {
        super(x, y);
    }

    @Override
    public void applyEffect(Bomberman bomberman) {
        //max_bombs++;
        return;
    }
}
