package ru.nsu.egorov.lab1503.task3.view;

import ru.nsu.egorov.lab1503.task3.model.Listener;
import ru.nsu.egorov.lab1503.task3.model.Model;

public class View implements Listener {

    private final Model model;

    public View(Model model) {
        this.model = model;
        model.addListener(this);
    }

    @Override
    public void onGenerateNumber() {
        System.out.println("Binary number: " + model.getBinaryNumber());
        System.out.print("Enter this number in decimal notation (or -1 to exit): ");
    }

    @Override
    public void onGetAnswer() {
        model.checkAnswer();
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