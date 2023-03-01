package ru.nsu.egorov.lab1702.task2.ui;

import ru.nsu.egorov.lab1702.task2.model.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Handler hl = new Handler();

        String s = "";

        try (BufferedReader br = new BufferedReader (new InputStreamReader(System.in))) {
            s = br.readLine();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        String[] subStr = s.split(" ");

        hl.setColumns(Integer.parseInt(subStr[0]));
        hl.setLines(Integer.parseInt(subStr[1]));
        hl.generateCSV();

    }
}