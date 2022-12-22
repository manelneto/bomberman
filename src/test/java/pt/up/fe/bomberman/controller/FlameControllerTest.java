package pt.up.fe.bomberman.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.game.FlameController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;

import pt.up.fe.bomberman.model.game.elements.Flame;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class FlameControllerTest {
    private FlameController controller;
    private List<Flame> flames;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        flames = new ArrayList<>();
        flames.add(new Flame(10, 10,1,'C'));
        flames.add(new Flame(11, 10,1,'H'));
        flames.add(new Flame(9, 10,1,'H'));
        flames.add(new Flame(10, 9,1,'V'));
        flames.add(new Flame(10, 11,1,'V'));
        arena.setFlames(flames);
        arena.setEnemies(Arrays.asList());
        arena.setObstacles(Arrays.asList());
        arena.setWalls(Arrays.asList());


        controller = new FlameController(arena);
    }
    @Test
    void Teststep() throws IOException, URISyntaxException, FontFormatException {
        controller=new FlameController(arena);
        FlameController spycontroller=spy(controller);

        Game game=new Game();
        spycontroller.step(game, GUI.ACTION.NONE,0);
        Assertions.assertEquals(arena.getFlames(),flames);

        spycontroller.step(game, GUI.ACTION.NONE,20000);
        Assertions.assertEquals(arena.getFlames(),new ArrayList<>());

    }
}
