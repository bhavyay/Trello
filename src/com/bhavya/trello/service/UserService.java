package com.bhavya.trello.service;

import com.bhavya.trello.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() { }

    public User findOrcreateUser(String name, String email)
    {
        Optional<User> existingUser = getUser(email);
        if (existingUser.isEmpty())
        {
            User user = new User(name, email);
            users.add(user);
            return user;
        }
        return existingUser.get();
    }

    public User findUser(String email)
    {
        return getUser(email).get();
    }

    private Optional<User> getUser(String email)
    {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
}
