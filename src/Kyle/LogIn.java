// File: LogIn.java
package Kyle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LogIn {

    public void login() {

        // Create panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);

        // Create frame
        final JFrame frame = new JFrame("Bubblelicious");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panel);

        // Set frame icon
        try {
            ImageIcon milktea = new ImageIcon("milktea.png");
            frame.setIconImage(milktea.getImage());
        } catch (Exception ex) {
            System.out.println("Icon not found: " + ex.getMessage());
        }

        // Add components to panel
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(611, 200, 100, 30);
        usernameLabel.setForeground(Color.BLACK);

        final JTextField usernameField = new JTextField();
        usernameField.setBounds(611, 227, 196, 30);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(611, 268, 100, 30);
        passwordLabel.setForeground(Color.BLACK);

        final JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(611, 294, 196, 30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(711, 339, 80, 30);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(621, 339, 80, 30);

        final JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(566, 400, 300, 30);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bg;
        try {
            bg = new JLabel(new ImageIcon("D:/hakdog/GUI/src/Kyle/milky.png"));
            bg.setBounds(0, 0, 900, 700);
        } catch (Exception ex) {
            bg = new JLabel("Background image not found.");
            bg.setBounds(0, 0, 900, 700);
        }

        // Add components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signUpButton);
        panel.add(messageLabel);
        panel.add(bg);

        // Add login button functionality
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] usernames = {"admin", "kylex", "user2"};
                String[] passwords = {"password123", "blabla", "password2"};

                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                boolean loginSuccessful = false;

                for (int i = 0; i < usernames.length; i++) {
                    if (username.equals(usernames[i]) && password.equals(passwords[i])) {
                        loginSuccessful = true;
                        break;
                    }
                }

                if (loginSuccessful) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login successful!");
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Invalid username or password.");
                }
            }
        });

        // Add sign-up button functionality
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup signUpFrame = new signup();
                signUpFrame.showSignUp();

                // Close the current frame
                frame.dispose();
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        LogIn login = new LogIn();
        login.login();
    }
}