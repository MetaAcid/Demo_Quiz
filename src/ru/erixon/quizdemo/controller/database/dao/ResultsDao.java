package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.results.Result;
import ru.erixon.quizdemo.model.results.ResultDetail;
import ru.erixon.quizdemo.model.user.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public String[][] getStudentStatisticsData(Student student) {
        String sql = String.format(
                "select r.test_date, sum(case when d.verdict = 1 then 1 else 0 end) as score, count(1) as cnt\n" +
                "from %s r\n" +
                "join %s d on (d.test_result_id = r.id)\n" +
                "where r.student_id = ?\n" +
                "group by r.id, r.test_date\n", this.getTableFullName(), resultDetailsDao.getTableFullName());
        ResultSet rs = executeSelect(sql, student.getId());
        List<String[]> data = new ArrayList<>();
        try {
            while(rs.next()) {
                String[] row = new String[3];
                row[0] = rs.getString("test_date");
                row[1] = rs.getString("score");
                row[2] = rs.getString("cnt");
                data.add(row);
            }
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
        String[][] result = new String[data.size()][3];
        result = data.toArray(result);
        return result;
    }
}
