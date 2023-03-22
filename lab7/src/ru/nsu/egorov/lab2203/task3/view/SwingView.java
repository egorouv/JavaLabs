package ru.nsu.egorov.lab2203.task3.view;

import ru.nsu.egorov.lab2203.task3.model.Model;
import ru.nsu.egorov.lab2203.task3.model.ModelListener;

import javax.swing.*;
import java.awt.*;

public class SwingView extends JFrame implements ModelListener {

    private final Model model;

    private JTextField textField;
    private JButton button;
    private JLabel number;
    private JLabel output;
    public JLabel answer;

    public SwingView(Model model) {
        this.model = model;
        model.addListener(this);
        userInterface();
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getButton() {
        return button;
    }

    public void userInterface() {

        setTitle("Binary to Decimal Game");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Enter this number in decimal notation:");
        textField = new JTextField(20);
        button = new JButton("Check your answer!");
        number = new JLabel("");
        output = new JLabel("");
        answer = new JLabel("");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        panel.add(number);
        panel.add(textField);
        panel.add(button);
        panel.add(output);
        panel.add(answer);
        add(panel);
        setVisible(true);

    }

    @Override
    public void onGenerateNumber() {
        number.setText(String.valueOf(model.getBinaryNumber()));
    }

    @Override
    public void onCorrectAnswer() {
        output.setText("Correct!");
    }

    @Override
    public void onIncorrectAnswer() {
        output.setText("Incorrect!");
    }

    @Override
    public void onTimeout() {
        output.setText("Time is up!");
    }

    @Override
    public void onGameEnded() {
        output.setText("Finishing the game!");
        System.exit(0);
    }

}