package pt.up.fe.bomberman.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.game.*;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ArenaControllerTest {
    ArenaController arenacontroller;


    @BeforeEach
    void Setup(){
        Bomberman bomberman=new Bomberman(10,10);
        Arena arena=new Arena(20,20);
        arena.setBomberman(bomberman);
        arenacontroller=new ArenaController(arena);

    }
    @Test
    void StepTest() throws IOException, URISyntaxException, FontFormatException {
        Game game=new Game();
        Game spygame=spy(game);
        arenacontroller.step(spygame, GUI.ACTION.NONE,0);
        verify(spygame, Mockito.times(0)).setState(any(MenuState.class));
        arenacontroller.step(spygame, GUI.ACTION.QUIT,1);
        verify(spygame, Mockito.times(1)).setState(any(MenuState.class));

    }
}
