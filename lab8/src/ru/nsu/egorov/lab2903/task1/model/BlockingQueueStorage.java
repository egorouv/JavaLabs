package ru.nsu.egorov.lab2903.task1.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueStorage<T> {

    private final BlockingQueue<T> storage;

    public BlockingQueueStorage(int capacity) {
        this.storage = new LinkedBlockingQueue<>(capacity);
    }

    public void put(T item) throws InterruptedException {
        storage.put(item);
    }

    public T take() throws InterruptedException {
        return storage.take();
    }

}