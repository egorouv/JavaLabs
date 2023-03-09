package ru.nsu.egorov.stackcalculator.operations;

import ru.nsu.egorov.stackcalculator.handler.Operation;
import ru.nsu.egorov.stackcalculator.handler.StackStorage;

import java.util.Map;

public class DefineOperation implements Operation {

    @Override
    public void getResult(StackStorage stackStorage) {
        Map<String, Double> map = stackStorage.getMap();
        String[] subStr = stackStorage.getInput().split(" ");
        if (stackStorage.isNumeric(subStr[1])) return;
        map.put(subStr[1], Double.parseDouble(subStr[2]));
        stackStorage.setMap(map);
    }

}
