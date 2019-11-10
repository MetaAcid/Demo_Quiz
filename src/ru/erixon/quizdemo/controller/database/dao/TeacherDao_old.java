package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.erixon.quizdemo.utils.Assert.assertNotEmpty;

@Deprecated
public class TeacherDao_old {
    private Connection connection;

    public TeacherDao_old(Connection connection) {this.connection = connection;}

    public void registerNew(String acctName, String passwordHash, String name, String surname) throws SQLException, ApplicationException {
        assertNotEmpty(acctName, "account name");
        assertNotEmpty(passwordHash, "password");
        assertNotEmpty(name, "name");
        assertNotEmpty(surname, "surname");

        String sql = String.format(
                "insert into teachers (account_name, name, surname, password_hash)" +
                        "values (\'%s\', \'%s\', \'%s\', \'%s\');"
                ,acctName, name, surname, passwordHash);

        if (!existsAcctName(acctName)){
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.execute();
        }
        else {
            throw new RuntimeException("This account already exists");
        }
    }

    public boolean checkLogIn(String acctName, String passwordHash) throws SQLException {
        String sql = "select * from teachers " +
                "where account_name = \'" + acctName + "\' " +
                "and password_hash = \'" + passwordHash + "\'";

        PreparedStatement ps = connection.prepareStatement(sql);

        if (ps.execute()) {
            ResultSet rs = ps.getResultSet();

            return rs.getFetchSize() > 0;
        }

        throw new RuntimeException("something has gone wrong");
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
}
