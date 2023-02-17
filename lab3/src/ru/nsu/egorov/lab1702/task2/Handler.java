package ru.nsu.egorov.lab1702.task2;

import java.io.*;
import java.util.Random;

public class Handler {

    private int lines;
    private int columns;

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public void generateCSV() {
        try (Writer writer = new BufferedWriter(new PrintWriter("test.csv"))) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < columns; j++) {
                    sb.append(randomNum());
                    sb.append(',');
                }
                sb.append("\n");
            }
            writer.write(sb.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int randomNum() {
        Random random = new Random();
        return random.nextInt(100);
    }


}
