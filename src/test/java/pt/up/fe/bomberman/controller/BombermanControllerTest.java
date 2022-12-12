package pt.up.fe.bomberman.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.bomberman.controller.game.BombermanController;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomberman;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombermanControllerTest {
    private BombermanController controller;
    private Bomberman bomberman;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);

        bomberman = new Bomberman(10, 10);
        arena.setBomberman(bomberman);

        arena.setEnemies(Arrays.asList());
        arena.setObstacles(Arrays.asList());
        arena.setWalls(Arrays.asList());

        controller = new BombermanController(arena);
    }

    @Test
    void moveBombermanUpEmpty() {
        controller.moveBombermanUp();
        assertEquals(new Position(10, 9), bomberman.getPosition());
    }

    @Test
    void moveBombermanDownEmpty() {
        controller.moveBombermanDown();
        assertEquals(new Position(10, 11), bomberman.getPosition());
    }

    @Test
    void moveBombermanRightEmpty() {
        controller.moveBombermanRight();
        assertEquals(new Position(11, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanLeftEmpty() {
        controller.moveBombermanLeft();
        assertEquals(new Position(9, 10), bomberman.getPosition());
    }
}
