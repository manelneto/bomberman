package pt.up.fe.bomberman.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.model.Position;

class LaternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawBomberman() {
        gui.drawBomberman(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 10, "B");
    }

    @Test
    void drawObstacle() {
        gui.drawObstacle(new Position(5, 5));

        Mockito.verify(textGraphics, Mockito.times(1)).putString(5, 5, "O");
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(20, 20));

        Mockito.verify(textGraphics, Mockito.times(1)).putString(20, 20, "#");
    }

    @Test
    void drawEnemy() {
        gui.drawEnemy(new Position(7, 13));

        Mockito.verify(textGraphics, Mockito.times(1)).putString(7, 13, "E");
    }
    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "Hello World");
    }
}
