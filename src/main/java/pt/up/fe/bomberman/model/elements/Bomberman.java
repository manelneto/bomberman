package pt.up.fe.bomberman.model.elements;

public class Bomberman extends Element {
    private int speed = 1;
    private int maxBombs = 1;
    private boolean bombpass = false;
    private boolean wallpass = false;
    private boolean invencible = false;
    private boolean detonator = false;

    public Bomberman(int x, int y) {
        super(x, y);
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxBombs() {
        return maxBombs;
    }

    public boolean canBombpass() {
        return bombpass;
    }

    public boolean canWallpass() {
        return wallpass;
    }

    public boolean isInvencible() {
        return invencible;
    }

    public boolean canDetonate() {
        return detonator;
    }

    //setters
    void increaseSpeed(){speed += 0.5;}
    void increaseMaxBombs(){ maxBombs++; }

    void ableBombpass() { bombpass = true;}
    void ableWallpass() { wallpass = true;}
    void ableDetonate() { detonator = true;}
    void setInvencible() {invencible = true;}
}
