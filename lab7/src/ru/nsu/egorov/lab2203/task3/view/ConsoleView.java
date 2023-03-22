package ru.nsu.egorov.lab2203.task3.view;

import ru.nsu.egorov.lab2203.task3.model.ModelListener;
import ru.nsu.egorov.lab2203.task3.model.Model;

public class ConsoleView implements ModelListener {

    private final Model model;

    public ConsoleView(Model model) {
        this.model = model;
        model.addListener(this);
    }

    @Override
    public void onGenerateNumber() {
        System.out.println("Binary number: " + model.getBinaryNumber());
        System.out.print("Enter this number in decimal notation (or -1 to exit): ");
    }

    @Override
    public void onCorrectAnswer() {
        System.out.println("Correct!\n");
    }

    @Override
    public void onIncorrectAnswer() {
        System.out.println("Not correct!\n");
    }

    @Override
    public void onTimeout() {
        System.out.println("\nTime is up!\n");
    }

    @Override
    public void onGameEnded() {
        System.out.println("Finishing the game...");
        System.exit(0);
    }

}