package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserHome {
    private JPanel panel1;
    private JButton HOMEButton;
    private JButton keranjangButton;
    private JButton riwayatButton;
    private JTable table1;
    private JTextField textField1;
    private JButton searchButton;
    private JButton pesanButton;
    private DefaultTableModel tableModel;

    public void showUserHome() {
        JFrame frame = new JFrame("User Home");
        frame.setContentPane(panel1); // Menggunakan panel1 yang telah dibuat dalam GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Membuat model tabel dengan kolom-kolom yang sesuai
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Description");
        tableModel.addColumn("Harga");
        tableModel.addColumn("Stock");

        table1.setModel(tableModel);
        backend.wisata.getWisata(tableModel);

        pesanButton.addActionListener(e -> {
            UserPesanan pesanan = new UserPesanan();
            pesanan.showTambahPesanan();
            frame.dispose();
        });

        keranjangButton.addActionListener(e -> {
            UserKeranjang keranjang = new UserKeranjang();
            keranjang.showRiwayat();
            frame.dispose();
        });
        riwayatButton.addActionListener(e -> {
            UserRiwayatTransaksi riwayat = new UserRiwayatTransaksi();
            frame.dispose();
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserHome userHome = new UserHome();
                userHome.showUserHome();
            }
        });
    }
}
