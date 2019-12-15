package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.results.TestResult;
import ru.erixon.quizdemo.model.user.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class ResultsDao_old extends GenericDao<TestResult> {

    {
        columns.add("student_id");
        columns.add("test_date");
    }
    public ResultsDao_old(Connection connection) {
        super(connection);
    }

    public void insertResult(TestResult testResult) {
        long id = this.insert(testResult);

        for (Map.Entry<Long, Boolean> entry : testResult.getResultTable().entrySet()) {
            String sql = "insert into test_results_details (test_results_id, questions_id, verdict)" +
                    " values (?,?,?);";
            this.executeUpdate(sql, id, entry.getKey(), entry.getValue()?1:0);
        }
    }

    @Override
    protected TestResult newEntity(ResultSet rs) throws ApplicationException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getTableName() {
        return "test_results";
    }

    @Override
    protected Object[] getParams(TestResult testResult) {
        return new Object[]{testResult.getStudent().getId(), testResult.getDate()};
    }


//  todo watch and delete this!
//   public Object[] getStat(TestResult testResult) throws SQLException, IOException, ApplicationException {
//        String sql = " select test_date from test_results;\n" +
//                "select verdict from test_results_details;\n" +
//                "select difficulty from questions;\n" +
//                "select test_results_id from test_results_details;";
//        ResultSet rs = executeSelect(sql, testResult.getTest_date(), testResult.getVerdict(), testResult.getDifficulty(), testResult.getId());
//        return new Object[] {rs};
//    }


    public List<TestResult> getStudentStatistics(Student student) {
        String resultsSql = "select * from %s t where t.student_id = ?";

        String detailsSql = "select * from %s where t.test_results_id = ?";

        List<TestResult> testResults = new ArrayList<>();

        ResultSet rs = executeSelect(resultsSql, student.getId());

        try {
            if (rs.next()) {
                do {
                    Map<Long, Boolean> resultMap = new HashMap<>();
                    long test_result_id = rs.getLong("test_result_id");
                    ResultSet detailsRs = executeSelect(detailsSql, test_result_id);
                    if (detailsRs.next()) {
                        do {
                            resultMap.put(detailsRs.getLong("question_id"), detailsRs.getLong("verdict") == 1);
                        } while (detailsRs.next());
                    }

                    testResults.add(new TestResult(test_result_id, student, rs.getTimestamp(/*todo fix column name*/"date").toLocalDateTime(), resultMap));
                } while (rs.next());
            }
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }

        return testResults;

    }
}
