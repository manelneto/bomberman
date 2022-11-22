package pt.up.fe.bomberman.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import pt.up.fe.bomberman.model.Position;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException {
        Terminal terminal = createTerminal(width, height);
        screen = createScreen(terminal);
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    @Override
    public ACTION getNextAction() {
        return null;
    }

    @Override
    public void drawBomberman(Position position) {
        drawCharacter(position.getX(), position.getY(), 'B', "#FF0000"); //red
    }

    @Override
    public void drawObstacle(Position position) {
        drawCharacter(position.getX(), position.getY(), 'O', "#505050"); //grey
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), 'W', "#964B00"); //brown
    }

    @Override
    public void drawEnemy(Position position) {
        drawCharacter(position.getX(), position.getY(), 'E', "#FF0000");
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(x, y, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
