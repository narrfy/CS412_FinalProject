import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Quick note, make sure to connect your SQL driver (same thing as activity 11)
// To connect go "file" -> "Project Structure" -> "Modules" -> "add new" ("+" or "alt + insert") -> find the driver and apply it

public class DBConnection {
    private static final String URI = "jdbc:sqlite:412fp_DB.db";
    private static Connection connection;


    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URI);
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}

