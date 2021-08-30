package com.crynder.cryndercore.infrastructure.persistence.entities;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private String id;

    @NotNull
    @Column(unique=true)
    private String email;

    @NotNull
    private String name;

    private String surname;

    @NotNull
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
