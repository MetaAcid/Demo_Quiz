package ru.erixon.quizdemo.model.results;

import ru.erixon.quizdemo.model.user.Student;

import java.time.LocalDateTime;

public class Result {
    private long id;
    private Student student;
    private LocalDateTime when;

    public Result(long id, Student student, LocalDateTime when) {
        this.id = id;
        this.student = student;
        this.when = when;
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
}
