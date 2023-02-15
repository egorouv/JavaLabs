import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Calculate st = new Calculate();
        Stack<Double> stack = new Stack<>();
        Map<String, Double> map = new HashMap<>();
        st.setStack(stack);
        st.setMap(map);
        Handler handler = new Handler();

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        while (!str.equals("x")) {
            handler.checkInput(str, st);
            str = scanner.nextLine();
        }

    }
}