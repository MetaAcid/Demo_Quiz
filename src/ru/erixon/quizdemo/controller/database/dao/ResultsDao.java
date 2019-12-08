package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.results.TestResult;
import ru.erixon.quizdemo.model.user.Student;

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
    protected TestResult newEntity(ResultSet rs) throws SQLException, ApplicationException {
        return new TestResult (rs.getString("id"), rs.getDate("test_date"), rs.getString("difficulty"), rs.getBoolean("verdict"));
    }

    @Override
    protected String getTableName() {
        return "test_results";
    }

    @Override
    protected Object[] getParams(TestResult testResult) {
        return new Object[]{testResult.getStudent().getId(), testResult.getDate()};
    }


    protected Object[] getStat(String date, boolean verdict, String difficulty, long testNum) throws SQLException, IOException, ApplicationException {
        String sql = " select test_date from test_results;\n" +
                "select verdict from test_results_details;\n" +
                "select difficulty from questions;\n" +
                "select test_results_id from test_results_details;";
        ResultSet rs = executeSelect(sql, date, verdict, difficulty, testNum);
        return new Object[] {rs};
    }

}
