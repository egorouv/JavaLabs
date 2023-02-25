import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Calculate st = new Calculate();
        Stack<Double> stack = new Stack<>();
        Map<String, Double> map = new HashMap<>();
        st.setStack(stack);
        st.setMap(map);
        Handler handler = new Handler();

        if (args.length == 0) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String str;
                while((str = br.readLine()) != null){
                    handler.checkInput(str, st);
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
                while((str = br.readLine()) != null){
                    handler.checkInput(str, st);
                }
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }

    }
    
}