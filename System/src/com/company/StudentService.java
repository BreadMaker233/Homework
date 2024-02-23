package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {
    public static Connection connection;
    public static PreparedStatement preparedStatement;

    public static int search(String stuId, String courseId) {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select score from scores where stuId=? and courseId=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, stuId);
            preparedStatement.setString(2, courseId);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                return res.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
