package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.user.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends UserDao<Student> {

    {
        columns.add("class_id");
    }

    public StudentDao(Connection connection) {
        super(connection);
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
        return new Object[]{student.getAccountName(), student.getPasswordHash(), student.getName(), student.getSurname(), student.getClassId()};
    }

    public List<String> getClassList() throws SQLException, IOException, ApplicationException {
        String sql = String.format("select distinct class_id from %s;", getTableFullName());
        ResultSet rs = executeSelect(sql);
        List<String> classList = new ArrayList<>();
        while (rs.next()) {
            classList.add(rs.getString(1));
        }
        return classList;
    }

    public List<Student> getStudentsByClass(String classId) throws SQLException, IOException, ApplicationException {
        String sql = String.format("select * from %s where class_id = ?;", getTableFullName());
        ResultSet rs = executeSelect(sql, classId);
        List<Student> studentList = new ArrayList<>();
        while (rs.next()) {
            studentList.add(newEntity(rs));
        }
        return studentList;
    }
}
