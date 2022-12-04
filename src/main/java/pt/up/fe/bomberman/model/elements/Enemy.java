package pt.up.fe.bomberman.model.elements;

import pt.up.fe.bomberman.model.Position;

public abstract class Enemy extends Element {
    public Enemy(int x, int y, int speed, int smart, boolean wallpass) {
        super(x, y);
        this.speed = speed;
        this.smart = smart;
        this.wallpass = wallpass;
    }

    private final int speed;
    private final int smart;
    private final boolean wallpass;

    public abstract boolean canMove(Position position);
}

