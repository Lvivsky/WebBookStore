package com.bookstore.service.impl;

import com.bookstore.dao.ProductDao;
import com.bookstore.dao.impl.ProductDaoImpl;
import com.bookstore.model.Product;
import com.bookstore.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public List<Product> getAll() throws SQLException {
        return null;
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        return null;
    }

    @Override
    public void add(Product product) throws SQLException {
        productDao.create(product);
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(int id, Product current) throws SQLException {

    }
}
