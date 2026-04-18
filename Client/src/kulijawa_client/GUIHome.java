package kulijawa_client;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GUIHome {

    private JFrame frame;
    private JPanel panelHeader, panelSidebar;
    private JSplitPane splitPane;
    private JDesktopPane desktopPane;
    private JButton btnSidebar;

    public ArrayList<String> listTickets = new ArrayList<>();
    public ArrayList<String> thisUser;

    public GUIHome(String userData) {
        thisUser = splitData(userData);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="GUI">
    private JButton addContentSidebar(Color color, String text, Color foreground) {
        if (color == null) {
            color = Color.BLACK;
        }
        if (foreground == null) {
            foreground = Color.WHITE;
        }
        if (color.equals(foreground)) {
            foreground = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
        }

        JButton button = new JButton();
        button.setPreferredSize(new Dimension(200, 50));
        button.setLayout(new BorderLayout());
        button.setBackground(color);
        button.setBorderPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setupButtonClickEvent(button);

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(foreground);
        setupContentSidebarAction(label);

        button.add(label, BorderLayout.CENTER);
        return button;
    }

    private void initComponents() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);

        panelHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panelSidebar = new JPanel();
        panelSidebar.setBackground(Color.WHITE);
        panelSidebar.setMinimumSize(new Dimension(0, 0));
        panelSidebar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        desktopPane = new JDesktopPane();
        desktopPane.setMinimumSize(new Dimension(0, Integer.MAX_VALUE));

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelSidebar, desktopPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(200);

        btnSidebar = new JButton("☰");
        btnSidebar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSidebar.setContentAreaFilled(false);
        btnSidebar.setFocusPainted(false);
        setupButtonClickEvent(btnSidebar);

        panelSidebar.add(addContentSidebar(Color.WHITE, "Home", Color.WHITE));
        panelSidebar.add(addContentSidebar(null, "Market", null));
        panelSidebar.add(addContentSidebar(null, "Notification", null));

        if (thisUser.get(3).contains("admin")) {
            panelSidebar.add(addContentSidebar(null, "History", null));
        }

        panelHeader.add(btnSidebar);

        frame.add(panelHeader, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    private void setupContentSidebarAction(JLabel label) {
        splitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, (java.beans.PropertyChangeEvent evt) -> {
            if ((int) evt.getNewValue() > 200) {
                splitPane.setDividerLocation(200);
            } else if (splitPane.getDividerLocation() <= 45) {
                label.setVisible(false);
            } else if (splitPane.getDividerLocation() <= 75) {
                label.setVisible(true);
                label.setFont(new Font("Arial", Font.BOLD, 16));
            } else {
                label.setVisible(true);
                label.setFont(new Font("Arial", Font.BOLD, 20));
            }
        });
    }

    private void openInternalFrame(JInternalFrame newFrame) {
        try {
            if (newFrame == null) {
                for (JInternalFrame openedFrame : desktopPane.getAllFrames()) {
                    openedFrame.dispose();
                }
                return;
            }

            for (JInternalFrame openedFrame : desktopPane.getAllFrames()) {
                if (openedFrame.getClass().equals(newFrame.getClass())) {
                    openedFrame.setIcon(false);
                    openedFrame.setSelected(true);
                    openedFrame.toFront();
                    return;
                }
            }

            desktopPane.add(newFrame);
            newFrame.pack();
            newFrame.setVisible(true);
            newFrame.setMaximum(true);
        } catch (Exception ex) {

        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Public">
    public static ArrayList<String> splitData(String ticket) {
        return new ArrayList<>(Arrays.asList(ticket.split("~")));
    }

    // <editor-fold defaultstate="collapsed" desc="Placeholder">
    public JTextField addPlaceholderTextField(String placeholder) {
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

    public JPasswordField addPlaceholderPasswordField(String placeholder) {
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
    //</editor-fold>

    private void setupButtonClickEvent(JComponent component) {
        try {
            component.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (component == btnSidebar) {
                        if (splitPane.getDividerLocation() < 50) {
                            splitPane.setDividerLocation(200);
                        } else {
                            splitPane.setDividerLocation(0);
                        }
                    } else if (component instanceof JButton) {
                        JButton button = (JButton) component;
                        Component firstComponent = button.getComponent(0);
                        if (firstComponent instanceof JLabel) {
                            String label = ((JLabel) firstComponent).getText();

                            if (label.equals("Home")) {
                                openInternalFrame(null);
                            } else if (label.equals("Market")) {
                                openInternalFrame(new GUIMarket(GUIHome.this));
                            } else if (label.equals("History")) {
                                openInternalFrame(new GUIHistoryAdmin(GUIHome.this));
                            } else if (label.equals("Notification")) {
                                openInternalFrame(new GUINotificationAdmin(GUIHome.this));
                            } else {

                            }
                        }
                    }
                }
            });
        } catch (Exception ex) {

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUIHome(""));
    }
}
