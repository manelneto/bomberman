package pt.up.fe.bomberman.model.game.elements;

public abstract class Explosion extends Element{
    protected long time;

    public Explosion(int x, int y,long time) {
        super(x, y);
        this.time=time;
    }
    public long GetTime(){
        return time;
    }
}
