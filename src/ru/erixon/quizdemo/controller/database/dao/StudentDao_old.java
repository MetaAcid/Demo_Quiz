package ru.erixon.quizdemo.controller.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.erixon.quizdemo.utils.Assert.assertNotEmpty;
@Deprecated
public class StudentDao_old {
    private Connection connection;

    public StudentDao_old(Connection connection) {
        this.connection = connection;
    }

    public void registerNew(String acctName, String passwordHash, String name, String surname, String classId) throws SQLException {
        assertNotEmpty(acctName, "account name");
        assertNotEmpty(passwordHash, "password");
        assertNotEmpty(name, "name");
        assertNotEmpty(surname, "surname");
        assertNotEmpty(classId, "classId");

        String sql = String.format(
                "insert into students (account_name, name, surname, password_hash, class_id)" +
                "values (\'%s\', \'%s\', \'%s\', \'%s\', \'%s\');"
                ,acctName, name, surname, passwordHash, classId);

        if (!existsAcctName(acctName)){
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.execute();
        }
        else {
            throw new RuntimeException("This account already exists");
        }

    }

    public boolean existsAcctName(String acctName) throws SQLException {
        String sql = "select * from students " +
                "where account_name = \'" + acctName + "\'";

        PreparedStatement ps = connection.prepareStatement(sql);

        if (ps.execute()) {
            ResultSet rs = ps.getResultSet();

            return rs.getFetchSize() > 0;
        }

        throw new RuntimeException("something has gone wrong");
    }
}
