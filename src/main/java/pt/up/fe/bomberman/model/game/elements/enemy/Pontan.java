package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.util.Arrays;

public class Pontan extends Enemy {
    public Pontan(int x, int y) {
        super(x, y,4, Arrays.asList(new Character[]{'U', 'R', 'R', 'R', 'R', 'R','L','L','L','L','L','L','L','L','L', 'R', 'R', 'R', 'R', 'R', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'D', 'D', 'D', 'D', 'D', 'D','L','L','L','L','L','L','L','L', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'R', 'R', 'R', 'R','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L'}),true);
    }
}
