import javax.swing.*;
import java.awt.*;

public class MainMenuGUI extends JFrame {

    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();

    JLabel status = new JLabel("Disconnected");

    JButton login = new JButton("Login");
    JButton register = new JButton("Register");
    JButton connect = new JButton("Connect");
    JButton exit = new JButton("Exit");

    JComboBox<String> servers =
            new JComboBox<>(new String[]{
                    "United States",
                    "Germany",
                    "Japan"
            });

    public MainMenuGUI() {

        setTitle("SimpleVPN");

        setSize(420,420);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(10,1,10,10));

        add(new JLabel("Username"));
        add(username);

        add(new JLabel("Password"));
        add(password);

        add(login);

        add(register);

        add(new JLabel("Server"));

        add(servers);

        add(status);

        JPanel buttons = new JPanel();

        buttons.add(connect);

        buttons.add(exit);

        add(buttons);

        login.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Login clicked"));

        register.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Register clicked"));

        connect.addActionListener(e -> {

            status.setText("Connected to "
                    + servers.getSelectedItem());

        });

        exit.addActionListener(e ->
                System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(MainMenuGUI::new);

    }

}