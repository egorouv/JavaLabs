package ru.nsu.egorov.game2048.view;

import ru.nsu.egorov.game2048.controller.DirectionHandler;
import ru.nsu.egorov.game2048.model.Field;

public class Main {
    public static void main(String[] args) {

        Field field = new Field();
        DirectionHandler directionHandler = new DirectionHandler(field);
        field.initializeField();
        ConsoleView consoleView = new ConsoleView(field, directionHandler);
        consoleView.printField();

    }
}