package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.results.Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultsDao extends GenericDao<Result> {

    public ResultsDao(Connection connection) {
        super(connection);
    }

    @Override
    protected Result newEntity(ResultSet rs) throws ApplicationException {
        return null;
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected Object[] getParams(Result result) {
        return new Object[0];
    }
}
