package com.bookstore.service.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.exception.AlreadyExistException;
import com.bookstore.exception.NotFoundException;
import com.bookstore.model.User;
import com.bookstore.service.UserService;
import lombok.extern.log4j.Log4j;

import java.sql.SQLException;
import java.util.List;

@Log4j
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() throws SQLException {
        log.info("Get all users");
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(int id) throws SQLException, NotFoundException {
        log.info("Get user by id " + id);
        User user = userDao.getUser(id);
        if (user == null)
            throw new NotFoundException("User with id " + id + " doesn`t exist!");
        return user;
    }

    @Override
    public User getUser(String email) throws SQLException, NotFoundException {
        log.info("Get user by email " + email);
        User user = userDao.getUser(email);
        if (user == null)
            throw new NotFoundException("User with email " + email + " doesn`t exist!");
        return user;
    }

    @Override
    public void create(User user) throws AlreadyExistException, SQLException {
        log.info("Create user " + user.toString());
        if (userDao.isExist(user.getEmail()))
            throw new AlreadyExistException("User with email " + user.getEmail() + " is already exist!");
        userDao.add(user);
    }

    @Override
    public void remove(int id) throws NotFoundException, SQLException {
        log.info("Remove user with id " + id);
        if (!userDao.remove(id))
        {
            throw new NotFoundException("User with id " + id + " doesn't exist.");
        }
    }
}
