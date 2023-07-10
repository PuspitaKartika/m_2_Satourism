package UI;

import javax.swing.*;

public class TambahWisata {
    private JPanel panel1;
    private JButton HOMEButton;
    private JButton tambahWisataButton;
    private JButton riwayatButton;
    private JTextField nameTxt;
    private JFormattedTextField descTxt;
    private JTextField hargaTxt;
    private JTextField stockTxt;
    private JButton simpanButton;

    public void showTambahWisata(){
        JFrame frame = new JFrame("Tambah Wisata");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        simpanButton.addActionListener(e ->{
            String name = nameTxt.getText();
            String desc = descTxt.getText();
            int harga = Integer.parseInt(hargaTxt.getText());
            int stock = Integer.parseInt(stockTxt.getText());
            backend.wisata.createWisata(name, desc, harga, stock);
            JOptionPane.showMessageDialog(frame, "Data berhasil ditambahkan");

            // Reset nilai inputan setelah data ditambahkan
            nameTxt.setText("");
            descTxt.setText("");
            hargaTxt.setText("");
            stockTxt.setText("");
        });

        HOMEButton.addActionListener(e -> {
            AdminHome adminHome = new AdminHome();
            adminHome.showAdminHome();
            frame.dispose();
        });
        riwayatButton.addActionListener(e -> {
            RiwayatTransaksi riwayatTransaksi = new RiwayatTransaksi();
            riwayatTransaksi.showRiwayat();
            frame.dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TambahWisata tambahWisataUI = new TambahWisata();
                tambahWisataUI.showTambahWisata();
            }
        });
    }
}
