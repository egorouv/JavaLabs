package ru.nsu.egorov.stackcalculator.ui;

import ru.nsu.egorov.stackcalculator.handler.Operation;
import ru.nsu.egorov.stackcalculator.handler.OperationFactory;
import ru.nsu.egorov.stackcalculator.handler.StackStorage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        OperationFactory factory = new OperationFactory();
        StackStorage stackStorage = new StackStorage();
        Stack<Double> stack = new Stack<>();
        Map<String, Double> map = new HashMap<>();
        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        if (args.length == 0) {
            System.out.println("""
                    
                    Stack Calculator. Type 'EXIT' to exit the program. Here is how to use it:
                    
                    # - a line with a comment.
                    POP, PUSH — remove/put a number from/on the stack.
                    +, -, *, /, SQRT – arithmetic operations. Use one or two top
                    stack items, pop them off the stack, pushing the result back.
                    PRINT - print the top element of the stack (without deletion).
                    DEFINE - set the value of the parameter.
                    In the future, everywhere use instead of parameter is the value.
                    
                    Example (result is 2):
                    DEFINE a 4
                    PUSH a
                    SQRT
                    PRINT
                    """);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String str;
                while ((str = br.readLine()) != null) {
                    if (str.equalsIgnoreCase("EXIT")) System.exit(0);
                    stackStorage.setInput(str);
                    String[] subStr = str.split(" ");
                    Operation operation = factory.createOperation(subStr[0]);
                    operation.getResult(stackStorage);
                }
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }

        else {
            FileInputStream file;
            try {
                file = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
                String str;
                while ((str = br.readLine()) != null) {
                    stackStorage.setInput(str);
                    String[] subStr = str.split(" ");
                    Operation operation = factory.createOperation(subStr[0]);
                    operation.getResult(stackStorage);
                }
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }

    }

}