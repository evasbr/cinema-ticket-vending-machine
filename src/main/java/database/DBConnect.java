
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747057";
    private static final String USER = "sql12747057";
    private static final String PASSWORD = "VIAfZSnXe2";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            System.err.println("Koneksi gagal: " + e.getMessage());
        }
        return connection;
    }
    
    public static void main(String[] args) {
    System.out.println("Testing koneksi...");
    Connection conn = connect(); // Panggil method connect() untuk tes
    if (conn != null) {
        System.out.println("Koneksi berhasil.");
    } else {
        System.out.println("Koneksi gagal.");
    }
}
}

