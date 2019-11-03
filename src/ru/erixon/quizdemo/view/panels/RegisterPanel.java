package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RegisterPanel extends BorderLayoutPanel implements ActionListener {
    private CheckboxGroup cbg = new CheckboxGroup();
    private Checkbox cbTeacher = new Checkbox("Teacher", cbg, false);
    private Checkbox cbStudent = new Checkbox("Student", cbg, true);
    private Button btnTeacher = new Button("Teacher");
    private Button btnStudent = new Button("Student");
    private StudentRegisterFormPanel pnlStudentRegister = new StudentRegisterFormPanel();
    private TeacherRegisterFromPanel pnlTeacherRegister = new TeacherRegisterFromPanel();
    private State state = State.STUDENT;

    public RegisterPanel() {
        initButtons();
        stateChangeHandle();
    }

    private void initButtons() {
        btnTeacher.addActionListener(this);
        btnStudent.addActionListener(this);
        Panel panel = new Panel(new GridLayout(1,2));
        panel.add(btnStudent);
        panel.add(btnTeacher);
        this.add(panel,BorderLayout.NORTH);
    }

    private void changeRegisterPanels(){
       if (state == State.TEACHER) {
           this.remove(pnlStudentRegister);
           this.add(pnlTeacherRegister, BorderLayout.CENTER);
       }  else if (state == State.STUDENT) {
           this.remove(pnlTeacherRegister);
           this.add(pnlStudentRegister, BorderLayout.CENTER);
       }
       this.validate();
//       this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        State oldState = this.state;

        if (source.equals(btnStudent)) {
            this.state = State.STUDENT;
        }
        else if (source.equals(btnTeacher)){
            this.state = State.TEACHER;

        }

        if (oldState != this.state) {
            stateChangeHandle();
        }

    }

    private void stateChangeHandle() {
        changeRegisterPanels();
        if (state == State.TEACHER) {
            btnTeacher.setBackground(Color.GREEN);
            btnStudent.setBackground(Color.LIGHT_GRAY);
        }
        else if (state == State.STUDENT) {
            btnStudent.setBackground(Color.GREEN);
            btnTeacher.setBackground(Color.LIGHT_GRAY);
        }
    }

    private static enum State {
        STUDENT, TEACHER
    }
}
