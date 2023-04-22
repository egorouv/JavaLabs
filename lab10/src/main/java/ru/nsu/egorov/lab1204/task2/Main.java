package ru.nsu.egorov.lab1204.task2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your name: ");
        String name = scanner.nextLine();
        System.out.print("Type your age: ");
        int age = scanner.nextInt();

        DataStructure dataStructure = new DataStructure();
        dataStructure.setName(name);
        dataStructure.setAge(age);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            FileWriter fileWriter = new FileWriter("data.json");
            fileWriter.write(objectMapper.writeValueAsString(dataStructure));
            fileWriter.close();

            /*String json = new String(Files.readAllBytes(Paths.get("data.json")));
            DataStructure dataFromFile = objectMapper.readValue(json, DataStructure.class);

            System.out.println("Name: " + dataFromFile.getName());
            System.out.println("Age: " + dataFromFile.getAge());*/
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//mvn exec:java -Dexec.mainClass="ru.nsu.egorov.lab1204.task2.Main"