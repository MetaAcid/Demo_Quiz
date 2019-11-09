package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.model.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao<T extends User> extends GenericDao<T> {
    private String schema = Application.config.getSchema();

    public UserDao(Connection connection) {
        super(connection);
    }
    
    @Override
    public long createNew(T t) throws SQLException {
        String sqlInsert = 
                "insert into " + getTableFullName() + " (account_name, name, surname, password_hash) " +
                "values (?,?,?,?);";
        
        Object[] params = new Object[]{t.getAccountName(), t.getName(), t.getSurname(), t.getPasswordHash()};
        int rows = executedUpdate(sqlInsert, params);

        System.out.println(String.format("inserted %d rows", rows));

        String sqlSelect =
                "select id from " + getTableFullName() +
                " where account_name = ?";
        
        ResultSet rs2 = executeSelect(sqlSelect, new Object[]{t.getAccountName()});
        return rs2.getLong("id");
    }

    @Override
    public boolean checkIfExists(T t) {
        throw new UnsupportedOperationException();
    }

    
    protected ResultSet getRsById(long Id) throws SQLException {
        String sql =
                "select * from " + getTableFullName() +
                " where id = ?";
        return executeSelect(sql, new Object[]{Id});
    }
}
