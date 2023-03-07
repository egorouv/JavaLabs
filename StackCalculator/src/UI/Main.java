package UI;

import Handler.Operation;
import Handler.OperationFactory;
import Handler.StackStorage;

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
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String str;
                while((str = br.readLine()) != null) {
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
                while((str = br.readLine()) != null){
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