package pt.up.fe.bomberman.model.game.elements;

public class Explosion extends Element{
    private long time;
    private char type;

    public Explosion(int x, int y,long time,char type) {
        super(x, y);
        this.time=time;
        this.type=type;
    }
    public long GetTime(){
        return time;
    }

    public char getType() {
        return type;
    }
}
