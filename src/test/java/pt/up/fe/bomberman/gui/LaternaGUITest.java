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
        gui.drawBomberman(new Position(1, 1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(100, 164, 255)); //#64A4FF
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "B");
    }

    @Test
    void drawObstacle() {
        gui.drawObstacle(new Position(5, 5));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(201, 201, 201)); //#C9C9C9
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(5, 5, "O");
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(1, 1, 0)); //#010100
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 10, "W");
    }

    @Test
    void drawEnemy() {
        gui.drawEnemy(new Position(7, 13));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(250, 115, 44)); //FA732C
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(7, 13, "E");
    }
}

