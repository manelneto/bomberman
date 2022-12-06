package pt.up.fe.bomberman.gui;

import pt.up.fe.bomberman.model.Position;

import java.io.IOException;

public interface GUI {

    enum ACTION {UP, RIGHT, DOWN, LEFT, ENTER, NONE, QUIT,SPACE}

    ACTION getNextAction() throws IOException;

    void drawText(Position position, String text, String color);


    void drawBomberman(Position position);

    void drawObstacle(Position position);

    void drawWall(Position position);

    void drawEnemy(Position position);

    void drawPowerup(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void paintBackground(int width, int height);

}

