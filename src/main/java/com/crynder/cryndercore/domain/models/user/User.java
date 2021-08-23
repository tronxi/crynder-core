package com.crynder.cryndercore.domain.models.user;

public class User {
    private final String id;
    private final String email;
    private final String name;
    private final String surname;
    private final String password;

    public User(String id, String email, String name, String surname, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }
}
