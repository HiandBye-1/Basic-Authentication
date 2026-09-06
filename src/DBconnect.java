import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
    private static final String username = System.getenv("DB_USER");
    private static final String password = System.getenv("DB_PASSWORD");
    private static  String host = System.getenv("DB_HOST");

    //if host = null the do localhost on docker
    static{
        if(host == null) host = "localhost";
    }

    
    private static final String URL = "jdbc:mysql://" + host + ":3306/Ldata?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    


    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Explicitly load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Return a connection
        return DriverManager.getConnection(URL, username, password);
    }
}
///finished////////
/// /////////////