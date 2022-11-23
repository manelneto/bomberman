package pt.up.fe.bomberman.model.elements;

public abstract class Powerup extends Element{
    public Powerup(int x, int y) {
        super(x, y);
    }

    public abstract void applyEffect(); // aplica o efeito do powerup
}
