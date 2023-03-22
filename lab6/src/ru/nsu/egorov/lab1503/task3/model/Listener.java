package ru.nsu.egorov.lab1503.task3.model;

public interface Listener {

    void onGenerateNumber();
    void onCorrectAnswer();
    void onIncorrectAnswer();
    void onTimeout();
    void onGameEnded();

}