package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.StudentDao;
import ru.erixon.quizdemo.controller.utils.HashingTools;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.user.Student;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class StudentRegisterFormPanel extends RegisterFormPanel {
    private JLabel lblClassID = new JLabel("Class ID:");
    private JTextField txtClassID = new JTextField(15);
    private StudentDao studentDao = new StudentDao(Application.manager.getConnection());

    public StudentRegisterFormPanel() {
        lblClassID.setBounds(xOff, yOff + 120, 100, 20);
        txtClassID.setBounds(xOff+100, yOff + 120, 100, 20);
        this.add(lblClassID);
        this.add(txtClassID);
    }

    @Override
    protected void doRegister() throws SQLException, IOException, ApplicationException {
        String passwordHash = HashingTools.hash(this.txtPassword.getPassword());
        Student student = new Student(0,this.txtAcctName.getText(), this.txtName.getText(), this.txtSurname.getText(), passwordHash, this.txtClassID.getText());
        studentDao.insert(student);
    }
}
