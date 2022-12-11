package pt.up.fe.bomberman.model.game.elements;

public class Explosion extends Element{
    private final long time;

    public Explosion(int x, int y, long time) {
        super(x, y);
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
