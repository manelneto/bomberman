package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.Enemy;

public class Oneal extends Enemy {
    public Oneal(int x, int y) {
        super(x, y,3,2,false);
    }

    @Override
    public char getType() {
        return 'O';
    }
}
