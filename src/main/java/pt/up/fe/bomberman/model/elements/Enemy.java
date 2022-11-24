package pt.up.fe.bomberman.model.elements;

import pt.up.fe.bomberman.model.Position;

public abstract class Enemy extends Element {
    public Enemy(int x, int y) {
        super(x, y);
    }

    private int speed;
    private int smart;
    private boolean wallpass;

    public abstract boolean canMove(Position position);
}

