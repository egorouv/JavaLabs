package ru.nsu.egorov.lab0103.task3.model;

import java.io.*;
import java.util.*;

public class NumberFile<T extends Number> implements Iterable<Number> {

    private final String filePath;
    private final ArrayList<Number> numbers = new ArrayList<>();

    public NumberFile(String file) {
        this.filePath = file;
    }

    @Override
    public Iterator<Number> iterator() {

        FileInputStream file;
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            String str;
            while ((str = br.readLine()) != null) {
                numbers.add(Double.parseDouble(str));
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return numbers.iterator();
    }

}
