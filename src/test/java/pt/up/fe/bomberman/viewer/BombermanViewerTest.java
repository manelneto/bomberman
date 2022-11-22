package pt.up.fe.bomberman.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.elements.Bomberman;

public class BombermanViewerTest {
    private Bomberman bomberman;
    private BombermanViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        bomberman = new Bomberman(10, 10);
        viewer = new BombermanViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(bomberman, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBomberman(bomberman.getPosition());
    }
}
