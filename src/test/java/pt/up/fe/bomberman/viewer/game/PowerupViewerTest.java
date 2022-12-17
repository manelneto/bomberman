package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.Powerup;


public class PowerupViewerTest {
    private Powerup powerup;
    private PowerupViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        viewer = new PowerupViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawPowerup() {

        powerup = new Powerup(10,10, Powerup.Type.Bombpass);
        viewer.draw(powerup, gui);
        powerup = new Powerup(10,11, Powerup.Type.Wallpass);
        viewer.draw(powerup, gui);
        powerup = new Powerup(10,12, Powerup.Type.Flamepass);
        viewer.draw(powerup, gui);
        powerup = new Powerup(10,13, Powerup.Type.Bombs);
        viewer.draw(powerup, gui);
        powerup = new Powerup(10,14, Powerup.Type.Flames);
        viewer.draw(powerup, gui);
        powerup = new Powerup(10,15, Powerup.Type.Health);
        viewer.draw(powerup, gui);
        powerup = new Powerup(10,16, Powerup.Type.Speed);
        viewer.draw(powerup, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(10,10), 'r', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(10,11), 'p', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(10,12), 'q', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(10,13), 'e', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(10,14), 'd', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(10,15), 'g', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(10,16), 'f', "#F7EF8A");

    }
}

