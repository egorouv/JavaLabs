package ru.nsu.egorov.lab1503.task3.model;

public class Model {

    private int number;

    public void generateNumber() {
        number = (int) (Math.random() * 31);
    }

    public int getBinaryNumber() {
        return Integer.parseInt(Integer.toBinaryString(number));
    }

    public boolean checkAnswer(int answer) {
        if (answer == -1) System.exit(0);
        if (answer < 0 || answer > 31) return false;
        return answer == number;
    }

}
