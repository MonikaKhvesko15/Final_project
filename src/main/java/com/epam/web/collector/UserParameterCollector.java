package com.epam.web.collector;

import com.epam.web.entity.User;


import java.util.ArrayList;


import java.util.List;


public class UserParameterCollector implements ParameterCollector<User>{
    @Override
    public List<Object> collect(User user) {
        List<Object> params =new ArrayList<>();
        int id = (int) user.getId();
        String login= user.getLogin();
        String firstname= user.getFirstname();
        String surname=user.getSurname();
        params.add(id);
        params.add(login);
        params.add(firstname);
        params.add(surname);
        return params;
    }
}
