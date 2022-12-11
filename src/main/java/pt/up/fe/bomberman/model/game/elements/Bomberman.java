package pt.up.fe.bomberman.model.game.elements;

public class Bomberman extends Element {
    private int hp = 1;
    private char action;
    private int speed = 1;
    private int usableBombs = 1;
    private int bombRange = 1;
    private boolean bombpass = false;
    private boolean wallpass = false;
    private boolean flamepass = false;
    private boolean detonator = false;

    public Bomberman(int x, int y) {
        super(x, y);
        action = 'D';
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
    public boolean canDetonate() { return detonator; }
    public int getBombRange() { return bombRange; }

    public void increaseSpeed() { speed++; }
    public void increaseUsableBombs() { usableBombs++; }
    public void increaseBombRange() { bombRange++; }
    public void ableBombpass() { bombpass = true; }
    public void ableWallpass() { wallpass = true; }
    public void ableDetonate() { detonator = true; }
    public void ableFlamepass() { flamepass = true; }

    public int getHp() { return hp; }

    public char getAction() { return action; }

    public void decreaseHp(){
        hp--;
    }
    public void faceDown(){
        action = 'D';
    }
    public void faceUp(){
        action = 'U';
    }
    public void faceRight(){
        action = 'R';
    }
    public void faceLeft(){
        action = 'L';
    }
}
