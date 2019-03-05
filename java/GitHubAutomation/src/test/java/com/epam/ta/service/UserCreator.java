package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {

    public static final String USER_NAME = "test-automation-user";
    public static final String USER_PASSWORD = "Time4Death!";

    public static User withCredentialsFromProperty(){
        return new User(USER_NAME,
                USER_PASSWORD);
    }

    public static User withEmptyUsername(){
        return new User("", USER_PASSWORD);
    }

    public static User withEmptyPassword(){
        return new User(USER_NAME, "");
    }
}
