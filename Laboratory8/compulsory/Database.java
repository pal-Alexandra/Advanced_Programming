package org.compulsory;

/**
 * @author Pal Alexandra
 * this class implements a singleton class in order to manage a connection to the database.
 */

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class Database {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String user = "PRAV";
    private static final String password = "PRAV";

    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    /**
     * this method creates a connection to an Oracle database
     */
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.err.println("Cannot connect to DB: " + ex);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
