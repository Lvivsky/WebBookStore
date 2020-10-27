package com.bookstore.dao;

import com.bookstore.model.Bucket;

import java.sql.SQLException;

public interface BucketDao {

    Bucket getBucket(int id) throws SQLException;

}
