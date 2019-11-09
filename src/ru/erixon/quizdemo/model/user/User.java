package ru.erixon.quizdemo.model.user;

public abstract class User {
    private long id;
    private String accountName;
    private String name;
    private String surname;
    private String passwordHash;

    public User(long id, String accountName, String name, String surname, String passwordHash) {
        this.id = id;
        this.accountName = accountName;
        this.name = name;
        this.surname = surname;
        this.passwordHash = passwordHash;
    }

    public long getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
