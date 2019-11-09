package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.TeacherDao;
import ru.erixon.quizdemo.controller.utils.HashingTools;

import java.sql.SQLException;

public class TeacherRegisterFromPanel extends RegisterFormPanel {

    private TeacherDao teacherDao = new TeacherDao(Application.manager.getConnection());

    public TeacherRegisterFromPanel() {}

    @Override
    protected void doRegister() throws SQLException {
        String passwordHash = HashingTools.hash(this.txtPassword.getPassword());
        teacherDao.registerNew(this.txtAcctName.getText(), passwordHash, this.txtName.getText(), this.txtSurname.getText());
    }
}
