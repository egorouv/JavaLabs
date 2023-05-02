package ru.nsu.egorov.game2048.view;

import ru.nsu.egorov.game2048.model.Field;
import ru.nsu.egorov.game2048.model.FieldListener;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class SwingView extends JFrame implements FieldListener {

    private final Field field;
    private JPanel[][] cells;

    public SwingView(Field field) {
        this.field = field;
        field.addListener(this);
    }

    public void userInterface() throws IOException {

        setTitle("Game2048. " + "Score: " + field.getScore() + ", Highscore: " + field.getHighScore());
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cells = new JPanel[field.getSize()][field.getSize()];
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(field.getSize(), field.getSize()));

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                cells[i][j] = new JPanel();
                contentPane.add(cells[i][j]);
                Properties colors = new Properties();
                try (BufferedReader reader = new BufferedReader
                        (new InputStreamReader(Objects.requireNonNull
                                (getClass().getResourceAsStream("colors.properties"))))) {
                    colors.load(reader);
                }
                cells[i][j].setBackground(Color.decode(colors.getProperty(String.valueOf(field.getState(i, j)))));
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                JLabel label = new JLabel(String.valueOf(field.getState(i, j)));
                label.setFont(new Font("HelveticaNeue", Font.BOLD, 30));
                label.setHorizontalAlignment(JLabel.CENTER);
                cells[i][j].add(label);
            }
        }

        setVisible(true);
    }

    public void showChangedField() throws IOException {
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                Properties colors = new Properties();
                try (BufferedReader reader = new BufferedReader
                        (new InputStreamReader(Objects.requireNonNull
                                (getClass().getResourceAsStream("colors.properties"))))) {
                    colors.load(reader);
                }
                cells[i][j].removeAll();
                cells[i][j].setBackground(Color.decode(colors.getProperty(String.valueOf(field.getState(i, j)))));
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                JLabel label = new JLabel(String.valueOf(field.getState(i, j)));
                label.setFont(new Font("HelveticaNeue", Font.BOLD, 30));
                label.setHorizontalAlignment(JLabel.CENTER);
                cells[i][j].add(label);
            }
        }
        setVisible(true);
    }

    @Override
    public void onMovingCells() throws IOException {
        showChangedField();
        if (field.isFlag() && field.checkMovement()) {
            setTitle("Game2048. " + "Score: " + field.getScore() + ", Highscore: " + field.getHighScore());
        }
        else {
            setTitle("Game2048. " + "Score: " + field.getScore() + ", Highscore: " + field.getHighScore() + " Game over!");
        }
    }

}
