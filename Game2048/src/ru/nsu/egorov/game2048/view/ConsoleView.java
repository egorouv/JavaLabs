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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        while (true) {
            field.moveCells(directionHandler.getInput());
            a = field.getField();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
