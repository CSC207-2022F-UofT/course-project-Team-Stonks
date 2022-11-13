import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage extends JFrame {
    private JPanel RegistrationPage;
    private JLabel stonksLabel;
    private JTextField txtUserName;
    private JPanel RegistrationPanel;
    private JLabel textUsername;
    private JPasswordField pfPwd;
    private JPasswordField pdPwdConfirm;
    private JLabel textConfirmPwd;
    private JLabel textPassword;
    private JButton btnContinue;
    private JButton btnBack;

    public RegistrationPage() {
        super();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(RegistrationPanel);
        this.pack();
        this.setVisible(true);

        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUserName.getText();
                char[] password;
                password = pfPwd.getPassword();
                char[] passwordConfirm;
                passwordConfirm = pdPwdConfirm.getPassword();
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for (char c : password) {
                    sb.append(c);
                }
                for (char c : passwordConfirm) {
                    sb2.append(c);
                }
                String passwordString = sb.toString();
                String passwordConfirmString = sb2.toString();
                if (passwordString.equals(passwordConfirmString)) {
                    JOptionPane.showMessageDialog(null, "Registration Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!");
                }
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open StarterLogin.java and close RegistrationPage.java
                StarterLogin starterLogin = new StarterLogin();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new RegistrationPage();
        frame.setVisible(true);
    }

}