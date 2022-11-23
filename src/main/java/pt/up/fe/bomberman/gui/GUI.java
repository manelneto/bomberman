package pt.up.fe.bomberman.gui;

import pt.up.fe.bomberman.model.Position;

import java.io.IOException;

public interface GUI {
    enum ACTION {UP, RIGHT, DOWN, LEFT, X, NONE, QUIT}

    ACTION getNextAction() throws IOException;

    void drawBomberman(Position position);

    void drawObstacle(Position position);

    void drawWall(Position position);

    void drawEnemy(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}
