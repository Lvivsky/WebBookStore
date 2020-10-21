package com.bookstore.dao;

import com.bookstore.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers() throws SQLException;

    User getUser(int id) throws SQLException;
    User getUser(String email) throws SQLException;

    void add(User user) throws SQLException;

    boolean remove(int id) throws SQLException;

    boolean isExist(int id) throws SQLException;
    boolean isExist(String email) throws SQLException;

}
