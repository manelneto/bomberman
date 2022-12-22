package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class Doll extends Enemy {
    public Doll(int x, int y) {

        super(x, y,3,Arrays.asList(new Character[]{'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L','L'}),false);
    }
}
