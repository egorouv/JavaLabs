package ru.nsu.egorov.lab1503.task3.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private int number;
    private int answer;
    private final List<Listener> listeners;

    public Model() {
        listeners = new ArrayList<>();
    }

    public void generateNumber() {
        number = (int) (Math.random() * 32);
        notifyGenerateNumber();
    }

    public int getBinaryNumber() {
        return Integer.parseInt(Integer.toBinaryString(number));
    }

    public void checkAnswer() {
        if (answer == -1) notifyGameEnded();
        else if (answer == -999) notifyTimeout();
        else if (number == answer) notifyCorrectAnswer();
        else notifyIncorrectAnswer();
    }

    public void setAnswer(int answer) {
        this.answer = answer;
        checkAnswer();
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    private void notifyGenerateNumber() {
        for (Listener listener : listeners) listener.onGenerateNumber();
    }

    private void notifyTimeout() {
        for (Listener listener : listeners) listener.onTimeout();
    }

    private void notifyCorrectAnswer() {
        for (Listener listener : listeners) listener.onCorrectAnswer();
    }

    private void notifyIncorrectAnswer() {
        for (Listener listener : listeners) listener.onIncorrectAnswer();
    }

    private void notifyGameEnded() {
        for (Listener listener : listeners) listener.onGameEnded();
    }

}