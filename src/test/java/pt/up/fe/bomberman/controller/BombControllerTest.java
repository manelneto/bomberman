package pt.up.fe.bomberman.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.game.BombController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BombControllerTest {
    private BombController controller;
    private Bomb bomb;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        bomb = new Bomb(10, 10,0,1);
        controller = new BombController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void explodeBomb() throws IOException {
        arena.addBomb(bomb);
        controller.step(game, GUI.ACTION.NONE, 2000);
        List<Flame> flames = Arrays.asList(new Flame(10, 10, 2000, 'C'), new Flame(10, 9, 2000, 'V'), new Flame(10, 11, 2000, 'V'), new Flame(9, 10, 2000, 'H'), new Flame(11, 10, 2000, 'H'));
        assertEquals(flames.size(), arena.getFlames().size());
        for (int i = 0; i < flames.size(); i++) {
            Flame expected = flames.get(i);
            Flame actual = arena.getFlames().get(i);
            assertEquals(expected.getPosition(), actual.getPosition());
            assertEquals(expected.getTime(), actual.getTime());
            assertEquals(expected.getType(), actual.getType());
        }
    }

    @Test
    void explodeBombWalls() throws IOException {
        arena.addBomb(bomb);
        List<Wall> walls = Arrays.asList(new Wall(10, 9), new Wall(10, 11), new Wall(9, 10), new Wall(11, 10));
        arena.setWalls(walls);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertEquals(1, arena.getFlames().size());
        Flame expected = new Flame(10, 10, 2000, 'C');
        Flame actual = arena.getFlames().get(0);
        assertEquals(expected.getPosition(), actual.getPosition());
        assertEquals(expected.getTime(), actual.getTime());
        assertEquals(expected.getType(), actual.getType());
    }
}
