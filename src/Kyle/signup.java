package Kyle;

import javax.swing.*;

public class signup {

    public void showSignUp() {
        // Create frame
        JFrame frame = new JFrame("Sign Up");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        // Add components to the panel
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 30);
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 100, 30);
        panel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 100, 200, 30);
        panel.add(emailField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 200, 100, 30);
        panel.add(registerButton);

        // Add register button functionality
        registerButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Registration Successful!");
            frame.dispose();
        });

        // Make frame visible
        frame.setVisible(true);
    }
}
