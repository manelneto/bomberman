package pt.up.fe.bomberman.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.game.BombermanController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.game.elements.Obstacle;
import pt.up.fe.bomberman.model.game.elements.Powerup;
import pt.up.fe.bomberman.model.game.elements.Wall;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void Steptest() throws IOException, URISyntaxException, FontFormatException {
        Game game=new Game();
        controller.step(game, GUI.ACTION.UP,0);

        assertEquals(new Position(10, 10),bomberman.getPosition());
        controller.step(game, GUI.ACTION.UP,1000);

        assertEquals(new Position(10, 9),bomberman.getPosition());

        controller.step(game, GUI.ACTION.DOWN,2000);

        assertEquals(new Position(10, 10),bomberman.getPosition());

        controller.step(game, GUI.ACTION.RIGHT,4000);

        assertEquals(new Position(11, 10),bomberman.getPosition());

        controller.step(game, GUI.ACTION.LEFT,5000);

        assertEquals(new Position(10, 10),controller.getModel().getBomberman().getPosition());


    }

    @Test
    void moveBombermanUpEmpty() {
        controller.moveBombermanUp();
        assertEquals(new Position(10, 9), bomberman.getPosition());
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
    @Test
    void ApplyEffectTest(){


        controller.applyEffect(new Powerup(10, 10, Powerup.Type.Wallpass));
        assertTrue( bomberman.canWallpass());
        controller.applyEffect(new Powerup(10, 10, Powerup.Type.Bombs));
        assertEquals(2, bomberman.getBombs());
        controller.applyEffect(new Powerup(10, 10, Powerup.Type.Flames));
        assertEquals(2, bomberman.getBombs());
        controller.applyEffect(new Powerup(10, 10, Powerup.Type.Flamepass));
        assertTrue( bomberman.canFlamepass());
        controller.applyEffect(new Powerup(10, 10, Powerup.Type.Health));
        assertEquals(2, bomberman.getHp());
        controller.applyEffect(new Powerup(10, 10, Powerup.Type.Bombpass));
        assertTrue( bomberman.canBombpass());
    }

}
