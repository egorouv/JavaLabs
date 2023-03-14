package ru.nsu.egorov.stackcalculator.ui;

import ru.nsu.egorov.stackcalculator.handler.OperationFactory;
import ru.nsu.egorov.stackcalculator.handler.StackStorage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        OperationFactory factory = new OperationFactory();
        StackStorage stackStorage = new StackStorage();
        Stack<Double> stack = new Stack<>();
        Map<String, Double> map = new HashMap<>();
        stackStorage.setStack(stack);
        stackStorage.setMap(map);
        InputReader reader = new InputReader();
        if (args.length == 0) reader.inputReader("Stream", stackStorage, factory);
        else reader.inputReader(args[0], stackStorage, factory);

    }

}