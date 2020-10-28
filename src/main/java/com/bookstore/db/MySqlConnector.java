package com.bookstore.db;

import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j
public class MySqlConnector {

    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/store?useUnicode=true"
            + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "password";
//    private static final String PASSWORD = "1qaz!QAZ";

    public static Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName(MYSQL_DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch ( ClassNotFoundException | SQLException e) {
            log.error(e.getMessage(), e);
            log.info("Database connection failed!");
        }
        return connection;
    }

}
