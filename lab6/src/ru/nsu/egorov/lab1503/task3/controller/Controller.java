package ru.nsu.egorov.lab1503.task3.controller;

import ru.nsu.egorov.lab1503.task3.model.Model;
import ru.nsu.egorov.lab1503.task3.view.View;

import java.util.Scanner;

public class Controller {

    private final Model model;
    private final View view;
    private int answer;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {

        while (true) {
            model.generateNumber();
            view.printMessage("Binary number: " + model.getBinaryNumber());
            view.printMessage("Enter decimal number (or -1 to exit): ");
            
            Thread inputThread = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                answer = scanner.nextInt();
            });

            inputThread.start();

            try {
                inputThread.join(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (inputThread.isAlive()) {
                inputThread.interrupt();
                System.out.println("Time is up!\n");
            } else {
                if (model.checkAnswer(answer)) view.printMessage("Correct!\n");
                else if (!model.checkAnswer(answer)) view.printMessage("Not correct!\n");
                else if (answer == -1) break;
                else view.printMessage("Something wrong!\n");
            }


        }
    }

}
