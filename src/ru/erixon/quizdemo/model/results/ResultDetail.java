package ru.erixon.quizdemo.model.results;

import ru.erixon.quizdemo.model.question.Question;
import ru.erixon.quizdemo.model.user.Student;

public class ResultDetail {
    private long id;
    private Question question;
    private boolean verdict;

    public ResultDetail(long id, Question question, boolean verdict) {
        this.id = id;
        this.question = question;
        this.verdict = verdict;
    }

    public long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isVerdict() {
        return verdict;
    }
}
