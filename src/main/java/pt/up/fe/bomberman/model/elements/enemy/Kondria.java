package pt.up.fe.bomberman.model.elements.enemy;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.elements.Enemy;

public class Kondria extends Enemy {
    public Kondria(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMove(Position position) {
        return false;
    }

    private final int speed = 1;
    private final int smart = 3;
    private final boolean wallpass = true;
}
