package com.company;


import java.sql.*;

public class JDBCUtils {

    public static final String URL = "jdbc:mysql://localhost:3306/studentscore";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static final String driver = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
