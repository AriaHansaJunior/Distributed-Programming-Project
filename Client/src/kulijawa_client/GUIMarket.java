package kulijawa_client;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class GUIMarket extends JInternalFrame {

    private JPanel panel, panelHead, panelCenter;
    private JScrollPane scrollPane;
    private JTextField txtSearch;
    private JButton btnKate1, btnKate2;
    private GUIHome owner;

    public GUIMarket(GUIHome owner_) {
        super("Market", true, true, false, true);
        owner = owner_;
        initComponents();
//        for (String ticket : owner.listTickets) {
//            panelCenter.add(createTicket(splitData(ticket)));
//        } 
    }

    // <editor-fold defaultstate="collapsed" desc="GUI">
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(Color.BLACK);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private JButton createTicket(java.util.ArrayList<String> data) {
        Border compound = BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), Color.DARK_GRAY, Color.DARK_GRAY),
                BorderFactory.createLineBorder(Color.GRAY, 1));

        JButton btnTicket = new JButton();
        btnTicket.setLayout(new BorderLayout());
        btnTicket.setPreferredSize(new Dimension(200, 250));
        btnTicket.setContentAreaFilled(false);
        btnTicket.setFocusPainted(false);
        btnTicket.setBorder(compound);
        btnTicket.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setupTicketClickEvent(btnTicket, data.get(1));

        JLabel lblName = new JLabel(data.get(1), SwingConstants.CENTER);
        lblName.setFont(new Font("Arial", Font.BOLD, 14));
        lblName.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));

        JLabel lblImage = new JLabel();
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        addImage(lblImage, data.get(5), btnTicket.getPreferredSize().width, btnTicket.getPreferredSize().height - lblName.getPreferredSize().height);

        btnTicket.add(lblImage, BorderLayout.NORTH);
        btnTicket.add(lblName, BorderLayout.SOUTH);

        return btnTicket;
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        panelHead = new JPanel(new GridLayout(0, 3, 15, 15));
        panelHead.setBackground(Color.WHITE);
        panelHead.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        panelCenter = new JPanel(new GridLayout(0, 3, 15, 15));
        panelCenter.setOpaque(false);

        scrollPane = new JScrollPane(panelCenter);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        txtSearch = owner.addPlaceholderTextField("Search");

        btnKate1 = createStyledButton("Satu");
        btnKate2 = createStyledButton("Dua");

        panelHead.add(txtSearch);
        panelHead.add(btnKate1);
        panelHead.add(btnKate2);

        panel.add(scrollPane, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(panelHead, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }

    private void addImage(JLabel label, String byteSting, int width, int height) {
        try {
            byte[] bytes = Base64.getDecoder().decode(byteSting);
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            BufferedImage bufferedImage = ImageIO.read(byteInputStream);

            Image img = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));

        } catch (IOException e) {
            System.out.println("Error when converting byte string to image");
        }
    }
    // </editor-fold>

    private void setupTicketClickEvent(JButton btn, String title) {
        btn.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Tiket: " + title);
        });
    }

}
