package ru.erixon.quizdemo.model.user;

public class Teacher extends User {

    public Teacher(long id, String accountName, String name, String surname, String passwordHash) {
        super(id, accountName, name, surname, passwordHash);
    }
}
