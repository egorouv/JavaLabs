package ru.nsu.egorov.lab0802.task1.ui;

import ru.nsu.egorov.lab0802.task1.model.Printer;
import ru.nsu.egorov.lab0802.task1.model.PrinterFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Print 'Hello' or 'Bye' to create correct printer: ");
        String str = scanner.nextLine();
        System.out.print("Print 'N': ");
        int n = scanner.nextInt();
        PrinterFactory printerFactory = new PrinterFactory();
        Printer printer = printerFactory.createPrinter(str);
        printer.print(n);
    }
}