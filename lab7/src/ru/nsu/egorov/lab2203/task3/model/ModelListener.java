package ru.nsu.egorov.lab2203.task3.model;

public interface ModelListener {

    void onGenerateNumber();
    void onCorrectAnswer();
    void onIncorrectAnswer();
    void onTimeout();

}