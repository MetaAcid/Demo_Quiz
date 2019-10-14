package ru.artimenko.quizdemo;

import java.awt.*;

public class TeacherPanel extends Panel {
    private Button logIn = new Button("Log In");
    private Button back = new Button("Back");
    public TeacherPanel() {
        add(logIn);
        add(back);

    }
}
