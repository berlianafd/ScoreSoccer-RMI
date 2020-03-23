package rmi.soccerscore.server.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class untuk membuat koneksi dengan database
public class DatabaseUtilities{
    private static Connection connection;
 
    public static Connection getConnection() {
        if (connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                //membuat koneksi dengan localhost dengan db 'db_soccer', dengan user 'root'
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_soccer", "root", "");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return connection;
    }
}
