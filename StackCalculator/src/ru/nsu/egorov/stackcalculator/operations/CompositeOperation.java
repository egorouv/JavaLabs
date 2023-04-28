package ru.nsu.egorov.stackcalculator.operations;

import ru.nsu.egorov.stackcalculator.handler.Operation;
import ru.nsu.egorov.stackcalculator.handler.StackStorage;

import java.util.List;

public class CompositeOperation implements Operation {

    private final List<Operation> operations;

    public CompositeOperation(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public void getResult(StackStorage stackStorage) {
        for (Operation operation : operations) {
            operation.getResult(stackStorage);
        }
    }

}
