package com.epam.web.entity.dto;

import com.epam.web.entity.Identifiable;
import com.epam.web.entity.User;

import java.io.Serializable;

//This object now contains all the information we want to show to the end-user
public class UserDto implements Identifiable {
    @Override
    public Serializable getId() {
        return id;
    }

    private Integer id;
    private String login;
    private String firstname;
    private String surname;
    private User.Role role;
    private boolean isBlocked;

    public UserDto() {
    }

    public UserDto(Integer id, String login, String firstname, String surname, User.Role role, boolean isBlocked) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.surname = surname;
        this.role = role;
        this.isBlocked = isBlocked;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public User.Role getRole() {
        return role;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
