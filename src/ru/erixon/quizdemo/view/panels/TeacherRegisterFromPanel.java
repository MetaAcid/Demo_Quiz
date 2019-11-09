package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.TeacherDao;
import ru.erixon.quizdemo.controller.database.dao.TeacherDao_old;
import ru.erixon.quizdemo.controller.utils.HashingTools;
import ru.erixon.quizdemo.model.user.Teacher;

import java.sql.SQLException;

public class TeacherRegisterFromPanel extends RegisterFormPanel {

    private TeacherDao teacherDao = new TeacherDao(Application.manager.getConnection());

    public TeacherRegisterFromPanel() {}

    @Override
    protected void doRegister() throws SQLException {
        String passwordHash = HashingTools.hash(this.txtPassword.getPassword());
        long teacherId = teacherDao.createNew(new Teacher(0, txtAcctName.getText(), txtName.getText(), txtSurname.getText(), passwordHash));
        System.out.println(String.format("created new teacher with id %d", teacherId));
    }
}
