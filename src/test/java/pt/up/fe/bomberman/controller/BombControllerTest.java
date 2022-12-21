package pt.up.fe.bomberman.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.game.BombController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BombControllerTest {
    private BombController controller;
    private Bomb bomb;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        bomb = new Bomb(10, 10,0,1);
        arena.addBomb(bomb);
        arena.setEnemies(Arrays.asList());
        arena.setObstacles(Arrays.asList());
        arena.setWalls(Arrays.asList());
        arena.setFlames(Arrays.asList(new Flame(11, 10,1,'C')));

        controller = new BombController(arena);
    }
    @Test
    void StepTest() throws IOException, URISyntaxException, FontFormatException {
        Game game=new Game();
        Arena spyarena=spy(arena);
        controller = new BombController(spyarena);
        BombController spycontroller=spy(controller);
        doNothing().when(spyarena).setBombs(anyListOf(Bomb.class));
        doNothing().when(spycontroller).explodeBomb(bomb,2001);

        spycontroller.step(game, GUI.ACTION.NONE,0);
        verify(spycontroller,times(0)).explodeBomb(bomb,0);

        spycontroller.step(game, GUI.ACTION.NONE,2001);
        verify(spycontroller,times(1)).explodeBomb(bomb,2001);

    }

    @Test
    void DestroyObstacleTest(){
        List<Obstacle> obs = new ArrayList<>();
        Obstacle obstacle=new Obstacle(9, 10);
        obs.add(obstacle);
        obs.add(new Obstacle(8, 10));
        arena.setObstacles(obs);
        Arena spyarena=spy(arena);
        controller = new BombController(spyarena);
        controller.destroyObstacle(new Position(9, 10));
        Mockito.verify(spyarena,times(1)).removeobstacles(obstacle);

    }

    @Test
    void KillEnemyTest(){
        List<Enemy> enemies = new ArrayList<>();
        Enemy enemy=new Enemy(9, 10, Enemy.Type.Balloom);
        enemies.add(enemy);
        enemies.add(new Enemy(8, 10, Enemy.Type.Oneal));
        arena.setEnemies(enemies);
        Arena spyarena=spy(arena);
        controller = new BombController(spyarena);
        controller.killEnemy(new Position(9, 10));
        Mockito.verify(spyarena,times(1)).removeEnemies(enemy);

    }
    @Test
    void ExpodeBombTest(){
        Bomberman spybomberman=spy(new Bomberman(11,10));
        arena.setBomberman(spybomberman);
        Arena spyarena=spy(arena);
        controller = new BombController(spyarena);
        BombController spycontroller=spy(controller);

        doNothing().when(spycontroller).createFlames(bomb,2);
        when(spyarena.getBomberman()).thenReturn(spybomberman);

        spycontroller.explodeBomb(bomb,2);
        verify(spycontroller,times(1)).createFlames(bomb,2);
        verify(spycontroller,times(bomb.getFlames())).destroyObstacle(any(Position.class));
        verify(spycontroller,times(bomb.getFlames())).killEnemy(any(Position.class));
        verify(spybomberman,times(1)).setHp(arena.getBomberman().getHp() - 1);

    }
    @Test
    void createFlamesTest(){
        Bomb spybomb=spy(bomb);
        Arena spyarena=spy(arena);
        doNothing().when(spyarena).addflames(anyList());
        BombController spycontroller = spy(new BombController(spyarena));
        spycontroller.createFlames(bomb,2);
        List<Flame> flames=new ArrayList<>();
        flames.add(new Flame(10,10,2,'C'));
        flames.add(new Flame(11,10,2,'H'));
        flames.add(new Flame(9,10,2,'H'));
        flames.add(new Flame(10,11,2,'V'));
        flames.add(new Flame(10,9,2,'V'));
        verify(spyarena,times(1)).addflames(anyListOf(Flame.class));


    }




}
