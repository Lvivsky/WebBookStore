package com.bookstore.service;

import com.bookstore.model.Bucket;

import java.sql.SQLException;

public interface BucketService {

    Bucket getBucket(int id) throws SQLException;

}
