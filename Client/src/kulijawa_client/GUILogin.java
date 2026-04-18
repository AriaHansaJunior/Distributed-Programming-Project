package kulijawa_client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUILogin {

    private JFrame frame;
    private JPanel panel, panelTop, panelCenter;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private int rowIndex = 0;

    public GUILogin() {
        initComponents();
//        try {
//            Socket clientSocket = new Socket("localhost", 6060);
//        } catch (IOException ex) {
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="GUI">
    private JButton addButton(String text, int style, Color foreground, Boolean autoSize, Boolean filled, Boolean border, Boolean focus) {
        JButton button = new JButton(text);

        if (!autoSize) {
            button.setPreferredSize(new Dimension(280, 40));
        }

        button.setFont(new Font("Arial", style, 14));
        button.setForeground(foreground);
        button.setContentAreaFilled(filled);
        button.setBorderPainted(border);
        button.setFocusPainted(focus);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setupButtonClickEvent(button);

        return button;
    }

    private void addComponent(JPanel panel, Component comp) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = rowIndex++;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        panel.add(comp, gbc);
    }

    private void initComponents() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        panelTop = new JPanel(new BorderLayout());
        panelTop.setOpaque(false);

        panelCenter = new JPanel(new GridBagLayout());
        panelCenter.setOpaque(false);

        usernameField = addPlaceholderTextField("Username");
        passwordField = addPlaceholderPasswordField("Password");

        addComponent(panelCenter, usernameField);
        addComponent(panelCenter, passwordField);
        addComponent(panelCenter, addButton("Log In", 0, Color.BLACK, false, true, true, true));

        panelTop.add(addButton("X", 1, Color.WHITE, true, false, false, false), BorderLayout.WEST);
        panelTop.add(addButton("Register", 0, Color.WHITE, true, false, false, false), BorderLayout.EAST);

        panel.add(panelTop, BorderLayout.NORTH);
        panel.add(panelCenter, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Placeholder">
    private JTextField addPlaceholderTextField(String placeholder) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(280, 40));
        textField.setText(placeholder);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });

        return textField;
    }

    private JPasswordField addPlaceholderPasswordField(String placeholder) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(280, 40));
        passwordField.setEchoChar((char) 0);
        passwordField.setText(placeholder);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setForeground(Color.GRAY);

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals(placeholder)) {
                    passwordField.setText("");
                    passwordField.setEchoChar('•');
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText(placeholder);
                    passwordField.setEchoChar((char) 0);
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });

        return passwordField;
    }
    // </editor-fold>
    // </editor-fold>

    private void setupButtonClickEvent(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (button.getText().equals("Register")) {
                    SwingUtilities.invokeLater(() -> new GUIRegister());
                    frame.dispose();
                } else if (button.getText().equals("Log In")) {

                    String username = usernameField.getText().trim();
                    String password = new String(passwordField.getPassword()).trim();

                    // <editor-fold defaultstate="collapsed" desc="Empty Handler">
                    String empty = null;
                    if (username.isEmpty() || username.equals("Username")) {
                        empty = "Username is required.";
                    } else if (password.isEmpty() || password.equals("Password")) {
                        empty = "Password is required.";
                    }

                    if (empty != null) {
                        JOptionPane.showMessageDialog(frame, empty);
                        return;
                    }
                    // </editor-fold>

                    try {
                        String result = Services.checkLogin(username, password);
                        if (!result.equals("Login failed")) {
                            SwingUtilities.invokeLater(() -> new GUIHome(result));
                            frame.dispose();
                        } else {
                            throw new Exception("Login Failed");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                    }

                    // <editor-fold defaultstate="collapsed" desc="Back Button">
                } else if (button.getText()
                        .equals("X")) {
                    frame.dispose();
                }
                // </editor-fold>
            }
        }
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUILogin());
    }
}
