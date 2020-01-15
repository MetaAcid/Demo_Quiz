package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.question.Question;
import ru.erixon.quizdemo.model.results.ResultDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDetailsDao extends GenericDao<ResultDetail> {

    private QuestionDao questionDao;

    public ResultDetailsDao(Connection connection) {
        super(connection);
        questionDao = new QuestionDao(connection);
    }

    @Override
    protected ResultDetail newEntity(ResultSet rs) throws ApplicationException {
        try {
            Question question = questionDao.findById(rs.getLong("question_id"));
            return new ResultDetail(rs.getLong("id"), question, rs.getBoolean("verdict"));
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }

    @Override
    protected String getTableName() {
        return "test_results_details";
    }

    @Override
    protected Object[] getParams(ResultDetail resultDetail) {
        return new Object[0];
    }

    public List<ResultDetail> findResultDetailsByResultId(long id) {
        String sql = "select * from %s where test_results_id = ?;";
        ResultSet rs = executeSelect(sql, id);
        List<ResultDetail> resultDetails = new ArrayList<>();
        try {
            while (rs.next()) {
                resultDetails.add(newEntity(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultDetails;
    }
}
