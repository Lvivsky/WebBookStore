package com.bookstore.dao.impl;

import com.bookstore.dao.BucketDao;
import com.bookstore.db.MySqlConnector;
import com.bookstore.model.Bucket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BucketDaoImpl implements BucketDao {


    @Override
    public Bucket getBucket(int id) throws SQLException {
        Bucket bucket = null;
        try (
                Connection connection = MySqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "select * from bucket where id = ?")
        ) {
             statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bucket = new Bucket(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("purchase_date")
                );
            }
        }
        return bucket;
    }
}
