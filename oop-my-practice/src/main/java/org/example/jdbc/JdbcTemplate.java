package org.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplate {
    public void create(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement pst = null;

        try {
            connection = ConnectionManager.getConnection();
            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, user.getUserId());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getName());
            pst.setString(4, user.getEmail());

            pst.execute();
        } finally {
            if (pst != null)
                pst.close();
            if (connection != null)
                connection.close();
        }
    }
}
