package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.elements.Obstacle;
import pt.up.fe.bomberman.viewer.game.ObstacleViewer;

public class ObstacleViewerTest {
    private Obstacle obstacle;
    private ObstacleViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        obstacle = new Obstacle(5, 5);
        viewer = new ObstacleViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawObstacle() {
        viewer.draw(obstacle, gui);
        Mockito.verify(gui, Mockito.times(1)).drawObstacle(obstacle.getPosition());
    }
}
