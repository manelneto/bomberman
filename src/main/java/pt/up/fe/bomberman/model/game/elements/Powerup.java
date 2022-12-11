package pt.up.fe.bomberman.model.game.elements;

public class Powerup extends Element {
    private Effect effect;

    public Powerup(int x, int y, Effect effect) {
        super(x, y);
        this.effect = effect;
    }

    public enum Effect {
        Bombpass,
        Bombs,
        Detonator,
        Flamepass,
        Flames,
        Speed,
        Wallpass
    }

    public Effect getEffect(){
        return effect;
    }
}
