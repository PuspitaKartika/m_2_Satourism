package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RiwayatTransaksi {
    private JPanel panel1;
    private JButton HOMEButton;
    private JButton tambahWisataButton;
    private JButton riwayatButton;
    private JTable table1;
    private DefaultTableModel tableModel;

    public void showRiwayat(){
        JFrame frame = new JFrame("Show Riwayat");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        // Membuat model tabel dengan kolom-kolom yang sesuai
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("ID USER");
        tableModel.addColumn("ID Wisata");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Jumlah");
        tableModel.addColumn("Total Harga");
        tableModel.addColumn("No Hp");



        table1.setModel(tableModel);
        backend.transaksi.getTransaksi(tableModel);

        HOMEButton.addActionListener(e -> {
            AdminHome adminHome = new AdminHome();
            adminHome.showAdminHome();
            frame.dispose();
        });
        tambahWisataButton.addActionListener(e -> {
            TambahWisata tambahWisata = new TambahWisata();
            tambahWisata.showTambahWisata();
            frame.dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RiwayatTransaksi riwayatTransaksi = new RiwayatTransaksi();
                riwayatTransaksi.showRiwayat();
            }
        });
    }
}
