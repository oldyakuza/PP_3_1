package com.redqueen.pp31.service;

import com.redqueen.pp31.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    User getUser(long id);
    void deleteUser(long id);
}
