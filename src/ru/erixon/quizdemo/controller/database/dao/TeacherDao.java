package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.user.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TeacherDao extends UserDao<Teacher> {

    public TeacherDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return "teachers";
    }

    @Override
    protected Object[] getParams(Teacher teacher) {
        return new Object[]{teacher.getAccountName(), teacher.getPasswordHash(), teacher.getName(), teacher.getSurname()};
    }


    @Override
    protected Teacher newEntity(ResultSet rs)  throws ApplicationException {
        try {
            return new Teacher(rs.getLong("id"),rs.getString("account_name"), rs.getString("name"), rs.getString("surname"), rs.getString("password_hash"));
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }
}
