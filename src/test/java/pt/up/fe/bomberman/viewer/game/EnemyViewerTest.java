package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Enemy;
/*
impublic class EnemyViewerTest {
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
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), ':', "#FA732C");
        enemy = new Oneal(13, 17);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'n', "#0000FF");
        enemy = new Doll(13, 17);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'o', "#FF0000");
        enemy = new Kondria(13, 17);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'u', "#0000FF");
        enemy = new Minvo(13, 17);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 't', "#FA732C");
        enemy = new Ovapi(13, 17);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'v', "#FF0000");
        enemy = new Pass(13, 17);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'w', "#FA732C");
        enemy = new Pontan(13, 17);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'x', "#FF0000");
    }
}
*/