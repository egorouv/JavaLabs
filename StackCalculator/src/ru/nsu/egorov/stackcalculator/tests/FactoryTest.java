package ru.nsu.egorov.stackcalculator.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.egorov.stackcalculator.handler.Operation;
import ru.nsu.egorov.stackcalculator.handler.OperationFactory;


class FactoryTest {

    OperationFactory factory = new OperationFactory();

    @Test
    void createOperationAdd() {
        Operation operation = factory.createOperation("+");
        Assertions.assertEquals(operation.getClass().getSimpleName(), "AddOperation");
    }

    @Test
    void createOperationSub() {
        Operation operation = factory.createOperation("-");
        Assertions.assertEquals(operation.getClass().getSimpleName(), "SubOperation");
    }

    @Test
    void createOperationMul() {
        Operation operation = factory.createOperation("*");
        Assertions.assertEquals(operation.getClass().getSimpleName(), "MulOperation");
    }

    @Test
    void createOperationDiv() {
        Operation operation = factory.createOperation("/");
        Assertions.assertEquals(operation.getClass().getSimpleName(), "DivOperation");
    }

    @Test
    void createOperationSqrt() {
        Operation operation = factory.createOperation("SQRT");
        Assertions.assertEquals(operation.getClass().getSimpleName(), "SqrtOperation");
    }

    @Test
    void createOperationPush() {
        Operation operation = factory.createOperation("PUSH");
        Assertions.assertEquals(operation.getClass().getSimpleName(), "PushOperation");
    }

    @Test
    void createOperationPop() {
        Operation operation = factory.createOperation("POP");
        Assertions.assertEquals(operation.getClass().getSimpleName(), "PopOperation");
    }

    @Test
    void createOperationDefine() {
        Operation operation = factory.createOperation("DEFINE");
        Assertions.assertEquals(operation.getClass().getSimpleName(), "DefineOperation");
    }

    @Test
    void createOperationPrint() {
        Operation operation = factory.createOperation("PRINT");
        Assertions.assertEquals(operation.getClass().getSimpleName(), "PrintOperation");
    }

}