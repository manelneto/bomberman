package pt.up.fe.bomberman.model.game.arena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.Bomb;
import pt.up.fe.bomberman.model.game.elements.Flame;

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

}
