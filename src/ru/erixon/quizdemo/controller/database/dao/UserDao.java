package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.user.User;
import ru.erixon.quizdemo.utils.Assert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao<T extends User> extends GenericDao<T> {

    {
        columns.add("account_name");
        columns.add("password_hash");
        columns.add("name");
        columns.add("surname");
    }

    public UserDao(Connection connection) {
        super(connection);
    }

    public T getByLogin(String acctName, String passwordHash) throws SQLException, ApplicationException, IOException {
        String sql = String.format("select null from %s where account_name = ? and password_hash = ?", getTableFullName());
        ResultSet rs = executeSelect(sql, acctName, passwordHash);
        return newEntity(rs);
    }

    public boolean checkIfAccountExists(String acctName) throws SQLException, ApplicationException, IOException {
        String sql = String.format("select count(1) as cnt from %s where account_name = ?", getTableFullName());
        ResultSet rs = executeSelect(sql, acctName);
        return rs.getLong("cnt") > 0;
    }

}
