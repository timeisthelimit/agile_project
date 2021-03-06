package agileproject;
import java.sql.*;
import java.util.Properties;
/**
 *
 * @author romanbrodskiy
 */
public class Database {
    Connection connection = null;
    
    public Database() throws Exception{
        // Initialize connection variables.
        String host = "team14agileprojectserver.mysql.database.azure.com";
        String database = "medicare";
        String user = "romanb@team14agileprojectserver";
        String password = "adminpassword1!";
//
//        // check that the driver is installed
//        try
//        {
//            Class.forName("org.mariadb.jdbc");
//        }
//        catch (ClassNotFoundException e)
//        {
//            throw new ClassNotFoundException("MariaDB JDBC driver NOT detected in library path.", e);
//        }

//        System.out.println("MariaDB JDBC driver detected in library path.");

        connection = null;

        // Initialize connection object
        try
        {
            String url = String.format("jdbc:mariadb://%s/%s", host, database);

            // Set connection properties.
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");

            // get connection
            connection = DriverManager.getConnection(url, properties);
        }
        catch (SQLException e)
        {
            System.out.println("Failed to create connection to database");
            System.exit(1);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
}
