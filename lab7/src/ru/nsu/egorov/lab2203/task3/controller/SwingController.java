package ru.nsu.egorov.lab2203.task3.controller;

import ru.nsu.egorov.lab2203.task3.model.Model;
import ru.nsu.egorov.lab2203.task3.view.SwingView;

public class SwingController {

    private final Model model;
    private final SwingView swingView;

    public SwingController(Model model, SwingView swingView) {
        this.model = model;
        this.swingView = swingView;
    }

    public void inputAnswer() {

        swingView.getButton().addActionListener(e -> {
            String answer = String.valueOf(swingView.getTextField().getText());
            try {
                model.setAnswer(Integer.parseInt(answer));
            } catch (NumberFormatException ex) {
                model.setAnswer(-99);
            }
        });

    }

}
