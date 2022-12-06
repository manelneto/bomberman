package pt.up.fe.bomberman.controllerTest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.menu.MenuController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.arena.Arena;
import pt.up.fe.bomberman.model.arena.LoaderArenaBuilder;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.states.GameState;
import pt.up.fe.bomberman.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.when;
import static pt.up.fe.bomberman.gui.GUI.ACTION.UP;

public class ControllerMenuTest {

    @Test
    void StepTest() throws IOException, URISyntaxException, FontFormatException {

        Game game=Mockito.mock(Game.class);
        MenuController menuController=Mockito.mock(MenuController.class);
        //when(menuController.getModel().nextEntry()).thenReturn();


        long time =1;
        menuController.step(game, GUI.ACTION.DOWN,time);

        //Mockito.verify(game, Mockito.times(1)).setState(new GameState(new LoaderArenaBuilder(1).createArena()));
    }
}
