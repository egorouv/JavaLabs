package ui;

import ru.nsu.egorov.lab1502.task2.Space;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Integer, String> colorMap = new TreeMap<>();
        Space space = new Space();
        int n = space.randomNum();
        int color;

        for (int i = 0; i < n; i++) {
            color = space.randomXYZ();
            int x = space.getX();
            int y = space.getY();
            int z = space.getZ();
            treeMap.put(space.getDist(), x + " " + y + " " + z);
            if (color == 0) colorMap.put(space.getDist(), "White");
            else if (color == 1) colorMap.put(space.getDist(), "Blue");
            else colorMap.put(space.getDist(), "Red");
        }

        for (Integer i : treeMap.keySet()) {
            System.out.println("Distance = " + i + "; (x y z) = (" + treeMap.get(i) +
                    "); Color = " + colorMap.get(i));
        }

    }
}