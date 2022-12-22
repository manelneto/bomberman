package pt.up.fe.bomberman.model.game.elements;

import java.util.List;

public abstract class Enemy extends Element {


    private List<Character> patern;
    private int paternindex;
    private long lastMovementTime;
    private boolean wallpass;

    private int speed;

    public Enemy(int x, int y, int speed,List<Character> patern,boolean wallpass) {
        super(x, y);

        this.lastMovementTime = 0;
        this.speed=speed;
        this.wallpass=wallpass;
        this.patern=patern;
        paternindex=0;

    }

    public long getLastMovementTime() {
        return lastMovementTime;
    }

    public Character getNextmovement(){
        paternindex++;
        if(paternindex>=patern.size()){
            paternindex=0;
        }
        return patern.get(paternindex);
    }

    public void setLastMovementTime(long time) {
        this.lastMovementTime = time;
    }

    public int getSpeed() {
        return speed;
    }
    public boolean canWallpass(){
        return wallpass;
    }
}
