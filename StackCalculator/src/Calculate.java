import java.util.Map;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class Calculate {

    private Stack<Double> stack;

    private Map<String, Double> map;

    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    public void setMap(Map<String, Double> map) {
        this.map = map;
    }

    public Map<String, Double> getMap() {
        return map;
    }

    public void popNum() {
        stack.pop();
    }

    public void pushNum(double num) {
        stack.push(num);
    }

    public void addNum() {
        double num1 = stack.pop();
        double num2 = stack.pop();
        stack.push(num2 + num1);
    }

    public void subNum() {
        double num1 = stack.pop();
        double num2 = stack.pop();
        stack.push(num2 - num1);
    }

    public void mulNum() {
        double num1 = stack.pop();
        double num2 = stack.pop();
        stack.push(num2 * num1);
    }

    public void divNum() {
        double num1 = stack.pop();
        double num2 = stack.pop();
        stack.push(num2 / num1);
    }

    public void sqrtNum() {
        double num = stack.pop();
        stack.push(sqrt(num));
    }

    public void printNum() {
        System.out.println(stack.peek());
    }

    public void defineNum(String str, double num) {
        map.put(str, num);
    }

}
