package ru.nsu.egorov.game2048.model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Field {

    private static final int size = 4;
    private int[][] field;
    private boolean flag;
    private int score;
    private int highScore;
    private final List<FieldListener> fieldListeners;

    public Field() {
        fieldListeners = new ArrayList<>();
    }

    public void addListener(FieldListener fieldListener) {
        fieldListeners.add(fieldListener);
    }

    private void notifyMovingCells() throws IOException {
        for (FieldListener fieldListener : fieldListeners) fieldListener.onMovingCells();
    }

    public int[][] getField() {
        return field;
    }

    public int getState(int x, int y) {
        return field[x][y];
    }

    public boolean isFlag() {
        return flag;
    }

    public int getScore() {
        return score;
    }

    public int getSize() {
        return size;
    }

    public void highScoreFromFile() {
        Path path = Paths.get("D:\\source\\JavaLabs\\Game2048\\src\\ru\\nsu\\egorov\\game2048\\model\\HighScore");
        try (FileReader fileReader = new FileReader(path.toFile())) {
            Scanner scanner = new Scanner(fileReader);
            highScore = Integer.parseInt(String.valueOf(scanner.nextInt()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setHighScore(int score) {
        highScore = score;
        try (FileWriter writer = new FileWriter("D:\\source\\JavaLabs\\Game2048\\src\\ru\\nsu\\egorov\\game2048\\model\\HighScore", false)) {
            String highScore = String.valueOf(score);
            writer.write(highScore);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getHighScore() {
        return highScore;
    }

    public void initializeField() {
        field = new int[size][size];
        for (int i = 0; i < size; i++) Arrays.fill(field[i], 0);
        int firstX = (int) (Math.random() * size);
        int firstY = (int) (Math.random() * size);
        int secondX = (int) (Math.random() * size);
        int secondY = (int) (Math.random() * size);
        while (firstX == secondX && firstY == secondY) {
            secondX = (int) (Math.random() * size);
            secondY = (int) (Math.random() * size);
        }
        field[firstX][firstY] = 2;
        field[secondX][secondY] = 2;
        flag = true;
        score = 0;
        highScoreFromFile();
    }

    public boolean checkMovement() {
        int movement = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (getState(i, j) == 0 || getState(i + 1, j) == 0 || getState(i, j + 1) == 0) movement++;
                if (getState(i, j) == getState(i + 1, j) || getState(i, j) == getState(i, j + 1)) movement++;
            }
        }
        return movement > 0;
    }

    public void moveCells(String direction) throws IOException {

        switch (direction.toUpperCase()) {

            case "UP" -> {
                for (int i = 1; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (field[i][j] != 0) {
                            int tmp = i;
                            while (tmp > 0) {
                                if (field[tmp - 1][j] == 0) {
                                    field[tmp - 1][j] = field[tmp][j];
                                    field[tmp][j] = 0;
                                } else if (field[tmp - 1][j] == field[tmp][j]) {
                                    field[tmp - 1][j] += field[tmp][j];
                                    field[tmp][j] = 0;
                                    score += field[tmp - 1][j];
                                    setHighScore(score);
                                    if (getState(tmp - 1, j) == 2048) flag = false;
                                }
                                tmp--;
                            }
                        }
                    }
                }
                notifyMovingCells();
            }

            case "DOWN" -> {
                for (int i = size - 2; i >= 0; i--) {
                    for (int j = 0; j < size; j++) {
                        if (field[i][j] != 0) {
                            int tmp = i;
                            while (tmp < size - 1) {
                                if (field[tmp + 1][j] == 0) {
                                    field[tmp + 1][j] = field[tmp][j];
                                    field[tmp][j] = 0;
                                } else if (field[tmp + 1][j] == field[tmp][j]) {
                                    field[tmp + 1][j] += field[tmp][j];
                                    field[tmp][j] = 0;
                                    score += field[tmp + 1][j];
                                    setHighScore(score);
                                    if (getState(tmp + 1, j) == 2048) flag = false;
                                }
                                tmp++;
                            }
                        }
                    }
                }
                notifyMovingCells();
            }

            case "LEFT" -> {
                for (int i = 0; i < size; i++) {
                    for (int j = 1; j < size; j++) {
                        if (field[i][j] != 0) {
                            int tmp = j;
                            while (tmp > 0) {
                                if (field[i][tmp - 1] == 0) {
                                    field[i][tmp - 1] = field[i][tmp];
                                    field[i][tmp] = 0;
                                } else if (field[i][tmp - 1] == field[i][tmp]) {
                                    field[i][tmp - 1] += field[i][tmp];
                                    field[i][tmp] = 0;
                                    score += field[i][tmp - 1];
                                    setHighScore(score);
                                    if (getState(i, tmp - 1) == 2048) flag = false;
                                }
                                tmp--;
                            }
                        }
                    }
                }
                notifyMovingCells();
            }

            case "RIGHT" -> {
                for (int i = 0; i < size; i++) {
                    for (int j = size - 2; j >= 0; j--) {
                        if (field[i][j] != 0) {
                            int tmp = j;
                            while (tmp < size - 1) {
                                if (field[i][tmp + 1] == 0) {
                                    field[i][tmp + 1] = field[i][tmp];
                                    field[i][tmp] = 0;
                                } else if (field[i][tmp + 1] == field[i][tmp]) {
                                    field[i][tmp + 1] += field[i][tmp];
                                    field[i][tmp] = 0;
                                    score += field[i][tmp + 1];
                                    setHighScore(score);
                                    if (getState(i, tmp + 1) == 2048) flag = false;
                                }
                                tmp++;
                            }
                        }
                    }
                }
                notifyMovingCells();
            }

            case "EXIT" -> System.exit(0);

            default -> System.out.println("Enter direction or exit");

        }

        int newX = (int) (Math.random() * size);
        int newY = (int) (Math.random() * size);
        while (getState(newX, newY) != 0) {
            newX = (int) (Math.random() * size);
            newY = (int) (Math.random() * size);
        }
        field[newX][newY] = 2;

    }

}
