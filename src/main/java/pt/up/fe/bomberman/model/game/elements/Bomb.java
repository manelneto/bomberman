package pt.up.fe.bomberman.model.game.elements;

public class Bomb extends Element {
    private final long time;
    private final int explosionRadius;
    public Bomb(int x, int y, long time, int explosionRadius) {
        super(x, y);
        this.time = time;
        this.explosionRadius = explosionRadius;
    }

    public long getTime() {
        return time;
    }

    public int getExplosionRadius() {
        return explosionRadius;
    }
}
