package com.epam.web.entity;


import java.io.Serializable;

public class User implements Identifiable {
    //table name for users
    public static final String TABLE = "users";

    //columns for table
    public static final String USER_ID = "user_id";
    public static final String FIRSTNAME = "firstname";
    public static final String SURNAME = "surname";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";
    public static final String STATUS = "status";

    @Override
    public Serializable getId() {
        return user_id;
    }


    public enum Role {
        ADMIN, READER, LIBRARIAN;
    }

    public enum Status {
        ENABLE, BLOCKED;
    }

    private int user_id;
    private String login;
    private String password;
    private String firstname;
    private String surname;
    private Role role;
    private Status status;

    public User() {
    }

    public User(int user_id, String login, String password, String firstname, String surname, Role role, Status status) {
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.role = role;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
