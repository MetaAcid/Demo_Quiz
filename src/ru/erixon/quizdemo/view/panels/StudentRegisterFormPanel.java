package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.control.database.dao.StudentDao;

import javax.swing.*;
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
    protected void doRegister() throws SQLException {
        studentDao.registerNew(this.txtAcctName.getText(), this.txtPassword.getText(), this.txtName.getText(),this.txtSurname.getText(), this.txtClassID.getText());
        System.out.println("new student!");
    }
}
