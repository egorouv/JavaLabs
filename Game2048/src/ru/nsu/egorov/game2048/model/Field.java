package ru.nsu.egorov.game2048.model;

import java.util.Arrays;

public class Field {

    private static final int size = 4;
    private int[][] field;

    public int[][] getField() {
        return field;
    }

    public void initializeField() {
        field = new int[size][size];
        for (int i = 0; i < size; i++) Arrays.fill(field[i], 0);
        int firstX = (int) (Math.random() * size);
        int firstY = (int) (Math.random() * size);
        int secondX = (int) (Math.random() * size);
        int secondY = (int) (Math.random() * size);
        field[firstX][firstY] = 2;
        field[secondX][secondY] = 2;
    }

    public void moveCells(String direction) {
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
                                }
                                tmp--;
                            }
                        }
                    }
                }
            }
            case "DOWN" -> {
                for (int i = size - 2; i >= 0; i--) {
                    for (int j = 0; j < size; j++) {
                        if (field[i][j] != 0) {
                            int tmp = i;
                            while (tmp < 3) {
                                if (field[tmp + 1][j] == 0) {
                                    field[tmp + 1][j] = field[tmp][j];
                                    field[tmp][j] = 0;
                                } else if (field[tmp + 1][j] == field[tmp][j]) {
                                    field[tmp + 1][j] += field[tmp][j];
                                    field[tmp][j] = 0;
                                }
                                tmp++;
                            }
                        }
                    }
                }
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
                                }
                                tmp--;
                            }
                        }
                    }
                }
            }
            case "RIGHT" -> {
                for (int i = 0; i < size; i++) {
                    for (int j = size - 2; j >= 0; j--) {
                        if (field[i][j] != 0) {
                            int tmp = j;
                            while (tmp < 3) {
                                if (field[i][tmp + 1] == 0) {
                                    field[i][tmp + 1] = field[i][tmp];
                                    field[i][tmp] = 0;
                                } else if (field[i][tmp + 1] == field[i][tmp]) {
                                    field[i][tmp + 1] += field[i][tmp];
                                    field[i][tmp] = 0;
                                }
                                tmp++;
                            }
                        }
                    }
                }
            }
            default -> {

            }
        }
        int newX = (int) (Math.random() * size);
        int newY = (int) (Math.random() * size);
        while (field[newX][newY] != 0) {
            newX = (int) (Math.random() * size);
            newY = (int) (Math.random() * size);
        }
        field[newX][newY] = 2;
    }

}
