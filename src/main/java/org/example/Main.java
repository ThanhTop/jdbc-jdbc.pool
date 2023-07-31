package org.example;/*
 * ${NAME}.java
 *
 * Copyright (c) ${YEAR} Chip One Stop, Inc. All right reserved.
 * This software is the confidential and proprietary information of Chip One Stop, Inc.
 *
 */

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager
            .getConnection("jdbc:mysql://localhost/photo_app?serverTimezone=UTC",
                      "sergey", "sergey")) {
            boolean isValidConnectDatabase = conn.isValid(0);
            System.out.println("Do we have a valid db connection? = " + isValidConnectDatabase);
            Statement statement = conn.createStatement();
            //if you have param in sql. create prepareStatement
            ResultSet resultSet = statement.executeQuery("select * from student");
            while(resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        }
    }
}