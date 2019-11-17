package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.StudentDao;
import ru.erixon.quizdemo.controller.utils.HashingTools;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.user.Student;
import ru.erixon.quizdemo.view.frames.StudentFrame;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class StudentPanel extends LogInPanel<Student> implements ActionListener {
    private StudentDao studentDao = new StudentDao(Application.manager.getConnection());

    public StudentPanel() {}

    @Override
    protected Student checkLogin() throws SQLException, IOException, ApplicationException {
        String passwordHash = HashingTools.hash(this.txtPassword.getPassword());
        return studentDao.getByLogin(this.txtAcctName.getText(), passwordHash);
    }

    @Override
    protected void doLogin(Student student) {
        StudentFrame frame = new StudentFrame(null, "Student Window", student);
    }

}
