package ru.nsu.egorov.game2048.controller;

import ru.nsu.egorov.game2048.model.Field;

import java.util.Scanner;

public class DirectionHandler {

    private final Field field;

    public DirectionHandler(Field field) {
        this.field = field;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
