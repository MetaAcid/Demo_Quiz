package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.user.Student;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentDao extends UserDao<Student> {

    public StudentDao(Connection connection) {
        super(connection);
    }

    @Override
    public void createTable() {

    }

    @Override
    public Student getById(long id) throws SQLException {
        return null;
    }

    @Override
    protected String getTableName() {
        return "students";
    }
}
