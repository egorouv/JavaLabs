package com.egorov.lab1204.task2;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("google.com", 80);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("GET " + "/" + " HTTP/1.0");
        writer.println("");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
        writer.close();
        socket.close();
    }
}

/*
    mvn compile
    mvn exec:java -Dexec.mainClass="ru.nsu.egorov.lab1904.task2.Client"
*/
