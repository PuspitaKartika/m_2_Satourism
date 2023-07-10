package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserRiwayatTransaksi {
    private JPanel panel1;
    private JButton HOMEButton;
    private JButton keranjangButton;
    private JButton riwayatButton;
    private JButton pesanButton;
    private JTable table1;
    private DefaultTableModel tableModel;

    public void showRiwayatUser(){
        JFrame frame = new JFrame("Riwayat");
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
            UserHome userHome = new UserHome();
            userHome.showUserHome();
            frame.dispose();
        });

        keranjangButton.addActionListener(e -> {
            UserKeranjang keranjang = new UserKeranjang();
            keranjang.showRiwayat();
            frame.dispose();
        });
        pesanButton.addActionListener(e -> {
            UserPesanan pesanan = new UserPesanan();
            pesanan.showTambahPesanan();
            frame.dispose();
        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserRiwayatTransaksi riwayat = new UserRiwayatTransaksi();
                riwayat.showRiwayatUser();
            }
        });
    }


}
