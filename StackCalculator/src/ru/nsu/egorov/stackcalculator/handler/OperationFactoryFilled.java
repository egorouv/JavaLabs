package ru.nsu.egorov.stackcalculator.handler;

import java.util.HashMap;
import java.util.Map;

public class OperationFactoryFilled implements Factory {

    private final OperationFactory factory;

    private final Map<String, Operation> operationsMapFilled = new HashMap<>();

    public OperationFactoryFilled(OperationFactory factory) {
        this.factory = factory;
    }

    @Override
    public Operation createOperation(String operationName) {
        if (!operationsMapFilled.containsKey(operationName)) {
            Operation operation = factory.createOperation(operationName);
            operationsMapFilled.put(operationName.toUpperCase(), operation);
        }
        return operationsMapFilled.get(operationName.toUpperCase());
    }

}
