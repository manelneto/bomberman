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
    private Menu menu;
    private MenuViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp(){
        menu = new Menu();
        gui = Mockito.mock(GUI.class);
        viewer = new MenuViewer(menu);

    }

    @Test
    void drawElements() throws IOException {
        viewer.draw(gui);

        int i = 0;
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 5), "MENU", "#FFFFFF");
<<<<<<< HEAD
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7+i), "START", "#FFD700");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7+i+2),"EXIT", "#FFFFFF");
=======
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7 + i++), "START", "#FFD700");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7 + i),"EXIT", "#FFFFFF");
>>>>>>> c057579c697addc6afd47533fcf7f6ac9a3fece5
    }
}
