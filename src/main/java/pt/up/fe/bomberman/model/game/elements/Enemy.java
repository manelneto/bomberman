package pt.up.fe.bomberman.model.game.elements;

public  class Enemy extends Element {

    public enum Type {Balloom, Doll, Kondria, Minvo, Oneal, Ovapi, Pass, Pontan}
    Type type;

    private char direction;
    private long lastMovementTime;

    public Enemy(int x, int y, Type type) {
        super(x, y);
        this.type=type;
        this.lastMovementTime = 0;

        randomDirection();
    }

    public Type getType() {
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
