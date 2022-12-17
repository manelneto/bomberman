package pt.up.fe.bomberman.model.game.elements;

public  class Enemy extends Element {

    public enum enemyType {Balloom, Doll, Kondria, Minvo, Oneal, Ovapi, Pass, Pontan}
    enemyType type;
    private final int speed;
    private final int smart;
    private final boolean wallpass;
    private char direction;
    private long lastMovementTime;

    public Enemy(int x, int y, enemyType type) {
        super(x, y);
        this.type=type;
        this.lastMovementTime = 0;
        switch (type) {
            case Doll:
                this.speed = 3;
                this.smart = 1;
                this.wallpass = false;
                break;
            case Kondria:
                this.speed = 1;
                this.smart = 3;
                this.wallpass = true;
                break;
            case Minvo:
                this.speed = 4;
                this.smart = 2;
                this.wallpass = false;
                break;
            case Oneal:
                this.speed = 3;
                this.smart = 2;
                this.wallpass = false;
                break;
            case Ovapi:
                this.speed = 2;
                this.smart = 2;
                this.wallpass = true;
                break;
            case Pass:
                this.speed = 4;
                this.smart = 3;
                this.wallpass = false;
                break;
            case Pontan:
                this.speed = 4;
                this.smart = 3;
                this.wallpass = true;
                break;
            default:
                this.speed = 2;
                this.smart = 1;
                this.wallpass = false;
                break;
        }

        randomDirection();
    }

    public int getSpeed() {
        return speed;
    }
    public int getSmart() {
        return smart;
    }
    public boolean canWallpass() {
        return wallpass;
    }
    public enemyType getType() {
        return type;
    }

    public long getLastMovementTime() {
        return lastMovementTime;
    }
    public char getDirection() {
        return direction;
    }
    public void setDirection(char dic) {
         direction=dic;
    }
    public void randomDirection() {
        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                setDirection('U');
                break;
            case 1:
                setDirection('D');
                break;
            case 2:
                setDirection('L');
                break;
            case 3:
                setDirection('R');
                break;
        }
    }

    public void setLastMovementTime(long time) {
        this.lastMovementTime = time;
    }


}
