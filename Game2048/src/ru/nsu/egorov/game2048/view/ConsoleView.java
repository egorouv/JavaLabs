package ru.nsu.egorov.game2048.view;

import ru.nsu.egorov.game2048.model.Field;
import ru.nsu.egorov.game2048.model.FieldListener;

public class ConsoleView implements FieldListener {

    private final Field field;

    public ConsoleView(Field field) {
        this.field = field;
        field.addListener(this);
    }

    public void printField() {
        int[][] matrix = field.getField();
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Score: " + field.getScore());
        System.out.println("High Score: " + field.getHighScore());
        if (!field.isFlag()) System.out.println("You won!");
    }

    @Override
    public void onMovingCells() {
        printField();
    }

    @Override
    public void onEndingGame() {
        System.exit(0);
    }

    @Override
    public void onRestartingGame() {
        field.initializeField();
        printField();
    }
}
