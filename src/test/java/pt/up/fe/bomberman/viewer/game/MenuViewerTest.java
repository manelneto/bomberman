package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.viewer.menu.MenuViewer;

import java.io.IOException;

public class MenuViewerTest {

    private MenuViewer viewer;

    private GUI gui;

    private Menu menu;

    @BeforeEach
    void setUp(){
        menu=new Menu();
        gui= Mockito.mock(GUI.class);
        viewer = new MenuViewer(menu);

    }
    @Test
    void drawElements() throws IOException {
        viewer.draw(gui);
        int i=0;
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 5), "Menu", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7+i++), "Start", "#FFD700");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7+i),"Exit", "#FFFFFF");
    }

}
