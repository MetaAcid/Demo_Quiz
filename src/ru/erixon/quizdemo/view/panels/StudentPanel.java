package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.view.frames.StudentFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPanel extends LogInPanel implements ActionListener {

    public StudentPanel() {
        this.btnLogIn.addActionListener(this);
    }

    private boolean checkLogin(){
        return true;
    }

    private void printLoginError(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnLogIn)) {
            if (checkLogin()) {
                StudentFrame frame = new StudentFrame(null, "Quiz");
            }
            else {
                printLoginError();
            }
        }
    }
}
