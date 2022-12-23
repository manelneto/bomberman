package pt.up.fe.bomberman.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pt.up.fe.bomberman.controller.game.BombermanController;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;

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
    void moveBombermanUpBomb() {
        arena.setBombs(Arrays.asList(new Bomb(10, 9, 0, 0)));
        controller.moveBombermanUp();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanUpObstacle() {
        arena.setObstacles(Arrays.asList(new Obstacle(10, 9)));
        controller.moveBombermanUp();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanUpWall() {
        arena.setWalls(Arrays.asList(new Wall(10, 9)));
        controller.moveBombermanUp();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanDownEmpty() {
        controller.moveBombermanDown();
        assertEquals(new Position(10, 11), bomberman.getPosition());
    }

    @Test
    void moveBombermanDownBomb() {
        arena.setBombs(Arrays.asList(new Bomb(10, 11, 0, 0)));
        controller.moveBombermanDown();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanDownObstacle() {
        arena.setObstacles(Arrays.asList(new Obstacle(10, 11)));
        controller.moveBombermanDown();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanDownWall() {
        arena.setWalls(Arrays.asList(new Wall(10, 11)));
        controller.moveBombermanDown();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanRightEmpty() {
        controller.moveBombermanRight();
        assertEquals(new Position(11, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanRightBomb() {
        arena.setBombs(Arrays.asList(new Bomb(11, 10, 0, 0)));
        controller.moveBombermanRight();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanRightObstacle() {
        arena.setObstacles(Arrays.asList(new Obstacle(11, 10)));
        controller.moveBombermanRight();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanRightWall() {
        arena.setWalls(Arrays.asList(new Wall(11, 10)));
        controller.moveBombermanRight();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanLeftEmpty() {
        controller.moveBombermanLeft();
        assertEquals(new Position(9, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanLeftBomb() {
        arena.setBombs(Arrays.asList(new Bomb(9, 10, 0, 0)));
        controller.moveBombermanLeft();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanLeftObstacle() {
        arena.setObstacles(Arrays.asList(new Obstacle(9, 10)));
        controller.moveBombermanLeft();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanLeftWall() {
        arena.setWalls(Arrays.asList(new Wall(9, 10)));
        controller.moveBombermanLeft();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }
}