package org.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementSetter {
    void setter(PreparedStatement preparedStatement) throws SQLException;
}
