package ru.erixon.quizdemo.model.results;

import ru.erixon.quizdemo.model.user.Student;

import java.time.LocalDateTime;
import java.util.Map;

public class TestResult {
    private Student student;
    private LocalDateTime date;
    private Map<Long, Boolean> resultTable;

    public TestResult(Student student, LocalDateTime date, Map<Long, Boolean> resultTable) {
        this.student = student;
        this.date = date;
        this.resultTable = resultTable;
    }

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
