package ru.artimenko.quizdemo;

import java.applet.Applet;
import java.awt.*;

@Deprecated
public class MainApplet extends Applet {
    private Button btnTeacher;
    private Button btnStudent;
    private Button btnRegister;
    private Frame frmTeacher;
    @Override
    public void init() {
        this.setLayout(new BorderLayout());
        btnTeacher = new Button("Teacher");
        btnStudent = new Button("Student");
        btnRegister = new Button("Register");
        Panel btnPanel = new Panel();
        btnPanel.setLayout(new GridLayout(1,3));
        btnPanel.add(btnTeacher);
        btnPanel.add(btnRegister);
        btnPanel.add(btnStudent);

//        add(btnTeacher,BorderLayout.NORTH);
//        add(btnRegister,BorderLayout.NORTH);
//        add(btnStudent, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.NORTH);
        //add(btnStudent);
       // add(btnRegister);
//        this.setLayout(new FlowLayout(FlowLayout.RIGHT))
        this.add(new TeacherPanel(), BorderLayout.CENTER);
    }


    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void paint(Graphics g){
    }


}
