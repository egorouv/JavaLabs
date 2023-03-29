package ru.nsu.egorov.lab2903.task1.ui;

import ru.nsu.egorov.lab2903.task1.model.BlockingQueueStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        System.out.print("Type N, P, C (size, producers, consumers): ");

        String str;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            str = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] subStr = str.split(" ");

        BlockingQueueStorage<String> storage = new BlockingQueueStorage<>(Integer.parseInt(subStr[0]));
        ExecutorService producerThreadPool = Executors.newFixedThreadPool(Integer.parseInt(subStr[1]));
        ExecutorService consumerThreadPool = Executors.newFixedThreadPool(Integer.parseInt(subStr[2]));

        for (int i = 0; i < Integer.parseInt(subStr[1]); i++) {
            int finalI = i;
            producerThreadPool.submit(() ->  {
                while (!Thread.interrupted()) {
                    for (int j = 0; j < Integer.parseInt(subStr[0]); j++) {
                        String item = "p" + finalI + "-" + j;
                        try {
                            storage.put(item);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            });
        }

        for (int i = 0; i < Integer.parseInt(subStr[2]); i++) {
            int finalI = i;
            consumerThreadPool.submit(() ->  {
                while (!Thread.interrupted()) {
                    try {
                        String item = storage.take();
                        System.out.println("c" + finalI + " consumes " + item);
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

    }
}