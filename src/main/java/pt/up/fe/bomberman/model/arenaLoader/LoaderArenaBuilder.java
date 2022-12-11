package pt.up.fe.bomberman.model.arenaLoader;



import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.game.elements.Enemy;
import pt.up.fe.bomberman.model.game.elements.Obstacle;
import pt.up.fe.bomberman.model.game.elements.Wall;
import pt.up.fe.bomberman.model.game.elements.enemy.Balloom;
import pt.up.fe.bomberman.model.game.elements.enemy.Doll;
import pt.up.fe.bomberman.model.game.elements.enemy.Oneal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final List<String> lines;


    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

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
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected List<Enemy> createEnemies() {
        List<Enemy> enemy = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'M') enemy.add(new Balloom(x, y));
                if (line.charAt(x) == 'E') enemy.add(new Oneal(x, y));
                if (line.charAt(x) == 'L') enemy.add(new Doll(x, y));
            }
        }

        return enemy;
    }

    @Override
    protected Bomberman createBomberman() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Bomberman(x, y);
        }
        return null;
    }
    protected List<Obstacle> createObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'o') obstacles.add(new Obstacle(x, y));
        }

        return obstacles;
    }


}
