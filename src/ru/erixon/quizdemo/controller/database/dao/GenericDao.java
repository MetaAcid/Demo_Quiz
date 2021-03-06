package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.utils.ImageTools;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;

import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<T> {
    private final Connection connection;
    protected List<String> columns = new ArrayList<>();

    public GenericDao(Connection connection) {
        this.connection = connection;
    }

    protected abstract T newEntity(ResultSet rs) throws ApplicationException;

    protected abstract String getTableName();

    protected abstract Object[] getParams(T t);

    protected final String getTableFullName() {
        return Application.config.getSchema() + "." + getTableName();
    }

    public final long insert(T t) throws ApplicationException {
        String sqlInsert = insertSql();

        Object[] params = getParams(t);
        ResultSet rs = executeUpdate(sqlInsert, params);

        try {
            return rs.getLong("id");
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }

    protected ResultSet executeSelect(String sql, Object... params) throws ApplicationException {
        try {
            PreparedStatement ps = prepare(sql, params);
            if (ps.execute()) {

                ResultSet rs = ps.getResultSet();
                return rs;
            }
        } catch (SQLException | IOException e) {
            throw new ApplicationException(e);
        }

        throw new ApplicationException("sql execution error");
    }

    protected ResultSet executeUpdate(String sql, Object... params) throws ApplicationException {
        try {
            PreparedStatement ps = prepare(sql, true, params);
            int rows = ps.executeUpdate();
            System.out.println(String.format("changed %d rows", rows));
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next())
                return rs;
        } catch (SQLException | IOException e) {
            throw new ApplicationException(e);
        }

        throw new ApplicationException("SqlError");
    }

    private PreparedStatement prepare(String sql, Object... params) throws SQLException, IOException {
        return prepare(sql,false, params);
    }

    private PreparedStatement prepare(String sql, boolean update, Object... params) throws SQLException, IOException {
        System.out.println("SQL:debug: " + sql);
        PreparedStatement ps;
        if (update)
            ps = this.connection.prepareStatement(sql,new String[]{"id"});
        else
            ps = this.connection.prepareStatement(sql);

        parseInParams(ps, params);

        return ps;

    }

    private void parseInParams(PreparedStatement ps, Object[] params) throws SQLException, IOException {
        for (int i = 0; i < params.length; i++) {
            int pIndex = i + 1;
            if (params[i] instanceof String) {
                ps.setString(pIndex, (String) params[i]);
            }
            else if (params[i] instanceof Number) {
                ps.setDouble(pIndex, ((Number) params[i]).doubleValue());
            }
            else if (params[i] instanceof BufferedImage) {
                BufferedImage image = (BufferedImage) params[i];
                ps.setBinaryStream(pIndex, ImageTools.imageToInputStream(image));
            }
            else if (params[i] instanceof LocalDate) {
                LocalDate date = (LocalDate) params[i];
                ps.setDate(pIndex, Date.valueOf(date));
            }
            else if (params[i] instanceof LocalDateTime) {
                LocalDateTime localDateTime = (LocalDateTime) params[i];
                ps.setTimestamp(pIndex, Timestamp.valueOf(localDateTime));
            } else {
                throw new RuntimeException("wrong parameterType " + params[i].getClass().getName());
            }
        }
    }

    protected String insertSql() {
        StringBuilder params = new StringBuilder();
        boolean first = true;
        for (String s : columns) {
            if (!first) {
                params.append(',');
            }
            params.append('?');
            first = false;
        }
        StringBuilder sb = new StringBuilder();
        return String.format("insert into %s (%s) values (%s);"
                , getTableFullName(), getColumnList(), params.toString());
    }

    protected String getColumnList() {
        return String.join(",", columns);
    }

    public T findById(long id) throws ApplicationException {
        String sql = String.format("select %s from %s where id = ?", getColumnList(), getTableFullName());
        ResultSet rs = executeSelect(sql, id);
        return newEntity(rs);
    }
}
