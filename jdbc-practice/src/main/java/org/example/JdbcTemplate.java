package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
    public void executeUpdate(User user, String sql, PreparedStatementSetter pss) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            pss.setter(preparedStatement);

            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
    }

    public Object executeQuery(String sql, PreparedStatementSetter pss, RowMapper rm) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getConnection();
            //String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
            preparedStatement = connection.prepareStatement(sql);
            pss.setter(preparedStatement);

            resultSet = preparedStatement.executeQuery();

            Object obj = null;
            if (resultSet.next()) {
                return rm.map(resultSet);
            }
            return obj;
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
    }
}
