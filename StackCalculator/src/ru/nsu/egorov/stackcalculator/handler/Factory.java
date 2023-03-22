package ru.nsu.egorov.stackcalculator.handler;

public interface Factory {

    Operation createOperation(String operationName);

}
