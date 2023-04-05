package ru.nsu.egorov.lab0504.task2;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static int count = 1;

    public static void main(String[] args) {

        System.out.print("Enter the number of threads: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ExecutorService service = Executors.newCachedThreadPool();
        Object object = new Object();

        for (int i = 1; i <= n; i++) {
            int finalI = i;
            service.execute(() -> {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(5000));
                    synchronized (object) {
                        while (count != finalI) object.wait();
                        count++;
                        object.notifyAll();
                        System.out.println("My number is " + finalI);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                service.shutdown();
            });
        }

    }
}

