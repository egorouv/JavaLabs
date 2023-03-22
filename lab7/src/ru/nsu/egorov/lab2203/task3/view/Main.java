package ru.nsu.egorov.lab2203.task3.view;

import ru.nsu.egorov.lab2203.task3.controller.SwingController;
import ru.nsu.egorov.lab2203.task3.model.Model;
import ru.nsu.egorov.lab2203.task3.controller.ConsoleController;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        //ConsoleController consoleController = new ConsoleController(model);
        //ConsoleView ConsoleView = new ConsoleView(model);
        SwingView swingView = new SwingView(model);
        SwingController swingController = new SwingController(model, swingView);

        //while (true) {
        //    model.generateNumber();
        //    consoleController.inputAnswer();
        //}

        //while (true) {
            model.generateNumber();
            swingController.inputAnswer();
        //}

    }
}