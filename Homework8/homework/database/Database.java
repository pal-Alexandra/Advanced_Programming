package org.homework.database;
/**
 * @author Pal Alexandra
 * This class allows to connect to a relational database (Oracle)
 * This class usees a connection pool in order to manage database connections, such as HikariCP
 */

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;

import java.sql.Connection;
import java.sql.SQLException;

@Data
public class Database {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String user = "PRAV";
    private static final String password = "PRAV";

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource hikariDataSource;

    static {
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        hikariDataSource = new HikariDataSource(config);
    }

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
     * This method creates a connection to an Oracle database
     */
    private static void createConnection() {
        try {
            connection = hikariDataSource.getConnection();

        } catch (SQLException ex) {
            System.err.println("Cannot connect to DB: " + ex);
        }
    }


}
