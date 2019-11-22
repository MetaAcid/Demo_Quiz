package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.TeacherDao_old;
import ru.erixon.quizdemo.controller.utils.HashingTools;
import ru.erixon.quizdemo.model.user.Teacher;
import ru.erixon.quizdemo.view.frames.TeacherFrame;

import javax.swing.*;
import java.sql.SQLException;

public class TeacherPanel extends LogInPanel<Teacher> {
    private JLabel lblClassId = new JLabel("Class ID");
    private JTextField txtClassId = new JTextField();
    private TeacherDao_old teacherDaoOld = new TeacherDao_old(Application.manager.getConnection());

    public TeacherPanel() {
        lblClassId.setBounds(xOff, yOff + 60, 100, 20);
        txtClassId.setBounds(xOff + 100, yOff + 60, 100, 20);
        this.add(lblClassId);
        this.add(txtClassId);
    }

    @Override
    protected Teacher checkLogin() {
        String passwordHash = HashingTools.hash(this.txtPassword.getPassword());
        try {
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doLogin(Teacher teacher) {
        TeacherFrame frame = new TeacherFrame(null,"Teacher Window", teacher);
    }

}
