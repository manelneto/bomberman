package pt.up.fe.bomberman.model.game.elements;

public class Powerup extends Element {
    enum powerupType {Bombpass,Bombs,Flamepass,Flames,Health,Speed,Wallpass}
    private powerupType type;
    public Powerup(int x, int y) {
        super(x, y);
    }
}
