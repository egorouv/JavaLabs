package ru.nsu.egorov.lab0103.task3.ui;

import ru.nsu.egorov.lab0103.task3.model.Modes;
import ru.nsu.egorov.lab0103.task3.model.NumberFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        String s = "";

        System.out.println("Type path to the file and 'sum' or 'mul' to choose what to do");

        try (BufferedReader br = new BufferedReader (new InputStreamReader(System.in))) {
            s = br.readLine();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        String[] subStr = s.split(" ");
        NumberFile<Number> numberFile = new NumberFile<>(subStr[0]);
        Modes mode = Modes.valueOf(subStr[1].toUpperCase());
        long result = 0;

        switch (mode) {
            case SUM -> {
                for (Number number : numberFile) {
                    result += number.longValue();
                }
            }
            case MUL -> {
                result = 1;
                for (Number number : numberFile) {
                    result *= number.longValue();
                }
            }
        }

        System.out.println("Result with " + subStr[1].toLowerCase() + ": " + result);

    }
}