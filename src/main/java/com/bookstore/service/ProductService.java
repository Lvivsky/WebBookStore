package com.bookstore.service;

import com.bookstore.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    List<Product> getAll() throws SQLException;

    Product getProduct(int id) throws SQLException;

    void add(Product product) throws SQLException;
    void delete(int id) throws SQLException;
    void update(int id, Product current) throws SQLException;

}
