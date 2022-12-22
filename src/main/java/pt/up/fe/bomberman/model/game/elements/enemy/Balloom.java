package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.util.Arrays;

public class Balloom extends Enemy {
    public Balloom(int x, int y) {
        super(x, y,2, Arrays.asList(new Character[]{'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L'}),false);
    }
}
