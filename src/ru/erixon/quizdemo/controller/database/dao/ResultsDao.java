package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.results.Result;
import ru.erixon.quizdemo.model.results.ResultDetail;
import ru.erixon.quizdemo.model.user.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ResultsDao extends GenericDao<Result> {

    private ResultDetailsDao resultDetailsDao;
    private StudentDao studentDao;

    public ResultsDao(Connection connection) {
        super(connection);
        resultDetailsDao = new ResultDetailsDao(connection);
        studentDao = new StudentDao(connection);
    }

    @Override
    protected Result newEntity(ResultSet rs) throws ApplicationException {
        try {
            long id = rs.getLong("id");
            List<ResultDetail> resultDetails = resultDetailsDao.findResultDetailsByResultId(id);
            Student student = studentDao.findById(rs.getLong("student_id"));
            return new Result(id, student, rs.getTimestamp("date").toLocalDateTime(), resultDetails);
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }

    @Override
    protected String getTableName() {
        return "test_results";
    }

    @Override
    protected Object[] getParams(Result result) {
        return new Object[0];
    }
}
