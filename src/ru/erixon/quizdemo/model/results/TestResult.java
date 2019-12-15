package ru.erixon.quizdemo.model.results;

import ru.erixon.quizdemo.model.user.Student;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;

@Deprecated
public class TestResult {
    private long id;
    private Student student;
    private LocalDateTime date;
    private Map<Long, Boolean> resultTable;

    public TestResult(long id, Student student, LocalDateTime date, Map<Long, Boolean> resultTable) {
        this.id = id;
        this.student = student;
        this.date = date;
        this.resultTable = resultTable;
    }

    public long getId() {return id;}

    public Student getStudent() {
        return student;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Map<Long, Boolean> getResultTable() {
        return resultTable;
    }
}
