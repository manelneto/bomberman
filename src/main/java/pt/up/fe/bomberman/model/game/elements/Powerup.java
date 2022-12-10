package pt.up.fe.bomberman.model.game.elements;

public class Powerup extends Element {
    private Effect Effect;

    public Powerup(int x, int y, Effect efeito) {
        super(x, y);
        this.Effect = efeito;
    }

    public enum Effect{
        Bombpass,
        Bombs,
        Detonator,
        Flamepass,
        Flames,
        Speed,
        Wallpass
    }

    public Effect getEffect(){
        return Effect;
    }
}
