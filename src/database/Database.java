package database;

import java.sql.*;

public class Database {
    public static Connection c;
    public static Statement s;
    public static ResultSet rs;

    public static void openDb() throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/m_2_satourism";
        String USERNAME = "root";
        String PASSWORD ="";

        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        s = c.createStatement();
    }

    //tutup database
    public static void closeDb() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
