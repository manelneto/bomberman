package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.Flame;


public class FlameViewerTest {

    private Flame flame;
    private FlameViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        flame = new Flame(13, 17,0,'H');
        viewer = new FlameViewer();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawTest(){
        viewer.draw(flame, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(13,17), 'a', "#FF4500");
        flame = new Flame(13, 17,0,'C');
        viewer.draw(flame, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(13,17), 's', "#FF4500");
        flame = new Flame(13, 17,0,'V');
        viewer.draw(flame, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(13,17), 'b', "#FF4500");
    }

}
