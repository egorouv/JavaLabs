package ru.nsu.egorov.game2048.controller;

import ru.nsu.egorov.game2048.model.Field;

import java.io.IOException;
import java.util.Scanner;

public class DirectionHandler {

    private final Field field;

    public DirectionHandler(Field field) {
        this.field = field;
    }

    public void getInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        field.moveCells(scanner.nextLine());
    }

}
