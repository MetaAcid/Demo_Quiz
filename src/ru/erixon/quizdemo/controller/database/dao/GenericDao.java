package ru.erixon.quizdemo.controller.database.dao;


import ru.erixon.quizdemo.Application;

import java.sql.*;

public abstract class GenericDao<T> {
    private final Connection connection;

    public GenericDao(Connection connection) {
        this.connection = connection;
    }

    public abstract void createTable();
    public abstract long createNew(T t) throws SQLException;
    public abstract boolean checkIfExists(T t);
    public abstract T getById(long id) throws SQLException;
    protected abstract String getTableName();

    protected final String getTableFullName() {
        return Application.config.getSchema() + "." + getTableName();
    }

    protected ResultSet executeSelect(String sql, Object[] params) throws SQLException {
        PreparedStatement ps = prepare(sql, params);
        if (ps.execute()){
            return ps.getResultSet();
        }

        throw new RuntimeException("sql execution error");
    }


    protected int executedUpdate(String sql, Object[] params) throws SQLException {
        return prepare(sql, params).executeUpdate();
    }

    private PreparedStatement prepare(String sql, Object[] params) throws SQLException {
        System.out.println("SQL:debug: " + sql);
        PreparedStatement ps = this.connection.prepareStatement(sql);
        parseInParams(ps, params);

        return ps;
    }

    private void parseInParams(PreparedStatement ps, Object[] params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            int pIndex = i+1;
            if (params[i] instanceof String) {
                ps.setString(pIndex, (String) params[i]);
            }
            else if (params[i] instanceof Number) {
                ps.setDouble(pIndex, ((Number) params[i]).doubleValue());
            }
            else {
                throw new RuntimeException("wrong parameterType " + params[i].getClass().getName());
            }
        }
    }

}
