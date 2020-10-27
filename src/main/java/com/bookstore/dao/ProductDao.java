package com.bookstore.dao;

import com.bookstore.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    List<Product> getAll() throws SQLException;

    Product getProduct(int id) throws SQLException;

    void create(Product product) throws SQLException;
    void delete(int id) throws SQLException;
    void update(int id, Product current) throws SQLException;

    boolean exists(int id) throws SQLException;
}
