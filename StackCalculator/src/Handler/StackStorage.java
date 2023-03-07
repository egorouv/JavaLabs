package Handler;

import java.util.Map;
import java.util.Stack;

public class StackStorage {

    private Stack<Double> stack;
    private Map<String, Double> map;
    private String input;

    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    public Stack<Double> getStack() {
        return stack;
    }

    public void setMap(Map<String, Double> map) {
        this.map = map;
    }

    public Map<String, Double> getMap() {
        return map;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

}
