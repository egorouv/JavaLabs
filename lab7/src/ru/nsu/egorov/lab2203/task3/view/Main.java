package ru.nsu.egorov.lab2203.task3.view;

import ru.nsu.egorov.lab2203.task3.controller.SwingController;
import ru.nsu.egorov.lab2203.task3.model.Model;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        SwingView swingView = new SwingView(model);
        SwingController swingController = new SwingController(model, swingView);

        //while (true) {
            model.generateNumber();
            swingController.inputAnswer();
        //}

    }
}