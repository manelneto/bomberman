package pt.up.fe.bomberman.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.menu.Menu;

public class StateTest {
    private MenuState menuState;
    private GameState gameState;

    @Test
    void getModelTest() {
        Menu menu = Mockito.mock(Menu.class);
        menuState = new MenuState(menu);
        Arena arena = Mockito.mock(Arena.class);
        gameState = new GameState(arena);

        Assertions.assertEquals(menuState.getModel(), menu);
        Assertions.assertEquals(gameState.getModel(), arena);
    }
}
