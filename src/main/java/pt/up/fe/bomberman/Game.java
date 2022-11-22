package pt.up.fe.bomberman;

import pt.up.fe.bomberman.gui.LanternaGUI;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;

    public Game() throws IOException {
        this.gui = new LanternaGUI(20, 20);
    }

    private void start() {
    }
}
