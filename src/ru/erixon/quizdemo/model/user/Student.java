package ru.erixon.quizdemo.model.user;

public class Student extends User {
    private String classId;

    public Student(long id, String accountName, String name, String surname, String passwordHash, String classId) {
        super(id, accountName, name, surname, passwordHash);
        this.classId = classId;
    }
}
