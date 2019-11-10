package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.user.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao extends UserDao<Student> {

    {
        columns.add("class_id");
    }

    public StudentDao(Connection connection) {
        super(connection);
    }

    @Override
    public void createTable() {

    }

    @Override
    protected Student newEntity(ResultSet rs) throws SQLException, ApplicationException {
        return new Student(rs.getLong("id"),rs.getString("account_name"), rs.getString("name"), rs.getString("surname"), rs.getString("password_hash"), rs.getString("class_id"));
    }

    @Override
    protected String getTableName() {
        return "students";
    }

    @Override
    protected Object[] getParams(Student student) {
        return new Object[]{student.getAccountName(), student.getPasswordHash(), student.getName(), student.getSurname(), student.getClass()};
    }
}
