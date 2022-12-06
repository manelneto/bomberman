package pt.up.fe.bomberman.States;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.Controller;
import pt.up.fe.bomberman.controller.game.GameController;
import pt.up.fe.bomberman.controller.menu.MenuController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.gui.LanternaGUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.arena.Arena;
import pt.up.fe.bomberman.model.elements.Bomberman;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.states.GameState;
import pt.up.fe.bomberman.states.MenuState;
import pt.up.fe.bomberman.states.State;
import pt.up.fe.bomberman.viewer.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.when;

public class StateTest {

    private GameState Gmodel;

    private MenuState Mmodel;

    private Controller controllerMenu;

    private Controller controllerGame;

    private Viewer viewer;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {

        controllerGame = Mockito.mock(GameController.class);

        controllerMenu = Mockito.mock(MenuController.class);

        Mmodel=Mockito.mock(MenuState.class);

        viewer=Mockito.mock(Viewer.class);

        Gmodel=Mockito.mock(GameState.class);


    }
    @Test
    void getModelTest() {

        Menu menu=Mockito.mock(Menu.class);
        Mmodel= new MenuState(menu);
        Arena arena= Mockito.mock(Arena.class);
        Gmodel=new GameState(arena);

        Assertions.assertTrue(Mmodel.getModel()== menu);
        Assertions.assertTrue(Gmodel.getModel()== arena);

    }

}
