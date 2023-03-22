package ru.nsu.egorov.stackcalculator.handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class OperationFactory implements Factory {

    private final Map<String, String> operationsMap = new HashMap<>();

    public OperationFactory() {
        try (InputStream is = OperationFactory.class.getResourceAsStream("operations.properties")) {
            assert is != null;
            try (InputStreamReader reader = new InputStreamReader(is)) {
                Properties properties = new Properties();
                properties.load(reader);
                for (String operationName : properties.stringPropertyNames()) {
                    String className = properties.getProperty(operationName.toUpperCase());
                    operationsMap.put(operationName.toUpperCase(), className);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load operation properties", e);
        }
    }

    @Override
    public Operation createOperation(String operationName) {
        try {
            String className = operationsMap.get(operationName.toUpperCase());
            Class<?> clazz = Class.forName(className);
            return (Operation) clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create operation: " + operationName, e);
        }
    }

}
