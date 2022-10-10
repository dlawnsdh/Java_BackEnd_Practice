package org.example.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementSetter {
    void setter(PreparedStatement pst) throws SQLException;
}
