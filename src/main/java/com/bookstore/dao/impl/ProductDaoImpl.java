package com.bookstore.dao.impl;

import com.bookstore.dao.ProductDao;
import com.bookstore.db.MySqlConnector;
import com.bookstore.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = MySqlConnector.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select * from product")
                ) {
            while(resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("picture"),
                        resultSet.getInt("bucket_id")
                ));
            }
            return products;
        }
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        Product product = null;
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "select * from product where id = ?")
                ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("picture"),
                        resultSet.getInt("bucket_id")
                );
            }
            return product;
        }
    }

    @Override
    public void create(Product product) throws SQLException {
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "insert into product(name,description,price,picture) values (?,?,?,?)")
                ) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getPicture());
            statement.execute();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "delete from product where id = ?")
                ) {
            statement.setInt(1, id);
            statement.execute();
        }
    }

    @Override
    public void update(int id, Product current) throws SQLException {
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "update product set name = ?, description = ?, price = ?, bucket_id = ? where id = ?")
                ) {
            statement.setString(1, current.getName());
            statement.setString(2, current.getDescription());
            statement.setDouble(3, current.getPrice());
            statement.setInt(4, current.getBucketId());
            statement.setInt(5, id);
            statement.execute();
        }
    }

    @Override
    public boolean exists(int id) throws SQLException {
        ResultSet resultSet = null;
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "select 1 from product where id = ?")
                ) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } finally {
            if (resultSet != null)
                resultSet.close();
        }
    }
}
