package pt.up.fe.bomberman.controller;

import org.junit.jupiter.api.BeforeEach;
import pt.up.fe.bomberman.controller.game.BombermanController;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomb;


import java.util.Arrays;

public class BombControllerTest {
    private BombermanController controller;
    private Bomb bomb;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);

        bomb = new Bomb(10, 10,0,1);

        arena.setEnemies(Arrays.asList());
        arena.setObstacles(Arrays.asList());
        arena.setWalls(Arrays.asList());

        controller = new BombermanController(arena);
    }


}
