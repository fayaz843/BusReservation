package BusReservationUsingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String url="jdbc:mysql://localhost:3306/busreservation";
    private static final String username="root";
    private static final String password="Qwerty@2001";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
