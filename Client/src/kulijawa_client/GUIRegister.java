package kulijawa_client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIRegister {

    private JFrame frame;
    private JPanel panel, panelTop, panelCenter;
    private JTextField fullnameField, usernameField, emailField;
    private JPasswordField passwordField;
    private JSpinner daySpinner, monthSpinner, yearSpinner;
    int rowIndex = 0;

    public GUIRegister() {
        initComponents();
//        try {
//            Socket clientSocket = new Socket("localhost", 6060);
//        } catch (IOException ex) {
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="GUI">
    private JLabel addLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        return label;
    }

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

    public JPanel addDateTimeSpinner() {
        java.time.LocalDate today = java.time.LocalDate.now();
        JPanel panelDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDate.setOpaque(false);

        daySpinner = new JSpinner(new SpinnerNumberModel(today.getDayOfMonth(), 1, 31, 1));
        panelDate.add(addLabel("DD:"));
        panelDate.add(daySpinner);

        monthSpinner = new JSpinner(new SpinnerNumberModel(today.getMonthValue(), 1, 12, 1));
        panelDate.add(addLabel("MM:"));
        panelDate.add(monthSpinner);

        yearSpinner = new JSpinner(new SpinnerNumberModel(today.getYear(), 1900, today.getYear(), 1));
        yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "####"));
        panelDate.add(addLabel("YYYY:"));
        panelDate.add(yearSpinner);

        return panelDate;
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
        frame = new JFrame("Register");
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

        fullnameField = addPlaceholderTextField("Full Name");
        usernameField = addPlaceholderTextField("Username");
        emailField = addPlaceholderTextField("Email");
        passwordField = addPlaceholderPasswordField("Password");

        addComponent(panelCenter, fullnameField);
        addComponent(panelCenter, addDateTimeSpinner());
        addComponent(panelCenter, usernameField);
        addComponent(panelCenter, emailField);
        addComponent(panelCenter, passwordField);
        addComponent(panelCenter, addButton("Register", 0, Color.BLACK, false, true, true, true));

        panelTop.add(addButton("X", 1, Color.WHITE, true, false, false, false), BorderLayout.WEST);

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
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setPreferredSize(new Dimension(280, 40));
        passwordTextField.setEchoChar((char) 0);
        passwordTextField.setText(placeholder);
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordTextField.setForeground(Color.GRAY);

        passwordTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordTextField.getPassword()).equals(placeholder)) {
                    passwordTextField.setText("");
                    passwordTextField.setEchoChar('•');
                    passwordTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordTextField.getPassword()).isEmpty()) {
                    passwordTextField.setText(placeholder);
                    passwordTextField.setEchoChar((char) 0);
                    passwordTextField.setForeground(Color.GRAY);
                }
            }
        });

        return passwordTextField;
    }
    // </editor-fold>
    // </editor-fold>

    private void setupButtonClickEvent(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (button.getText().equals("Register")) {

                    String fullName = fullnameField.getText().trim();
                    String username = usernameField.getText().trim();
                    String email = emailField.getText().trim();
                    String password = new String(passwordField.getPassword()).trim();

                    int year = (int) yearSpinner.getValue();
                    int month = (int) monthSpinner.getValue();
                    int day = (int) daySpinner.getValue();

                    java.time.LocalDate dobLocal = java.time.LocalDate.of(year, month, day);
                    String dob = dobLocal.toString();

                    // <editor-fold defaultstate="collapsed" desc="Empty Handler">
                    String empty = null;
                    if (fullName.isEmpty() || fullName.equals("Full Name")) {
                        empty = "Full Name is required.";
                    } else if (username.isEmpty() || username.equals("Username")) {
                        empty = "Username is required.";
                    } else if (email.isEmpty() || email.equals("Email")) {
                        empty = "Email is required.";
                    } else if (password.isEmpty() || password.equals("Password")) {
                        empty = "Password is required.";
                    }

                    if (empty != null) {
                        JOptionPane.showMessageDialog(frame, empty);
                        return;
                    }
                    // </editor-fold>

                    try {
                        if (Services.registerUser(fullName, username, email, password, dob)) {
                            SwingUtilities.invokeLater(() -> new GUILogin());
                            frame.dispose();
                        } else {
                            throw new Exception("Account already exists");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                    }

                    // <editor-fold defaultstate="collapsed" desc="Back Button">
                } else if (button.getText().equals("X")) {
                    SwingUtilities.invokeLater(() -> new GUILogin());
                    frame.dispose();
                }
                // </editor-fold>
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUIRegister());
    }
}
