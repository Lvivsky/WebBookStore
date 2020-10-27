package com.bookstore.dao.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.db.MySqlConnector;
import com.bookstore.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getAllUsers() throws SQLException {
        try (
                Connection connection = MySqlConnector.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user")
            ) {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("picture"),
                        resultSet.getString("role")
                ));
            }
            return users;
        }
    }

    @Override
    public User getUser(int id) throws SQLException {
        User user = null;
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM user where id = ?")
            ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("picture"),
                        resultSet.getString("role")
                );
            }
        }
        return user;
    }

    @Override
    public User getUser(String email) throws SQLException {
        User user = null;
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM user where email = ?")
            ) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("picture"),
                        resultSet.getString("role")
                );
            }
        }
        return user;
    }

    @Override
    public void add(User user) throws SQLException {
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "insert into user(email,password,first_name,last_name,picture,role) values (?,?,?,?,?,?)")
            ) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getPicture());
            statement.setString(6, user.getRole());
            statement.execute();
        }
    }

    @Override
    public boolean remove(int id) throws SQLException {
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "delete from user where id = ?")
                ) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean isExist(int id) throws SQLException {
        ResultSet resultSet = null;
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "seelct 1 from user where id = ?")
                ) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } finally {
            if (resultSet != null)
                resultSet.close();
        }
    }

    @Override
    public boolean isExist(String email) throws SQLException {
        ResultSet resultSet = null;
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "seelct 1 from user where email = ?")
        ) {
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } finally {
            if (resultSet != null)
                resultSet.close();
        }
    }
}
