package backend;
import database.Database;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
public class transaksi {
    public static void createTransaksi(int idUser, int idWisata, int idStatus, String namaPembeli, int qty, int totalHarga, String noHp) {
        try {
            Database.openDb();

            String sql = "INSERT INTO transaksi (id_user, id_wisata, id_status, nama_pembeli, qty, total_harga, no_hp) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = Database.c.prepareStatement(sql);
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idWisata);
            preparedStatement.setInt(3, idStatus);
            preparedStatement.setString(4, namaPembeli);
            preparedStatement.setInt(5, qty);
            preparedStatement.setInt(6, totalHarga);
            preparedStatement.setString(7, noHp);
            preparedStatement.executeUpdate();

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getTransaksi(DefaultTableModel tableModel) {
        try {
            Database.openDb();

            String sql = "SELECT * FROM transaksi WHERE id_status = 1";
            ResultSet rs = Database.s.executeQuery(sql);
            tableModel.setRowCount(0);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idUser = rs.getInt("id_user");
                int idWisata = rs.getInt("id_wisata");
                int idStatus = rs.getInt("id_status");
                String namaPembeli = rs.getString("nama_pembeli");
                int qty = rs.getInt("qty");
                int totalHarga = rs.getInt("total_harga");
                String noHp = rs.getString("no_hp");


                Object[] rowData = {id,idUser,idWisata,namaPembeli, qty,totalHarga,noHp};
                tableModel.addRow(rowData);
            }

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateTransaksi(int id, int idStatus) {
        try {
            Database.openDb();

            String sql = "UPDATE transaksi SET id_status = ? WHERE id = ?";
            PreparedStatement preparedStatement = Database.c.prepareStatement(sql);
            preparedStatement.setInt(1, idStatus);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteTransaksi(int id) {
        try {
            Database.openDb();

            String sql = "DELETE FROM transaksi WHERE id = ?";
            PreparedStatement preparedStatement = Database.c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getKeranjang(DefaultTableModel tableModel) {
        try {
            Database.openDb();

            String sql = "SELECT * FROM transaksi WHERE id_status = 2";
            ResultSet rs = Database.s.executeQuery(sql);
            tableModel.setRowCount(0);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idUser = rs.getInt("id_user");
                int idWisata = rs.getInt("id_wisata");
                int idStatus = rs.getInt("id_status");
                String namaPembeli = rs.getString("nama_pembeli");
                int qty = rs.getInt("qty");
                int totalHarga = rs.getInt("total_harga");
                String noHp = rs.getString("no_hp");

                Object[] rowData = {id,idWisata,namaPembeli, qty,totalHarga,noHp};
                tableModel.addRow(rowData);
            }

            Database.closeDb();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
