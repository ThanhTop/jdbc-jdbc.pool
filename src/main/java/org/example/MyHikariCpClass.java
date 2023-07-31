/*
 * MyHikariCpClass.java
 *
 * Copyright (c) 2023 Chip One Stop, Inc. All right reserved.
 * This software is the confidential and proprietary information of Chip One Stop, Inc.
 *
 */
package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 * MyHikariCpClass
 *
 * @author GM
 */
public class MyHikariCpClass {

    public static void main(String[] args) throws SQLException {
        DataSource dataSource = createDataSource();
        try (Connection conn = dataSource.getConnection()) {
            boolean isConnectionDatabaseSuccess = conn.isValid(0);
            System.out.println("Do you have a valid db connection? =" + isConnectionDatabaseSuccess);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from student");
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }

    private static DataSource createDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost/photo_app?serverTimezone=UTC");
        ds.setUsername("sergey");
        ds.setPassword("sergey");
        return ds;
    }
}