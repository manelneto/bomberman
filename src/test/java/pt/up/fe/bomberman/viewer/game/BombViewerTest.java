package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.Bomb;


public class BombViewerTest {
    private Bomb bomb;
    private BombViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        bomb = new Bomb(13, 17,2,1);
        viewer = new BombViewer();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawBomb(){
        viewer.draw(bomb, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(13,17), 'c', "#000000");

    }



}
