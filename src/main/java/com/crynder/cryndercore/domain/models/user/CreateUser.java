package com.crynder.cryndercore.domain.models.user;

public class CreateUser {

    private final String email;
    private final String name;
    private final String surname;
    private final String password;

    public CreateUser(String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
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
