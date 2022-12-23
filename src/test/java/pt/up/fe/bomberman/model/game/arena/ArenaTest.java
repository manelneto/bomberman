package pt.up.fe.bomberman.model.game.arena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.bomberman.model.game.elements.Bomb;
import pt.up.fe.bomberman.model.game.elements.Flame;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
