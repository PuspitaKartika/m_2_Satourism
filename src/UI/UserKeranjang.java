package UI;
import backend.transaksi;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class UserKeranjang {
    private JPanel panel1;
    private JButton HOMEButton;
    private JButton keranjangButton;
    private JButton riwayatButton;
    private JButton pesanButton;
    private JTable table1;
    private JTextField textField1;
    private JButton bayarButton;
    private JButton hapusButton;
    private DefaultTableModel tableModel;
    public void showRiwayat() {
        JFrame frame = new JFrame("Keranjang");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        // Membuat model tabel dengan kolom-kolom yang sesuai
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("ID Wisata");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Jumlah");
        tableModel.addColumn("Total Harga");
        tableModel.addColumn("No Hp");

        table1.setModel(tableModel);
        backend.transaksi.getKeranjang(tableModel);

        HOMEButton.addActionListener(e -> {
            UserHome userHome = new UserHome();
            userHome.showUserHome();
            frame.dispose();
        });
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
            riwayat.showRiwayatUser();
            frame.dispose();
        });

        bayarButton.addActionListener(e->{
            int id = Integer.parseInt(textField1.getText());
            transaksi Transaksi = new transaksi();
            Transaksi.updateTransaksi(id, 1);
            JOptionPane.showMessageDialog(frame, "Pesanan berhasil");
            textField1.setText("");
            backend.transaksi.getKeranjang(tableModel);
        });

        hapusButton.addActionListener(e->{
            int id = Integer.parseInt(textField1.getText());
            backend.transaksi.deleteTransaksi(id);
            JOptionPane.showMessageDialog(frame, "Pesanan berhasil dihapus");
            textField1.setText("");
            backend.transaksi.getKeranjang(tableModel);
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserKeranjang userKeranjang = new UserKeranjang();
                userKeranjang.showRiwayat();
            }
        });
    }
}
