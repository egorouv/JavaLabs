package ru.nsu.egorov.stackcalculator.ui;

import ru.nsu.egorov.stackcalculator.handler.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InputReader {

    public void inputReader(String args) throws IOException {

        //Factory factory = new OperationFactoryFilled(new OperationFactory());
        OperationFactory factory = new OperationFactory();
        StackStorage stackStorage = new StackStorage();
        Stack<Double> stack = new Stack<>();
        Map<String, Double> map = new HashMap<>();
        stackStorage.setStack(stack);
        stackStorage.setMap(map);

        BufferedReader br;
        if (args.equals("Stream")) {
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
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        else {
            FileInputStream file;
            try {
                file = new FileInputStream(args);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            br = new BufferedReader(new InputStreamReader(file));
        }

        String str;
        while ((str = br.readLine()) != null) {
            if (str.equals("")) continue;
            if (str.equalsIgnoreCase("EXIT")) System.exit(0);
            char[] strToArray = str.toCharArray();
            if (strToArray[0] == '#') continue;
            stackStorage.setInput(str);
            String[] subStr = str.split(" ");
            Operation operation;
            if (subStr[0].equalsIgnoreCase("COMPOSITE")) {
                String[] compositeStr = new String[subStr.length - 1];
                System.arraycopy(subStr, 1, compositeStr, 0, subStr.length - 1);
                operation = factory.createCompositeOperation(compositeStr);
            }
            else operation = factory.createOperation(subStr[0]);
            operation.getResult(stackStorage);
        }

    }

}
