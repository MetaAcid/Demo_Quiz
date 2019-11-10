package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.TeacherDao;
import ru.erixon.quizdemo.controller.utils.HashingTools;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.user.Teacher;

import java.io.IOException;
import java.sql.SQLException;

public class TeacherRegisterFromPanel extends RegisterFormPanel {

    private TeacherDao teacherDao = new TeacherDao(Application.manager.getConnection());

    public TeacherRegisterFromPanel() {}

    @Override
    protected void doRegister() throws ApplicationException, SQLException, IOException {
        String passwordHash = HashingTools.hash(this.txtPassword.getPassword());
        long teacherId = teacherDao.insert(new Teacher(0, txtAcctName.getText(), txtName.getText(), txtSurname.getText(), passwordHash));
        System.out.println(String.format("created new teacher with id %d", teacherId));
    }
}
