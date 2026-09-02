import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
    private static final String username = System.getenv("DB_USER");
    private static final String password = System.getenv("DB_PASSWORD");
    private static final String URL =
        "jdbc:mysql://localhost:3306/Ldata?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
       // your MySQL username
    


    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Explicitly load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Return a connection
        return DriverManager.getConnection(URL, username, password);
    }
}
///finished////////
/// /////////////