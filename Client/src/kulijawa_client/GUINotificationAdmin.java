package kulijawa_client;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class GUINotificationAdmin extends JInternalFrame {

    private JPanel panelHead, panelCenter, panelButtom;
    private JButton btnSend, btnUnread, btnRead, btnBroadcast;
    private JTextField txtMessage;
    private static JTable tableView;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private GUIHome owner;

    public GUINotificationAdmin(GUIHome owner_) {
        super("Notification", true, true, false, true);
        owner = owner_;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="GUI">
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(Color.BLACK);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setupButtonClickEvent(button);
        return button;
    }

    private void initComponents() {
        int i = 2;
        if (owner.thisUser.get(3).contains("admin")) {
            i = 3;
        }

        panelHead = new JPanel(new GridLayout(0, i, 15, 15));
        panelHead.setBackground(Color.WHITE);
        panelHead.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        panelCenter = new JPanel(new BorderLayout());
        panelCenter.setBackground(Color.WHITE);
        panelCenter.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        panelButtom = new JPanel(new GridLayout(0, 2, 15, 15));
        panelButtom.setBackground(Color.WHITE);
        panelButtom.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        panelButtom.setVisible(false);

        txtMessage = owner.addPlaceholderTextField("Message");
        btnBroadcast = createButton("Broadcast");

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableView = new JTable(tableModel);
        scrollPane = new JScrollPane(tableView);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        btnUnread = createButton("Unread");
        btnRead = createButton("Read");

        panelButtom.add(txtMessage);
        panelButtom.add(btnBroadcast);

        panelCenter.add(scrollPane);

        if (i == 3) {
            btnSend = createButton("Send");
            panelHead.add(btnSend);
        }

        panelHead.add(btnUnread);
        panelHead.add(btnRead);

        setLayout(new BorderLayout());
        add(panelHead, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelButtom, BorderLayout.SOUTH);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }

    public void loadTable(String request) {
        DefaultTableModel model = (DefaultTableModel) tableView.getModel();
        model.setRowCount(0);

        if (owner.thisUser.get(3).contains("admin") && request.contains("Send")) {
            request = owner.thisUser.get(3);
            model.setColumnIdentifiers(new String[]{"Message", "Status", "User ID", "Admin ID", "Create Date"});
        } else {
            model.setColumnIdentifiers(new String[]{"Message", "Create Date"});
        }

        for (String data : Services.viewNotifications(owner.thisUser.get(2), request)) {
            String[] split = data.split("~");
            model.addRow(split);
        }
    }

    // </editor-fold>
    private void setupButtonClickEvent(JButton button) {
        button.addActionListener(e -> {
            String text = button.getText();
            if (text.equals("Send")) {
                panelButtom.setVisible(true);
                loadTable(text);
            } else if (text.equals("Unread")) {
                panelButtom.setVisible(false);
                loadTable(text);
            } else if (text.equals("Read")) {
                panelButtom.setVisible(false);
                loadTable(text);
            } else if (text.equals("Broadcast")) {
                String message = txtMessage.getText().trim();
                if (!message.isEmpty() && !message.contains("Message")) {
                    Services.broadcast(owner.thisUser.get(2), message);
                    txtMessage.setText("Message");
                    loadTable("Send");
                }
            }
        });
    }
}
