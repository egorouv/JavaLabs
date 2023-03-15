package ru.nsu.egorov.lab1503.task3.view;

import ru.nsu.egorov.lab1503.task3.controller.Controller;
import ru.nsu.egorov.lab1503.task3.model.Model;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startGame();

    }

}