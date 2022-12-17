package pt.up.fe.bomberman.model.game.elements;

public class Powerup extends Element {
    public enum powerupType {Bombpass,Bombs,Flamepass,Flames,Health,Speed,Wallpass}
    private powerupType type;
    public Powerup(int x, int y,powerupType type) {
        super(x, y);
        this.type=type;

    }

    public powerupType getType() {
        return type;
    }
}
