package ru.erixon.quizdemo.model.results;

import ru.erixon.quizdemo.model.user.Student;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;

public class TestResult {
    private Student student;
    private LocalDateTime date;
    private Map<Long, Boolean> resultTable;
    private String id;
    private Date test_date;
    private String difficulty;
    private boolean verdict;

    public TestResult(Student student, LocalDateTime date, Map<Long, Boolean> resultTable) {
        this.student = student;
        this.date = date;
        this.resultTable = resultTable;
    }

    public TestResult(String id, Date test_date, String difficulty, boolean verdict) {
        this.id = id;
        this.test_date = test_date;
        this.difficulty = difficulty;
        this.verdict = verdict;
    }

    public  String getId() {return id;}

    public Date getTest_date() {return test_date;}

    public  String getDifficulty() {return difficulty;}

    public boolean getVerdict() {return verdict;}

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
