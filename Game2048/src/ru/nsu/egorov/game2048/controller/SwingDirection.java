package ru.nsu.egorov.game2048.controller;

import ru.nsu.egorov.game2048.model.Field;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class SwingDirection implements KeyListener, ActionListener {

    private final Field field;

    public SwingDirection(Field field) {
        this.field = field;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            try {
                field.moveCells("up");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            try {
                field.moveCells("down");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            try {
                field.moveCells("left");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            try {
                field.moveCells("right");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("finish")) System.exit(0);
        else if (e.getActionCommand().equals("restart")) {
            try {
                field.restartGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
