package ru.nsu.egorov.lab2604.task1;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        URL url = new URL("https://habr.com/ru/rss/best/daily/");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(url.openStream());

        NodeList nodeList = document.getElementsByTagName("item");

        for (int i = 0; i < nodeList.getLength(); i++) {
            String title = nodeList.item(i).getChildNodes().item(1).getTextContent();
            String author = nodeList.item(i).getChildNodes().item(11).getTextContent();
            String link = nodeList.item(i).getChildNodes().item(3).getTextContent();

            System.out.println("Название: " + title);
            System.out.println("Автор: " + author);
            System.out.println("Ссылка: " + link + "\n");
        }

    }
}