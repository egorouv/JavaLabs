package Operations;

import Handler.Operation;
import Handler.StackStorage;

import java.util.Stack;

public class PopOperation implements Operation {

    @Override
    public void getResult(StackStorage stackStorage) {
        Stack<Double> stack = stackStorage.getStack();
        stack.pop();
        stackStorage.setStack(stack);
    }

}
