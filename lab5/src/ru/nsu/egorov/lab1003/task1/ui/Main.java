package ru.nsu.egorov.lab1003.task1.ui;

import ru.nsu.egorov.lab1003.task1.model.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        Storage<String> storage = new Storage<>(Integer.parseInt(subStr[0]));

        for (int i = 0; i < Integer.parseInt(subStr[1]); i++) {
            int finalI = i;
            Thread producerThread = new Thread(() -> {
                while (!Thread.interrupted()) {
                    for (int j = 1; j <= Integer.parseInt(subStr[0]); j++) {
                        String item = "p" + finalI + '-' + j;
                        try {
                            storage.put(item);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            });
            producerThread.start();
        }

        for (int i = 0; i < Integer.parseInt(subStr[2]); i++) {
            int finalI = i;
            Thread consumerThread = new Thread(() -> {
                while (!Thread.interrupted()) {
                    try {
                        String item = storage.take();
                        System.out.println("с" + finalI + " consumes " + item);
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            consumerThread.start();
        }

    }
}