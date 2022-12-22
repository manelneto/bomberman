package pt.up.fe.bomberman.model.game.elements;

public class Powerup extends Element {
    public enum EFFECT {BOMBPASS, BOMBS, FLAMEPASS, FLAMES, HEALTH, SPEED, WALLPASS}

    private final EFFECT effect;

    public Powerup(int x, int y, EFFECT effect) {
        super(x, y);
        this.effect = effect;
    }

    public EFFECT getEffect() {
        return effect;
    }
}
