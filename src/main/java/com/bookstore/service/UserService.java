package com.bookstore.service;

import com.bookstore.exception.AlreadyExistException;
import com.bookstore.exception.NotFoundException;
import com.bookstore.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<User> getAll() throws SQLException;

    User getUser(int id) throws SQLException, NotFoundException;
    User getUser(String email) throws SQLException, NotFoundException;

    void create(User user) throws AlreadyExistException, SQLException;

    void remove(int id) throws NotFoundException, SQLException;

}
