package ru.nsu.egorov.lab0802.task1.model;

public class HelloPrinter implements Printer {

    @Override
    public void print(int n) {
        int k = (int) (Math.random() * ++n) + (n-1);
        for (int i = 0; i < n + k; i++) {
            System.out.println("Hello!");
        }
    }

}
