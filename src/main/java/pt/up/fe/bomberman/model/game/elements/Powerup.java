package pt.up.fe.bomberman.model.game.elements;

public class Powerup extends Element {
    public enum Type {Bombpass,Bombs,Flamepass,Flames,Health,Speed,Wallpass}
    private Type type;
    public Powerup(int x, int y, Type type) {
        super(x, y);
        this.type=type;

    }

    public Type getType() {
        return type;
    }
}
