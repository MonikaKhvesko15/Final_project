package com.epam.web.dao.extractor;

import com.epam.web.entity.Role;
import com.epam.web.entity.User;


import java.util.ArrayList;


import java.util.List;


public class UserFieldsExtractor implements FieldsExtractor<User> {
    @Override
    public List<Object> extract(User user) {
        List<Object> params = new ArrayList<>();
        String login = user.getLogin();
        String password = user.getPassword();
        String firstname = user.getFirstname();
        String surname = user.getSurname();
        Role userRole = user.getRole();
        String role = null;
        switch (userRole) {
            case READER:
                role = "READER";
                break;
            case LIBRARIAN:
                role = "LIBRARIAN";
                break;
        }

        params.add(login);
        params.add(password);
        params.add(firstname);
        params.add(surname);
        params.add(role);
        return params;
    }
}
