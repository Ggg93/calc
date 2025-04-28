package dev.gl.calc.main.gui;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author gl
 */
public class AboutDialog extends javax.swing.JDialog {

    private static final String homeLink = "https://github.com/Ggg93";
    private Properties properties;

    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(null);
        initComponents();
        addLogo();
        loadProperties();
        addName();
        addVersion();
        addHomeLink();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        homeLinkLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setMinimumSize(new java.awt.Dimension(400, 200));
        setPreferredSize(new java.awt.Dimension(400, 200));
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(logoPanel, java.awt.BorderLayout.WEST);

        jPanel5.setLayout(new java.awt.GridLayout(2, 1));

        nameLabel.setText("Calculator");
        jPanel5.add(nameLabel);

        versionLabel.setText("Version:");
        jPanel5.add(versionLabel);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setText("Home: ");
        jPanel6.add(jLabel3);

        homeLinkLabel.setText("https://github.com/Ggg93");
        jPanel6.add(homeLinkLabel);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 40));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel2.add(okButton);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel homeLinkLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables

    private void addLogo() {
        File logoPath = new File(".\\src\\main\\resources\\icons8-calculator-80.png");
        try {
            BufferedImage logo = ImageIO.read(logoPath);
            JLabel logoPan = new JLabel(new ImageIcon(logo));
            logoPanel.add(logoPan);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private void addHomeLink() {
        homeLinkLabel.setText("<html><a href=\"\">" + homeLink + "</a></html>");
        homeLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        homeLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(homeLink));
                } catch (Exception ex) {
                    ex.printStackTrace(System.err);
                }
            }
        });
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(".properties"));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
    }
    
    private void addName() {
        nameLabel.setText(properties.getProperty("name"));
    }

    private void addVersion() {
        versionLabel.setText("Version: " + properties.getProperty("version"));
    }
}
