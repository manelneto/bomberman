package pt.up.fe.bomberman.model.game.arena;

import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.game.elements.Obstacle;
import pt.up.fe.bomberman.model.game.elements.Powerup;
import pt.up.fe.bomberman.model.game.elements.*;
import pt.up.fe.bomberman.model.game.elements.powerup.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected List<Obstacle> createObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'o' || line.charAt(x) == 'P' || line.charAt(x) == 'F' || line.charAt(x) == 'S' || line.charAt(x) == 'e' || line.charAt(x) == 'm' || line.charAt(x) == 'f' || line.charAt(x) == 'g')
                    obstacles.add(new Obstacle(x, y));
        }

        return obstacles;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#')
                    walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected List<Enemy> createEnemies() {
        List<Enemy> enemy = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'M') enemy.add(new Enemy(x, y, Enemy.enemyType.Balloom));
                if (line.charAt(x) == 'E') enemy.add(new Enemy(x, y,Enemy.enemyType.Oneal));
                if (line.charAt(x) == 'L') enemy.add(new Enemy(x, y,Enemy.enemyType.Doll));
                if (line.charAt(x) == 'A') enemy.add(new Enemy(x, y,Enemy.enemyType.Kondria));
                if (line.charAt(x) == 'N') enemy.add(new Enemy(x, y,Enemy.enemyType.Minvo));
                if (line.charAt(x) == 'C') enemy.add(new Enemy(x, y,Enemy.enemyType.Ovapi));
                if (line.charAt(x) == 'I') enemy.add(new Enemy(x, y,Enemy.enemyType.Pass));
                if (line.charAt(x) == 'a') enemy.add(new Enemy(x, y,Enemy.enemyType.Pontan));
            }
        }

        return enemy;
    }

    @Override
    protected Bomberman createBomberman() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H')
                    return new Bomberman(x, y);
        }
        return null;
    }

    @Override
    protected List<Powerup> createPowerups() {
        List<Powerup> powerup = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'm') powerup.add(new Bombs(x, y));
                if (line.charAt(x) == 'f') powerup.add(new Flames(x, y));
                if (line.charAt(x) == 'S') powerup.add(new Speed(x, y));
                if (line.charAt(x) == 'e') powerup.add(new Wallpass(x, y));
                if (line.charAt(x) == 'g') powerup.add(new Health(x, y));
                if (line.charAt(x) == 'P') powerup.add(new Bombpass(x, y));
                if (line.charAt(x) == 'F') powerup.add(new Flamepass(x, y));
            }
        }
        return powerup;
    }
}
