package pt.up.fe.bomberman.gui;

import pt.up.fe.bomberman.model.Position;

import java.io.IOException;

public interface GUI {
    enum ACTION {UP, RIGHT, DOWN, LEFT, ENTER, NONE, QUIT, SPACE}

    ACTION getNextAction() throws IOException;

    void drawText(Position position, String text, String color);

    void drawBomberman(Position position, char face);

    void drawBomb(Position position);

    void drawObstacle(Position position);

    void drawWall(Position position);

    void drawEnemy(Position position);

    void drawPowerup(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    public void drawExplosion(Position position);

    void paintBackground(int width, int height);

    void drawExplosionHorizontal(Position position);

    void drawExplosionVertical(Position position);
}

