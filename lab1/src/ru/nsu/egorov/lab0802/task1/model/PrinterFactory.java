package ru.nsu.egorov.lab0802.task1.model;

public class PrinterFactory {

    public Printer createPrinter(String name) {
        if (name.equalsIgnoreCase("Hello")) return new HelloPrinter();
        else if (name.equalsIgnoreCase("Bye")) return new ByePrinter();
        return null;
    }

}
