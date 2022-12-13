package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Powerup;
import pt.up.fe.bomberman.model.game.elements.powerup.Bombpass;

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
        powerup = new Bombpass(10,10);
        viewer.draw(powerup, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPowerupBombpass(powerup.getPosition());
    }
}

