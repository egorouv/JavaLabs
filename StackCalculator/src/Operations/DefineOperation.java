package Operations;

import Handler.Operation;
import Handler.StackStorage;

import java.util.Map;

public class DefineOperation implements Operation {

    @Override
    public void getResult(StackStorage stackStorage) {
        Map<String, Double> map = stackStorage.getMap();
        String[] subStr = stackStorage.getInput().split(" ");
        map.put(subStr[1], Double.parseDouble(subStr[2]));
        stackStorage.setMap(map);
    }

}
