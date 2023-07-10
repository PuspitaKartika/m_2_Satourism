package backend;

import database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public boolean validateAdmin(String name, String pass){
        String dbUserName, dbPassword;

        try {
            Database.openDb();
            String sql = "SELECT name, pass FROM users Where id_role LIKE 1";
            ResultSet rs = Database.s.executeQuery(sql);

            while (rs.next()){
                dbUserName = rs.getString("name");
                dbPassword = rs.getString("pass");

                if(dbUserName.equals(name) && dbPassword.equals(pass)){
                    Database.closeDb();
                    return  true;
                }
            }
            Database.closeDb();
            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validatePengguna(String name, String pass){
        String dbUserName, dbPassword;

        try {
            Database.openDb();
            String sql = "SELECT id, name, pass FROM users Where id_role LIKE 2";
            ResultSet rs = Database.s.executeQuery(sql);

            while (rs.next()){
                dbUserName = rs.getString("name");
                dbPassword = rs.getString("pass");

                if(dbUserName.equals(name) && dbPassword.equals(pass)){
                    Database.closeDb();
                    return true;
                }
            }
            Database.closeDb();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
