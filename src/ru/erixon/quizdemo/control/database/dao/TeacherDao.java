package ru.erixon.quizdemo.control.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDao {
    private Connection connection;

    public TeacherDao(Connection connection) {this.connection = connection;}

    public void registerNew(String acctName, String passwordHash, String name, String surname, String classId) throws SQLException {
        assertNotEmpty(acctName, "account name");
        assertNotEmpty(passwordHash, "password");
        assertNotEmpty(name, "name");
        assertNotEmpty(surname, "surname");
        assertNotEmpty(classId, "classId");

        String sql = String.format(
                "insert into teachers (account_name, name, surname, password_hash)" +
                        "values (\'%s\', \'%s\', \'%s\', \'%s\', \'%s\');"
                ,acctName, name, surname, passwordHash, classId);

        String sqlClass_ID = String.format(
                "insert into class_id ()" +
                        "values (\'%s\');"
                ,classId);

        if (!existsAcctName(acctName)){
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.execute();
        }
        else {
            throw new RuntimeException("This account already exists");
        }

        if (!existsClassID(classId)){
            PreparedStatement ps = this.connection.prepareStatement(sqlClass_ID);
            ps.execute();
        }

    }

    public boolean existsAcctName(String acctName) throws SQLException {
        String sql = "select * from teachers " +
                "where account_name = \'" + acctName + "\'";

        PreparedStatement ps = connection.prepareStatement(sql);

        if (ps.execute()) {
            ResultSet rs = ps.getResultSet();

            return rs.getFetchSize() > 0;
        }

        throw new RuntimeException("something has gone wrong");
    }

    public boolean existsClassID(String classId) throws SQLException {
        String sqlClass_ID = "select * from Class_id " +
                "where class_id = \'" + classId + "\'";

        PreparedStatement ps = connection.prepareStatement(sqlClass_ID);

        if (ps.execute()) {
            ResultSet rs = ps.getResultSet();

            return rs.getFetchSize() > 0;
        }

        throw new RuntimeException("something has gone wrong");

    }


    private void assertNotEmpty(String s, String name) {
        if (s == null || s.length() == 0){
            throw new RuntimeException(name + " cannot be null or empty");
        }
    }
}
