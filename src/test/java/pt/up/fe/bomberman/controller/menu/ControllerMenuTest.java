package pt.up.fe.bomberman.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.menu.MenuController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.doNothing;


public class ControllerMenuTest {

    MenuController controller;
    Menu menu;

    @BeforeEach
    void setup(){
        menu=new Menu();
        menu.nextOption();
        controller=new MenuController(menu);
    }

    @Test
    void StepTest() throws IOException, URISyntaxException, FontFormatException {
        Game game=new Game();
        Menu spymenu= Mockito.spy(menu);
        controller=new MenuController(spymenu);
        doNothing().when(spymenu).nextOption();
        doNothing().when(spymenu).previousOption();
        doNothing().when(spymenu).nextLevel();
        doNothing().when(spymenu).previousLevel();
        controller.step(game, GUI.ACTION.DOWN,0);

        Mockito.verify(spymenu,Mockito.times(1)).nextOption();

        controller.step(game, GUI.ACTION.UP,1);

        Mockito.verify(spymenu,Mockito.times(1)).previousOption();


        controller.step(game, GUI.ACTION.RIGHT,3);
        Mockito.verify(spymenu,Mockito.times(1)).nextLevel();

        controller.step(game, GUI.ACTION.LEFT,3);

        Mockito.verify(spymenu,Mockito.times(1)).previousLevel();



    }


}
