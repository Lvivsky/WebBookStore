package com.bookstore.service.impl;

import com.bookstore.dao.BucketDao;
import com.bookstore.dao.impl.BucketDaoImpl;
import com.bookstore.model.Bucket;
import com.bookstore.service.BucketService;

import java.sql.SQLException;

public class BucketServiceImpl implements BucketService {

    private BucketDao bucketDao;

    public BucketServiceImpl(BucketDaoImpl bucketDao) {
        this.bucketDao = bucketDao;
    }

    @Override
    public Bucket getBucket(int id) throws SQLException {
        return bucketDao.getBucket(id);
    }
}
