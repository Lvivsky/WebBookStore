package com.bookstore.service.base;

import com.bookstore.dao.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(int id);

    void add(User user);
    void remove(int id);
    void update(int id, User user);



}
