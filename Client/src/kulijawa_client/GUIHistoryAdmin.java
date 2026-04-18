package kulijawa_client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUIHistoryAdmin extends JInternalFrame {

    private JPanel panel;
    private JTextField txtSearch;
    private static JTable tableHistory;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private GUIHome owner;

    public GUIHistoryAdmin(GUIHome owner_) {
        super("History", true, true, false, true);
        owner = owner_;
        initComponents();
        loadTable();
    }

    // <editor-fold defaultstate="collapsed" desc="GUI">
    private void initComponents() {
        panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        txtSearch = owner.addPlaceholderTextField("Search");

        String[] columnNames = {"ID", "Qty", "Total Discount", "Total Price", "Status", "Create Date", "User ID", "Ticket ID"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableHistory = new JTable(tableModel);
        scrollPane = new JScrollPane(tableHistory);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        panel.add(txtSearch, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }

    public static void loadTable() {
        DefaultTableModel model = (DefaultTableModel) tableHistory.getModel();
        model.setRowCount(0);
        for (String data : Services.viewPurchases()) {
            System.out.println(data);
            String[] x = data.split("~");
            model.addRow(x);
        }
    }
    // </editor-fold>

}
