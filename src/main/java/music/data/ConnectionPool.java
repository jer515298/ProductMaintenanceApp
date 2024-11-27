package music.data;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * The ConnectionPool class is a singleton utility class that manages a pool of database connections.
 * It provides a way to efficiently handle database connections using JNDI lookup and a DataSource object.
 * This class ensures that only one instance of the connection pool is created and reused throughout the application.
 */
public class ConnectionPool {
    // Singleton instance of ConnectionPool
    private static ConnectionPool pool = null;
    // DataSource instance for managing connections
    private static DataSource dataSource = null;

    /**
     * Private constructor to initialize the DataSource by looking up the JNDI resource.
     * This prevents external instantiation and sets up the connection pool.
     */
    private ConnectionPool() {
        try {
            // Perform JNDI lookup to obtain the DataSource configured in the application server
            Context initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/music");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Provides the singleton instance of the ConnectionPool.
     * If the instance is null, it initializes a new ConnectionPool.
     *
     * @return the single instance of ConnectionPool
     */
    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    /**
     * Gets a connection from the DataSource.
     * This method allows obtaining a connection for executing database operations.
     *
     * @return a Connection object from the DataSource, or null if unable to obtain a connection
     */
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a Connection back to the pool.
     * This method should be called after completing database operations to free the connection.
     *
     * @param c the Connection to be returned to the pool
     */
    public void freeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();  // Close the connection, returning it to the pool
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
