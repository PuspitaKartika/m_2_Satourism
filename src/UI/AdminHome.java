package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminHome {
    private JButton HOMEButton;
    private JButton tambahWisataButton;
    private JButton riwayatButton;
    private JTable table1;
    private JTextField textField1;
    private JButton searchButton;
    private JPanel panel1;
    private JTextField textField2;
    private JButton deleteButton;
    private DefaultTableModel tableModel;

    public void showAdminHome() {
        JFrame frame = new JFrame("Admin Home");
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

        tambahWisataButton.addActionListener(e -> {
            TambahWisata tambahWisata = new TambahWisata();
            tambahWisata.showTambahWisata();
            frame.dispose();
        });

        riwayatButton.addActionListener(e -> {
            RiwayatTransaksi riwayatTransaksi = new RiwayatTransaksi();
            riwayatTransaksi.showRiwayat();
            frame.dispose();
        });

        deleteButton.addActionListener(e -> {
        int id = Integer.parseInt(textField2.getText());
        backend.wisata.deleteWisata(id);
            JOptionPane.showMessageDialog(frame, "Data berhasil dihapus");
            textField2.setText("");
            backend.wisata.getWisata(tableModel);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AdminHome adminUi = new AdminHome();
                adminUi.showAdminHome();
            }
        });
    }
}
