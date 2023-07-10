package backend;

import database.Database;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class wisata {
    public static void createWisata(String name, String description, int harga, int stock) {
        try {
            Database.openDb();

            String sql = "INSERT INTO wisata (name, description, harga, stock) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = Database.c.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, harga);
            preparedStatement.setInt(4, stock);
            preparedStatement.executeUpdate();

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getWisata(DefaultTableModel tableModel) {
        try {
            Database.openDb();

            String sql = "SELECT * FROM wisata";
            ResultSet rs = Database.s.executeQuery(sql);

            tableModel.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int harga = rs.getInt("harga");
                int stock = rs.getInt("stock");

                Object[] rowData = {id, name, description, harga, stock};
                tableModel.addRow(rowData);
            }

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static class WisataItem {
        private int id;
        private String name;
        private int harga;

        public WisataItem(int id, String name, int harga) {
            this.id = id;
            this.name = name;
            this.harga = harga;
        }

        public int getId() {
            return id;
        }
        public int getHarga(){
            return harga;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static ArrayList<WisataItem> getNameWisata() {
        ArrayList<WisataItem> wisataItems = new ArrayList<>();
        try {
            Database.openDb();

            String sql = "SELECT id, name, harga FROM wisata";
            ResultSet rs = Database.s.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int harga = rs.getInt("harga");
                WisataItem item = new WisataItem(id, name, harga);
                wisataItems.add(item);
            }

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return wisataItems;
    }


    public static void updateWisata(int id, String name, String description, int harga, int stock) {
        try {
            Database.openDb();

            String sql = "UPDATE wisata SET name = ?, description = ?, harga = ?, stock = ? WHERE id = ?";
            PreparedStatement preparedStatement = Database.c.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, harga);
            preparedStatement.setInt(4, stock);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteWisata(int id) {
        try {
            Database.openDb();

            String sql = "DELETE FROM wisata WHERE id = ?";
            PreparedStatement preparedStatement = Database.c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
