package ru.nsu.egorov.game2048.view;

import ru.nsu.egorov.game2048.controller.DirectionHandler;
import ru.nsu.egorov.game2048.model.Field;

public class ConsoleView {

    private final Field field;
    private final DirectionHandler directionHandler;

    public ConsoleView(Field field, DirectionHandler directionHandler) {
        this.field = field;
        this.directionHandler = directionHandler;
    }

    public void printField() {
        int[][] a = field.getField();
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Score: " + field.getScore());
        System.out.println("High Score: " + field.getHighScore());
        while (field.isFlag()) {
            field.moveCells(directionHandler.getInput());
            a = field.getField();
            for (int i = 0; i < field.getSize(); i++) {
                for (int j = 0; j < field.getSize(); j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Score: " + field.getScore());
            System.out.println("High Score: " + field.getHighScore());
        }
    }

}
