package pt.up.fe.bomberman.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.game.EnemyController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;
import pt.up.fe.bomberman.model.game.elements.enemy.Balloom;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnemyControllerTest {
    private EnemyController controller;
    private Bomberman bomberman;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);

        bomberman = new Bomberman(10, 10);
        arena.setBomberman(bomberman);

        arena.setEnemies(Arrays.asList());
        arena.setObstacles(Arrays.asList());
        arena.setWalls(Arrays.asList());

        controller = new EnemyController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveEnemies() throws IOException {
        Enemy enemy = new Balloom(10, 10);
        arena.setEnemies(Arrays.asList(enemy));

        controller.step(game, GUI.ACTION.NONE, 1000);

        assertNotEquals(new Position(10, 10), enemy.getPosition());
    }

    @Test
    void moveEnemyObstacle() throws IOException {
        Enemy enemy = new Balloom(10, 10);
        arena.setEnemies(Arrays.asList(enemy));
        arena.setObstacles(Arrays.asList(new Obstacle(11, 10), new Obstacle(9, 10), new Obstacle(10, 9), new Obstacle(10, 11)));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(10, 10), enemy.getPosition());
    }

    @Test
    void moveEnemyWall() throws IOException {
        Enemy enemy = new Balloom(10, 10);
        arena.setEnemies(Arrays.asList(enemy));
        arena.setWalls(Arrays.asList(new Wall(11, 10), new Wall(9, 10), new Wall(10, 9), new Wall(10, 11)));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(10, 10), enemy.getPosition());
    }

}
