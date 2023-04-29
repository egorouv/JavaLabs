package ru.nsu.egorov.game2048.controller;

import ru.nsu.egorov.game2048.model.Field;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class SwingDirection implements KeyListener {

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

}
