package ru.nsu.egorov.lab1003.task1.model;

import java.util.LinkedList;
import java.util.Queue;

public class Storage<T> {

    private final int capacity;
    private final Queue<T> items = new LinkedList<>();

    public Storage(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T item) throws InterruptedException {
        while (items.size() == capacity) {
            wait();
        }
        items.offer(item);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (items.size() == 0) {
            wait();
        }
        T item = items.poll();
        notifyAll();
        return item;
    }

}