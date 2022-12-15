package pt.up.fe.bomberman.model.game.elements;

public abstract class Enemy extends Element {
    private final int speed;
    private final int smart;
    private final boolean wallpass;
    private char direction;
    private long lastMovementTime;

    public Enemy(int x, int y, int speed, int smart, boolean wallpass) {
        super(x, y);
        this.speed = speed;
        this.smart = smart;
        this.wallpass = wallpass;
        this.lastMovementTime = 0;

        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                this.direction = 'U';
                break;
            case 1:
                this.direction = 'D';
                break;
            case 2:
                this.direction = 'L';
                break;
            case 3:
                this.direction = 'R';
                break;
        }
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
    public long getLastMovementTime() {
        return lastMovementTime;
    }
    public char getDirection() {
        return direction;
    }

    public void setLastMovementTime(long time) {
        this.lastMovementTime = time;
    }

    public void invertDirection() {
        switch (direction) {
            case 'U':
                direction = 'D';
                break;
            case 'D':
                direction = 'U';
                break;
            case 'L':
                direction = 'R';
                break;
            case 'R':
                direction = 'L';
                break;
        }
    }

    public void rotateDirection() {
        switch (direction) {
            case 'U':
                direction = 'R';
                break;
            case 'R':
                direction = 'D';
                break;
            case 'D':
                direction = 'L';
                break;
            case 'L':
                direction = 'U';
                break;
        }
    }
}
