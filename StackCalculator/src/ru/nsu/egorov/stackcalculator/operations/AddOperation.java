package ru.nsu.egorov.stackcalculator.operations;

import ru.nsu.egorov.stackcalculator.handler.Operation;
import ru.nsu.egorov.stackcalculator.handler.StackStorage;

import java.util.Stack;

public class AddOperation implements Operation {

    @Override
    public void getResult(StackStorage stackStorage) {
        Stack<Double> stack = stackStorage.getStack();
        double num1 = stack.pop();
        double num2 = stack.pop();
        stack.push(num2 + num1);
        stackStorage.setStack(stack);
    }

}
