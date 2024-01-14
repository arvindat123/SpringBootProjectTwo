package com.learning.technology.service;

import com.learning.technology.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    List<User> getUsers();

    List<User> getUserByAddress(String address);

    void deleteUser(User user);
}
