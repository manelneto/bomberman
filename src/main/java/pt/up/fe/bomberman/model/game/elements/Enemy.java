package pt.up.fe.bomberman.model.game.elements;

public abstract class Enemy extends Element {
    public Enemy(int x, int y, int speed, int smart, boolean wallpass) {
        super(x, y);
        this.speed = speed;
        this.smart = smart;
        this.wallpass = wallpass;
    }
    public char getType() {
        return 'B';
    }

    private final int speed;
    private final int smart;
    private final boolean wallpass;

    //canMove personalized based on speed, smart and wallpass

}
