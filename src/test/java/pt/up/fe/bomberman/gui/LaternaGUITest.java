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
        gui.drawBomberman(new Position(1, 1),'D');


        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(100, 164, 255)); //#64A4FF
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "!");

        gui.drawBomberman(new Position(1, 2),'U');
        Mockito.verify(textGraphics, Mockito.times(2)).setForegroundColor(new TextColor.RGB(100, 164, 255)); //#64A4FF
        Mockito.verify(textGraphics, Mockito.times(2)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, ""+'"');

        gui.drawBomberman(new Position(1, 3),'R');
        Mockito.verify(textGraphics, Mockito.times(3)).setForegroundColor(new TextColor.RGB(100, 164, 255)); //#64A4FF
        Mockito.verify(textGraphics, Mockito.times(3)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 3,"." );

        gui.drawBomberman(new Position(1, 4),'L');
        Mockito.verify(textGraphics, Mockito.times(4)).setForegroundColor(new TextColor.RGB(100, 164, 255)); //#64A4FF
        Mockito.verify(textGraphics, Mockito.times(4)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 4, ",");

    }

    @Test
    void drawObstacle() {
        gui.drawElement(new Position(5, 5), '?', "#C9C9C9");


        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(201, 201, 201)); //#C9C9C9
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00

        Mockito.verify(textGraphics, Mockito.times(1)).putString(5, 5, "?");
    }

    @Test
    void drawWall() {
        gui.drawElement(new Position(10, 10), ';', "#C9C9C9");


        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(201, 201, 201)); //#010100
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 10, ";");

    }

    @Test
    void drawEnemy() {
        gui.drawElement(new Position(7, 13), ':', "#FA732C");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(250, 115, 44)); //FA732C
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00

        Mockito.verify(textGraphics, Mockito.times(1)).putString(7, 13, ":");
    }
    @Test
    void drawElementTest() {
        gui.drawElement(new Position(7, 13), ':', "#FA732C");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(250, 115, 44)); //FA732C
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00

        Mockito.verify(textGraphics, Mockito.times(1)).putString(7, 13, ":");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "Hello World");
    }
}
