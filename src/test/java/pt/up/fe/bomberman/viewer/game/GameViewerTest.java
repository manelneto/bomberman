package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.game.elements.Obstacle;
import pt.up.fe.bomberman.model.game.elements.Wall;


import java.io.IOException;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.eq;

public class GameViewerTest {/*
    private Arena arena;
    private GameViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        arena = new Arena(50, 50);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setBomberman(new Bomberman(1, 1));
        arena.setEnemies(Arrays.asList(new Balloom(5, 5 ),new Oneal(1, 1), new Doll(7, 7)));
        arena.setObstacles(Arrays.asList(new Obstacle(10, 10), new Obstacle(12, 12), new Obstacle(14, 14)));
        arena.setWalls(Arrays.asList(new Wall(15, 15), new Wall(16, 16), new Wall(17, 17), new Wall(18, 18)));
    }

    @Test
    void drawBomberman() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBomberman(eq(new Position(1, 1)),eq(viewer.getModel().getBomberman().getDirection()));
        Mockito.verify(gui, Mockito.times(1)).drawBomberman(Mockito.any(Position.class),eq(viewer.getModel().getBomberman().getDirection()));
    }

    @Test
    void drawEnemies() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(5, 5), ':', "#FA732C");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(7, 7), 'n', "#0000FF");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1, 1), 'o', "#FF0000");
    }

    @Test
    void drawObstacles() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(10, 10), '?', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(12, 12), '?', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(14, 14), '?', "#C9C9C9");
        //Mockito.verify(gui, Mockito.times(3)).drawElement(Mockito.any(Position.class), '?', "#C9C9C9");
    }

    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(15, 15), ';', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(16, 16), ';', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(17, 17), ';', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(18, 18), ';', "#C9C9C9");
        //Mockito.verify(gui, Mockito.times(4)).drawElement(Mockito.any(Position.class), ';', "#C9C9C9");
    }*/
}
