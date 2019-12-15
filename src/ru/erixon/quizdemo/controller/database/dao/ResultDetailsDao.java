package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.question.Question;
import ru.erixon.quizdemo.model.results.Result;
import ru.erixon.quizdemo.model.results.ResultDetail;
import ru.erixon.quizdemo.model.user.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDetailsDao extends GenericDao<ResultDetail> {

    private ResultsDao resultsDao;
    private QuestionDao questionDao;

    public ResultDetailsDao(Connection connection) {
        super(connection);
        resultsDao = new ResultsDao(connection);
        questionDao = new QuestionDao(connection);
    }

    @Override
    protected ResultDetail newEntity(ResultSet rs) throws ApplicationException {
        try {
            Question question = questionDao.getById(rs.getLong("question_id"));
            Result result = resultsDao.getById(rs.getLong("test_result_id"));
            return new ResultDetail(rs.getLong("id"), result, question, rs.getBoolean("verdict"));
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected Object[] getParams(ResultDetail resultDetail) {
        return new Object[0];
    }
}
