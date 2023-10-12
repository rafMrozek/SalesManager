package org.rmproject;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/rmp");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private DatabaseManager() {}
}
