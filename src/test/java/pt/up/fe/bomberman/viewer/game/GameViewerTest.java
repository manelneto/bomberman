package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.arena.Arena;
import pt.up.fe.bomberman.model.elements.Bomberman;
import pt.up.fe.bomberman.model.elements.Enemy;
import pt.up.fe.bomberman.model.elements.Obstacle;
import pt.up.fe.bomberman.model.elements.Wall;

import java.io.IOException;
import java.util.Arrays;

public class GameViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(50, 50);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setBomberman(new Bomberman(1, 1));
        arena.setEnemies(Arrays.asList(new Enemy(5, 5), new Enemy(7, 7)));
        arena.setObstacles(Arrays.asList(new Obstacle(10, 10)));
        arena.setWalls(Arrays.asList(new Wall(15, 15)));
    }

    @Test
    void drawBomberman() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBomberman(new Position(1, 1));
        Mockito.verify(gui, Mockito.times(1)).drawBomberman(Mockito.any(Position.class));
    }

    @Test
    void drawEnemies() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(5, 5));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(7, 7));
        Mockito.verify(gui, Mockito.times(2)).drawEnemy(Mockito.any(Position.class));
    }
}
