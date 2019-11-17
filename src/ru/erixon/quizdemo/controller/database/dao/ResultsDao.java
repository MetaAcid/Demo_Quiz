package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.results.TestResult;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ResultsDao extends GenericDao<TestResult> {

    {
        columns.add("student_id");
        columns.add("test_date");
    }
    public ResultsDao(Connection connection) {
        super(connection);
    }

    public void insertResult(TestResult testResult) throws SQLException, IOException, ApplicationException {
        long id = this.insert(testResult);

        for (Map.Entry<Long, Boolean> entry : testResult.getResultTable().entrySet()) {
            String sql = "insert into test_results_details (test_results_id, questions_id, verdict)" +
                    " values (?,?,?);";
            this.executeUpdate(sql, id, entry.getKey(), entry.getValue()?1:0);
        }
    }

    @Override
    public void createTable() {

    }

    @Override
    protected TestResult newEntity(ResultSet rs) throws SQLException, ApplicationException {
        return null;
    }

    @Override
    protected String getTableName() {
        return "test_results";
    }

    @Override
    protected Object[] getParams(TestResult testResult) {
        return new Object[]{testResult.getStudent().getId(), testResult.getDate()};
    }
}
