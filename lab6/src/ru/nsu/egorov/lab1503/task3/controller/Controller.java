package ru.nsu.egorov.lab1503.task3.controller;

import ru.nsu.egorov.lab1503.task3.model.Model;

import java.util.Scanner;

public class Controller {

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void inputAnswer() {

        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            try {
                model.setAnswer(Integer.parseInt(answer));
            } catch (NumberFormatException e) {
                model.setAnswer(-99);
            }
        });

        inputThread.start();

        try {
            inputThread.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (inputThread.isAlive()) {
            inputThread.interrupt();
            model.setAnswer(-999);
        }

    }

}