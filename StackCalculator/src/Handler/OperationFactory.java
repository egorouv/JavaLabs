package Handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class OperationFactory {

    private final Map<String, String> operationsMap = new HashMap<>();

    public OperationFactory() {
        try (InputStream is = OperationFactory.class.getResourceAsStream("operations.properties")) {
            assert is != null;
            try (InputStreamReader reader = new InputStreamReader(is)) {
                Properties properties = new Properties();
                properties.load(reader);
                for (String operationName : properties.stringPropertyNames()) {
                    String className = properties.getProperty(operationName);
                    operationsMap.put(operationName, className);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load operation properties", e);
        }
    }

    public Operation createOperation(String operationName) {
        try {
            String className = operationsMap.get(operationName);
            Class<?> clazz = Class.forName(className);
            return (Operation) clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create operation: " + operationName, e);
        }
    }

}
