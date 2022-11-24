package pt.up.fe.bomberman;

import pt.up.fe.bomberman.gui.LanternaGUI;
import pt.up.fe.bomberman.model.arena.Arena;
import pt.up.fe.bomberman.model.arena.ArenaBuilder;
import pt.up.fe.bomberman.model.arena.LoaderArenaBuilder;
import pt.up.fe.bomberman.viewer.Viewer;
import pt.up.fe.bomberman.viewer.game.GameViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(15, 13);
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();
    }

    private void start() throws IOException {
        ArenaBuilder arenaBuilder = new LoaderArenaBuilder(1);
        Arena arena = arenaBuilder.createArena();
        Viewer viewer = new GameViewer(arena);
        viewer.draw(gui);
    }
}
