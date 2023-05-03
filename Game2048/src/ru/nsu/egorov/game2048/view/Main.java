package ru.nsu.egorov.game2048.view;

import ru.nsu.egorov.game2048.controller.DirectionHandler;
import ru.nsu.egorov.game2048.controller.SwingDirection;
import ru.nsu.egorov.game2048.model.Field;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.print("""
                1 - Console view
                2 - Swing view
                Enter option number:\s""");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        Field field = new Field();
        field.initializeField();

        if (option.equals("1")) {
            System.out.println("Enter 'exit' to finish");
            DirectionHandler directionHandler = new DirectionHandler(field);
            ConsoleView consoleView = new ConsoleView(field);
            consoleView.printField();
            while (field.isFlag() && field.checkMovement()) directionHandler.getInput();
        }

        else if (option.equals("2")) {
            SwingDirection swingDirection = new SwingDirection(field);
            SwingView swingView = new SwingView(field, swingDirection);
            swingView.addKeyListener(swingDirection);
            swingView.userInterface();
        }

        else System.out.println("Wrong option, try again!");

    }
}