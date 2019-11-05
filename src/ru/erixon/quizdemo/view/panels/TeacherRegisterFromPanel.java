package ru.erixon.quizdemo.view.panels;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.control.database.dao.TeacherDao;

import javax.swing.*;
import java.sql.SQLException;

public class TeacherRegisterFromPanel extends RegisterFormPanel {

    private TeacherDao teacherDao = new TeacherDao(Application.manager.getConnection());
    private String txtClassID = "0";

    public TeacherRegisterFromPanel() {

    }
    @Override
    protected void doRegister() throws SQLException {
        teacherDao.registerNew(this.txtAcctName.getText(), this.txtPassword.getText(), this.txtName.getText(), this.txtSurname.getText(), this.txtClassID);
        System.out.println("New Teacher!");
    }
}
