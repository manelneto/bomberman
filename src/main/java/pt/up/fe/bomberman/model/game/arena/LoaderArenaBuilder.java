package pt.up.fe.bomberman.model.game.arena;

import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.game.elements.Obstacle;
import pt.up.fe.bomberman.model.game.elements.Powerup;
import pt.up.fe.bomberman.model.game.elements.*;

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
        assert resource != null;
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
                if (line.charAt(x) == 'M') enemy.add(new Enemy(x, y, Enemy.TYPE.BALLOOM));
                else if (line.charAt(x) == 'E') enemy.add(new Enemy(x, y, Enemy.TYPE.ONEAL));
                else if (line.charAt(x) == 'L') enemy.add(new Enemy(x, y, Enemy.TYPE.DOLL));
                else if (line.charAt(x) == 'A') enemy.add(new Enemy(x, y, Enemy.TYPE.MINVO));
                else if (line.charAt(x) == 'N') enemy.add(new Enemy(x, y, Enemy.TYPE.KONDORIA));
                else if (line.charAt(x) == 'C') enemy.add(new Enemy(x, y, Enemy.TYPE.OVAPI));
                else if (line.charAt(x) == 'I') enemy.add(new Enemy(x, y, Enemy.TYPE.PASS));
                else if (line.charAt(x) == 'a') enemy.add(new Enemy(x, y, Enemy.TYPE.PONTAM));
            }
        }

        return enemy;
    }

    @Override
    protected List<Powerup> createPowerups() {
        List<Powerup> powerup = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'm') powerup.add(new Powerup(x, y, Powerup.EFFECT.BOMBS));
                else if (line.charAt(x) == 'f') powerup.add(new Powerup(x, y, Powerup.EFFECT.FLAMES));
                else if (line.charAt(x) == 'S') powerup.add(new Powerup(x, y, Powerup.EFFECT.SPEED));
                else if (line.charAt(x) == 'e') powerup.add(new Powerup(x, y, Powerup.EFFECT.WALLPASS));
                else if (line.charAt(x) == 'g') powerup.add(new Powerup(x, y, Powerup.EFFECT.HEALTH));
                else if (line.charAt(x) == 'P') powerup.add(new Powerup(x, y, Powerup.EFFECT.BOMBPASS));
                else if (line.charAt(x) == 'F') powerup.add(new Powerup(x, y, Powerup.EFFECT.FLAMEPASS));
            }
        }
        return powerup;
    }
}
