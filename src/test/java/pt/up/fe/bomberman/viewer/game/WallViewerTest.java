package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.elements.Wall;
import pt.up.fe.bomberman.viewer.game.WallViewer;

public class WallViewerTest {
    private Wall wall;
    private WallViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        wall = new Wall(12, 8);
        viewer = new WallViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawWall() {
        viewer.draw(wall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
    }
}