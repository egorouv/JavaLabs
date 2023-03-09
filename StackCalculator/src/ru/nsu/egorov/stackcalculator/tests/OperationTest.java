package ru.nsu.egorov.stackcalculator.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.egorov.stackcalculator.handler.Operation;
import ru.nsu.egorov.stackcalculator.handler.OperationFactory;
import ru.nsu.egorov.stackcalculator.handler.StackStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class OperationTest {

    OperationFactory factory = new OperationFactory();
    StackStorage stackStorage = new StackStorage();
    Stack<Double> stack = new Stack<>();
    Map<String, Double> map = new HashMap<>();

    @Test
    void operationAdd() {

        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        String str = "PUSH 99999.10";
        stackStorage.setInput(str);
        String[] subStr = str.split(" ");
        Operation operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "PUSH 15000";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "+";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);

        Stack<Double> result = new Stack<>();
        result.push(114999.10);
        Assertions.assertEquals(stackStorage.getStack(), result);

    }

    @Test
    void operationSub() {

        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        String str = "PUSH 99999.10";
        stackStorage.setInput(str);
        String[] subStr = str.split(" ");
        Operation operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "PUSH 15000";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "-";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);

        Stack<Double> result = new Stack<>();
        result.push(84999.1);
        Assertions.assertEquals(stackStorage.getStack(), result);

    }

    @Test
    void operationMul() {

        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        String str = "PUSH 888.1";
        stackStorage.setInput(str);
        String[] subStr = str.split(" ");
        Operation operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "PUSH 999.0";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "*";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);

        Stack<Double> result = new Stack<>();
        result.push(887211.9);
        Assertions.assertEquals(stackStorage.getStack(), result);

    }

    @Test
    void operationDiv() {

        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        String str = "PUSH 887211.9";
        stackStorage.setInput(str);
        String[] subStr = str.split(" ");
        Operation operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "PUSH 888.1";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "/";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);

        Stack<Double> result = new Stack<>();
        result.push(999.0);
        Assertions.assertEquals(stackStorage.getStack(), result);

    }

    @Test
    void operationSqrt() {

        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        String str = "PUSH 308025.0";
        stackStorage.setInput(str);
        String[] subStr = str.split(" ");
        Operation operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "SQRT";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);

        Stack<Double> result = new Stack<>();
        result.push(555.0);
        Assertions.assertEquals(stackStorage.getStack(), result);

    }

    @Test
    void operationPush() {

        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        String str = "PUSH 1";
        stackStorage.setInput(str);
        String[] subStr = str.split(" ");
        Operation operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "PUSH 2";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);

        Stack<Double> result = new Stack<>();
        result.push(1.0);
        result.push(2.0);
        Assertions.assertEquals(stackStorage.getStack(), result);

    }

    @Test
    void operationPop() {

        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        String str = "PUSH 1";
        stackStorage.setInput(str);
        String[] subStr = str.split(" ");
        Operation operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "POP";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);

        Stack<Double> result = new Stack<>();
        Assertions.assertEquals(stackStorage.getStack(), result);

    }

    @Test
    void operationDefine() {

        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        String str = "DEFINE a 99999";
        stackStorage.setInput(str);
        String[] subStr = str.split(" ");
        Operation operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "PUSH a";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);

        Stack<Double> result = new Stack<>();
        result.push(99999.0);
        Assertions.assertEquals(stackStorage.getStack(), result);

    }

    @Test
    void operationPrint() {

        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        String str = "PUSH 1";
        stackStorage.setInput(str);
        String[] subStr = str.split(" ");
        Operation operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);
        str = "PRINT";
        stackStorage.setInput(str);
        subStr = str.split(" ");
        operation = factory.createOperation(subStr[0]);
        operation.getResult(stackStorage);

        Stack<Double> result = new Stack<>();
        result.push(1.0);
        System.out.println(result.peek());

    }

}
