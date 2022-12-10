package pt.up.fe.bomberman.model.game.elements;

public class Bomb extends Element{
    private long time;
    private int explodeRadius;
    public Bomb(int x, int y,long time,int Radius) {
        super(x, y);
        this.time=time;
        explodeRadius=Radius;
    }

    public long getTime() {
        return time;
    }

    public int getExplodeRadius() {
        return explodeRadius;
    }
}
