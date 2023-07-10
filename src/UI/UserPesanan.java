package UI;

import backend.wisata;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserPesanan {
    private JPanel panel1;
    private JButton HOMEButton;
    private JButton keranjangButton;
    private JButton riwayatButton;
    private JButton pesanButton;
    private JTextField nameTxt;
    private JComboBox comboBox1;
    private JTextField qtyTxt;
    private JTextField noHptxt;
    private JButton pesanButton1;
    private JButton keranjangButton1;
    private JTextPane totalTextPane;
    String selectedName;
    int selectedId;
    int hargaItem;
    int total=0;
    int qty=1;
    private void updateTotalHarga() {
        try {
            qty = Integer.parseInt(qtyTxt.getText());
        } catch (NumberFormatException e) {
            qty = 0;
        }
        total = qty * hargaItem;
        totalTextPane.setText(String.valueOf(total));
    }



    public void showTambahPesanan(){

        JFrame frame = new JFrame("Tambah Pesanan");
        frame.setContentPane(panel1); // Menggunakan panel1 yang telah dibuat dalam GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        totalTextPane.setEnabled(false);
        totalTextPane.setDisabledTextColor(Color.BLACK);


        ArrayList<wisata.WisataItem> wisataItems = backend.wisata.getNameWisata();
        DefaultComboBoxModel<wisata.WisataItem> comboBoxModel = new DefaultComboBoxModel<>(wisataItems.toArray(new wisata.WisataItem[0]));
        comboBox1.setModel(comboBoxModel);


        comboBox1.addActionListener(e -> {
            wisata.WisataItem selectedWisata = (wisata.WisataItem) comboBox1.getSelectedItem();
            selectedId = selectedWisata.getId();
            selectedName = selectedWisata.getName();
            hargaItem = selectedWisata.getHarga();
            updateTotalHarga();
            // Gunakan selectedId dan selectedName sesuai kebutuhan Anda
        });
        qtyTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTotalHarga();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTotalHarga();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTotalHarga();
            }
        });


        pesanButton1.addActionListener(e -> {
            String name = nameTxt.getText();
            qty = Integer.parseInt(qtyTxt.getText());
            String noHp = noHptxt.getText();
            total = qty * hargaItem;
            backend.transaksi.createTransaksi(2,selectedId,1,name,qty,total,noHp);
            JOptionPane.showMessageDialog(frame, "Pesanan berhasil");

            nameTxt.setText("");
            qtyTxt.setText("");
            noHptxt.setText("");
        });

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
        riwayatButton.addActionListener(e -> {
            UserRiwayatTransaksi riwayat = new UserRiwayatTransaksi();
            riwayat.showRiwayatUser();
            frame.dispose();
        });
        keranjangButton1.addActionListener(e -> {
            String name = nameTxt.getText();
            qty = Integer.parseInt(qtyTxt.getText());
            String noHp = noHptxt.getText();
            total = qty * hargaItem;
            backend.transaksi.createTransaksi(2,selectedId,2,name,qty,total,noHp);
            JOptionPane.showMessageDialog(frame, "Pesanan masuk ke keranjang");

            nameTxt.setText("");
            qtyTxt.setText("");
            noHptxt.setText("");
        });



    }
}
