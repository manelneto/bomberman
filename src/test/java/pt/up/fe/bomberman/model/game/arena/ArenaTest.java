package pt.up.fe.bomberman.model.game.arena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
    }

    @Test
    void addBomb() {
        arena.addBomb(new Bomb(1, 1, 0, 0));
        assertEquals(1, arena.getBombs().size());
    }

    @Test
    void addFlame() {
        arena.addFlame(new Flame(1, 1, 0, 'C'));
        assertEquals(1, arena.getFlames().size());
    }

    @Test
    void isBombTrue() {
        arena.addBomb(new Bomb(1, 1, 0, 0));
        assertTrue(arena.isBomb(new Position(1, 1)));
    }

    @Test
    void isBombFalse() {
        arena.addBomb(new Bomb(2, 2, 0, 0));
        assertFalse(arena.isBomb(new Position(1, 1)));
    }

    @Test
    void isFlameTrue() {
        arena.addFlame(new Flame(1, 1, 0, 'C'));
        assertTrue(arena.isFlame(new Position(1, 1)));
    }

    @Test
    void isFlameFalse() {
        arena.addFlame(new Flame(2, 2, 0, 'C'));
        assertFalse(arena.isFlame(new Position(1, 1)));
    }

    @Test
    void isObstacleTrue() {
        arena.setObstacles(Arrays.asList(new Obstacle(1, 1)));
        assertTrue(arena.isObstacle(new Position(1, 1)));
    }

    @Test
    void isObstacleFalse() {
        arena.setObstacles(Arrays.asList(new Obstacle(2, 2)));
        assertFalse(arena.isObstacle(new Position(1, 1)));
    }

    @Test
    void isWallTrue() {
        arena.setWalls(Arrays.asList(new Wall(1, 1)));
        assertTrue(arena.isWall(new Position(1, 1)));
    }

    @Test
    void isWallFalse() {
        arena.setWalls(Arrays.asList(new Wall(2, 2)));
        assertFalse(arena.isWall(new Position(1, 1)));
    }

    @Test
    void isPowerupTrue() {
        arena.setPowerups(Arrays.asList(new Powerup(1, 7, Powerup.EFFECT.BOMBS), new Powerup(2, 7, Powerup.EFFECT.FLAMES), new Powerup(3, 7, Powerup.EFFECT.SPEED), new Powerup(4, 7, Powerup.EFFECT.WALLPASS), new Powerup(5, 7, Powerup.EFFECT.HEALTH), new Powerup(6, 7, Powerup.EFFECT.BOMBPASS), new Powerup(7, 7, Powerup.EFFECT.FLAMEPASS)));
        assertTrue(arena.isPowerup(new Position(1, 7)));
        assertTrue(arena.isPowerup(new Position(2, 7)));
        assertTrue(arena.isPowerup(new Position(3, 7)));
        assertTrue(arena.isPowerup(new Position(4, 7)));
        assertTrue(arena.isPowerup(new Position(5, 7)));
        assertTrue(arena.isPowerup(new Position(6, 7)));
        assertTrue(arena.isPowerup(new Position(7, 7)));
    }

    @Test
    void isPowerupFalse() {
        arena.setPowerups(Arrays.asList(new Powerup(1, 7, Powerup.EFFECT.BOMBS), new Powerup(2, 7, Powerup.EFFECT.FLAMES), new Powerup(3, 7, Powerup.EFFECT.SPEED), new Powerup(4, 7, Powerup.EFFECT.WALLPASS), new Powerup(5, 7, Powerup.EFFECT.HEALTH), new Powerup(6, 7, Powerup.EFFECT.BOMBPASS), new Powerup(7, 7, Powerup.EFFECT.FLAMEPASS)));
        assertFalse(arena.isPowerup(new Position(1, 8)));
        assertFalse(arena.isPowerup(new Position(2, 8)));
        assertFalse(arena.isPowerup(new Position(3, 8)));
        assertFalse(arena.isPowerup(new Position(4, 8)));
        assertFalse(arena.isPowerup(new Position(5, 8)));
        assertFalse(arena.isPowerup(new Position(6, 8)));
        assertFalse(arena.isPowerup(new Position(7, 8)));
    }

}
