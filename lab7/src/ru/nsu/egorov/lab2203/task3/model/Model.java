package ru.nsu.egorov.lab2203.task3.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private int number;
    private int answer;
    private final List<ModelListener> modelListeners;

    public Model() {
        modelListeners = new ArrayList<>();
    }

    public void generateNumber() {
        number = (int) (Math.random() * 31);
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

    public void addListener(ModelListener modelListener) {
        modelListeners.add(modelListener);
    }

    private void notifyGenerateNumber() {
        for (ModelListener modelListener : modelListeners) modelListener.onGenerateNumber();
    }

    private void notifyTimeout() {
        for (ModelListener modelListener : modelListeners) modelListener.onTimeout();
    }

    private void notifyCorrectAnswer() {
        for (ModelListener modelListener : modelListeners) modelListener.onCorrectAnswer();
    }

    private void notifyIncorrectAnswer() {
        for (ModelListener modelListener : modelListeners) modelListener.onIncorrectAnswer();
    }

    private void notifyGameEnded() {
        for (ModelListener modelListener : modelListeners) modelListener.onGameEnded();
    }

}