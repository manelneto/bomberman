package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.elements.Enemy;
import pt.up.fe.bomberman.model.elements.enemy.Balloom;

public class EnemyViewerTest {
    private Enemy enemy;
    private EnemyViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        enemy = new Balloom(13, 17);
        viewer = new EnemyViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawEnemy() {
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(enemy.getPosition());
    }
}

