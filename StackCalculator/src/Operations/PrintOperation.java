package Operations;

import Handler.Operation;
import Handler.StackStorage;

import java.util.Stack;

public class PrintOperation implements Operation {

    @Override
    public void getResult(StackStorage stackStorage) {
        Stack<Double> stack = stackStorage.getStack();
        System.out.println(stack.peek());
    }

}
