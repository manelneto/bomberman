package pt.up.fe.bomberman.model.elements.powerup;

import pt.up.fe.bomberman.model.elements.Bomberman;
import pt.up.fe.bomberman.model.elements.Powerup;

public class Flames extends Powerup {
    public Flames(int x, int y) {
        super(x, y);
    }

    @Override
    public void applyEffect(Bomberman bomberman) {
        //bombs.setRange(bombs.getRange()++);
    }
}
