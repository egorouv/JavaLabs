package ru.nsu.egorov.stackcalculator.ui;

import ru.nsu.egorov.stackcalculator.handler.Operation;
import ru.nsu.egorov.stackcalculator.handler.OperationFactory;
import ru.nsu.egorov.stackcalculator.handler.StackStorage;

import java.io.*;

public class InputReader {

    public void inputReader(String args, StackStorage stackStorage, OperationFactory factory) throws IOException {

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
            Operation operation = factory.createOperation(subStr[0]);
            operation.getResult(stackStorage);
        }

    }

}
