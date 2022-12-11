package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.game.elements.Enemy;

public class Doll extends Enemy {
    public Doll(int x, int y) {
        super(x, y,3,1,false);
    }

    @Override
    public char getType() {
        return 'D';
    }
}
