package pt.up.fe.bomberman.model.elements;

public class Bomberman extends Element {
    private int speed = 1;
    private int usableBombs = 1;
    private int bombRange = 1;
    private boolean bombpass = false;
    private boolean wallpass = false;
    private boolean flamepass = false;
    private boolean detonator = false;

    public Bomberman(int x, int y) {
        super(x, y);
    }

    public int getSpeed() {
        return speed;
    }
    public int getUsableBombs() {
        return usableBombs;
    }
    public boolean canBombpass() {
        return bombpass;
    }
    public boolean canWallpass() {
        return wallpass;
    }
    public boolean canFlamepass() {
        return flamepass;
    }
    public boolean canDetonate() {
        return detonator;
    }
    public int getBombRange() {return bombRange;}


    //setters
    void increaseSpeed(){speed += 0.5;}
    void increaseMaxBombs(){ usableBombs++; }
    public void increaseBombRange() { bombRange++;}
    void ableBombpass() { bombpass = true;}
    void ableWallpass() { wallpass = true;}
    void ableDetonate() { detonator = true;}
    void setFlamepass() {flamepass = true;}
}
