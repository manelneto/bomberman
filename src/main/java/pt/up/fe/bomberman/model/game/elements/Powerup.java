package pt.up.fe.bomberman.model.game.elements;

import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.game.elements.Element;

public abstract class Powerup extends Element {
    public Powerup(int x, int y) {
        super(x, y);
    }

    public abstract void applyEffect(Bomberman bomberman); // aplica o efeito do powerup

}
