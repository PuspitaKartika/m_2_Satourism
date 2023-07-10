package UI;

import javax.swing.*;
import backend.Login;
import UI.AdminHome;


public class login {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton LOGINButton;
    private JPanel panel1;

    public static void main(String[] args) {
        // Menjalankan tampilan GUI di thread antarmuka pengguna (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Membuat instance dari kelas Login
                login Login = new login();
                // Menampilkan GUI
                Login.setupLogin();

            }
        });
    }

    private void setupLogin(){
        JFrame frame = new JFrame("Login");
        frame.setContentPane(panel1); // Menggunakan panel1 yang telah dibuat dalam GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        LOGINButton.addActionListener(e -> {
            String username = textField1.getText();
            String password = new String (passwordField1.getPassword());

            Login login = new Login();

            if(login.validateAdmin(username, password)){
                JOptionPane.showMessageDialog(frame, "Login Admin Berhasil");
                AdminHome adminHome = new AdminHome();
                adminHome.showAdminHome();
                frame.dispose();
            } else if (login.validatePengguna(username, password)){
                JOptionPane.showMessageDialog(frame, "Login Pengguna Berhasil");
                UserHome userHome = new UserHome();
                userHome.showUserHome();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Username atau Password Salah");
            }

            textField1.setText("");
            passwordField1.setText("");
        });
    }
}
