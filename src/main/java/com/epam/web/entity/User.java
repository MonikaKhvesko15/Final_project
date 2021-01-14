package com.epam.web.entity;


import java.io.Serializable;

public class User implements Identifiable, Cloneable {
    //table name for users
    public static final String TABLE = "users";

    //columns for table
    public static final String ID = "id";
    public static final String FIRSTNAME = "firstname";
    public static final String SURNAME = "surname";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";
    public static final String STATUS = "isBlocked";

    @Override
    public Serializable getId() {
        return id;
    }

    private Integer id;
    private String login;
    private String password;
    private String firstname;
    private String surname;
    private Role role;
    private boolean isBlocked;

    public User() {
    }

    public User(Integer id, String login, String password, String firstname, String surname, Role role, boolean isBlocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.role = role;
        this.isBlocked = isBlocked;
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

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setStatus(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
