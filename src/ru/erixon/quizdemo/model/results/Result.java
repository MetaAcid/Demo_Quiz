package ru.erixon.quizdemo.model.results;

import ru.erixon.quizdemo.model.user.Student;

import java.time.LocalDateTime;
import java.util.List;

public class Result {
    private long id;
    private Student student;
    private LocalDateTime when;
    private List<ResultDetail> resultDetails;

    public Result(long id, Student student, LocalDateTime when, List<ResultDetail> resultDetails) {
        this.id = id;
        this.student = student;
        this.when = when;
        this.resultDetails = resultDetails;
    }

    public long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public List<ResultDetail> getResultDetails() {
        return resultDetails;
    }
}
