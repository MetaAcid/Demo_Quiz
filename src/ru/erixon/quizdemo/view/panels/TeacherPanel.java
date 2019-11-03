package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.view.frames.TeacherFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherPanel extends LogInPanel implements ActionListener {
    private TextField txtClassID = new TextField();

    public TeacherPanel() {
       this.pnlCenter.add(txtClassID);
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
                TeacherFrame frame = new TeacherFrame();
            }
            else {
                printLoginError();
            }
        }
    }

}
