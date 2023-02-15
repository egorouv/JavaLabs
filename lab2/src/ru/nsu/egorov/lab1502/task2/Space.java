package ru.nsu.egorov.lab1502.task2;

import java.util.Random;

public class Space  {

    private int X;
    private int Y;
    private int Z;

    Random random = new Random();

    public int randomXYZ() {
        X = random.nextInt(100);
        Y = random.nextInt(100);
        Z = random.nextInt(100);
        return random.nextInt(3);
    }

    public int randomNum() {
        return random.nextInt(100);
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getZ() {
        return Z;
    }

    public int getDist() {
        return (int) Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
    }

}
