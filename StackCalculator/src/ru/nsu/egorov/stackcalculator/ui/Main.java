package ru.nsu.egorov.stackcalculator.ui;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        InputReader reader = new InputReader();
        if (args.length == 0) reader.inputReader("Stream");
        else reader.inputReader(args[0]);

    }

}