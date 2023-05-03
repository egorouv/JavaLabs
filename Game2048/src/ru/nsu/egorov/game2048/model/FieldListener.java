package ru.nsu.egorov.game2048.model;

import java.io.IOException;

public interface FieldListener {

    void onMovingCells() throws IOException;
    void onEndingGame();
    void onRestartingGame() throws IOException;

}
