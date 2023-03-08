package ru.nsu.egorov.stackcalculator.operations;

import ru.nsu.egorov.stackcalculator.handler.Operation;
import ru.nsu.egorov.stackcalculator.handler.StackStorage;

import java.util.Stack;

public class SqrtOperation implements Operation {

    @Override
    public void getResult(StackStorage stackStorage) {
        Stack<Double> stack = stackStorage.getStack();
        double num = stack.pop();
        stack.push(Math.sqrt(num));
        stackStorage.setStack(stack);
    }

}
