package pt.up.fe.bomberman.model.elements.enemy;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.elements.Enemy;
import pt.up.fe.bomberman.model.elements.Wall;

public class Balloom extends Enemy {
    public Balloom(int x, int y) {
        super(x, y);
    }

    private final int speed = 2;
    private final int smart = 1;
    private final boolean wallpass = false;

    @Override
    public boolean canMove(Position position){
        //for (Wall wall : walls) if (wall.getPosition() == position) return false;

        return true;
    }
}
