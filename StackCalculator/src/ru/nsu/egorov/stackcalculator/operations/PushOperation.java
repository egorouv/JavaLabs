package ru.nsu.egorov.stackcalculator.operations;

import ru.nsu.egorov.stackcalculator.handler.Operation;
import ru.nsu.egorov.stackcalculator.handler.StackStorage;

import java.util.Stack;

public class PushOperation implements Operation {

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void getResult(StackStorage stackStorage) {
        Stack<Double> stack = stackStorage.getStack();
        String[] subStr = stackStorage.getInput().split(" ");
        if (isNumeric(subStr[1])) stack.push(Double.parseDouble(subStr[1]));
        else stack.push(stackStorage.getMap().get(subStr[1]));
        stackStorage.setStack(stack);
    }

}
