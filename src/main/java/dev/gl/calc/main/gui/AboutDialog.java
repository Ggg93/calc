package dev.gl.calc.main.gui;

import dev.gl.calc.Configuration;
import dev.gl.calc.main.actions.OkButtonActionForDialogs;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

/**
 *
 * @author gl
 */
public class AboutDialog extends javax.swing.JDialog {

    private static final String HOME_LINK = "https://github.com/Ggg93";
    private static final String CALCULATOR_LINK = "https://icons8.com/icon/53529/calculator";
    private static final String CALCULATOR_IMAGE_LINK = """
                                                        <html>
                                                        <a href="https://icons8.com/icon/53529/calculator">Calculator</a>
                                                        icon by 
                                                        <a href="https://icons8.com">Icons8</a>
                                                        </html>
                                                        """;
    private static final String CLEAR_HISTORY_LINK = "https://icons8.com/icon/47576/broom";
    private static final String CLEAR_HISTORY_IMAGE_LINK = """
                                                        <html>
                                                        <a href="https://icons8.com/icon/47576/broom">Clear</a> 
                                                        icon by <a  href="https://icons8.com">Icons8</a>
                                                        </html>
                                                        """;
    private Properties properties;
    private OkButtonActionForDialogs okButtonAction;

    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initListeners();
        bindKeyListenersToOkButton();
        addLogo();
        loadProperties();
        addName();
        addVersion();
        addHomeLink();
        addCreditsLink();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        upperMainSubpanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        nameAndVersionSubpanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        upperInfoSubpanel = new javax.swing.JPanel();
        homeLinkPanel = new javax.swing.JPanel();
        homeLabel = new javax.swing.JLabel();
        homeLinkLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        creditsLabel = new javax.swing.JLabel();
        creditsLinkLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        clearHistoryLinkLabel = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(Configuration.getResourceBundle().getString("about_title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(400, 240));
        setPreferredSize(new java.awt.Dimension(400, 240));
        setResizable(false);

        upperPanel.setLayout(new java.awt.BorderLayout());

        upperMainSubpanel.setLayout(new java.awt.BorderLayout());
        upperMainSubpanel.add(logoPanel, java.awt.BorderLayout.WEST);

        nameAndVersionSubpanel.setLayout(new java.awt.GridLayout(2, 1));

        nameLabel.setText("Calculator");
        nameAndVersionSubpanel.add(nameLabel);

        versionLabel.setText("Version:");
        nameAndVersionSubpanel.add(versionLabel);

        upperMainSubpanel.add(nameAndVersionSubpanel, java.awt.BorderLayout.CENTER);

        upperPanel.add(upperMainSubpanel, java.awt.BorderLayout.NORTH);

        upperInfoSubpanel.setLayout(new javax.swing.BoxLayout(upperInfoSubpanel, javax.swing.BoxLayout.PAGE_AXIS));

        homeLinkPanel.setMinimumSize(new java.awt.Dimension(191, 20));
        homeLinkPanel.setPreferredSize(new java.awt.Dimension(191, 20));
        homeLinkPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        homeLabel.setText(Configuration.getResourceBundle().getString("about_home")); // NOI18N
        homeLinkPanel.add(homeLabel);

        homeLinkLabel.setText("https://github.com/Ggg93");
        homeLinkPanel.add(homeLinkLabel);

        upperInfoSubpanel.add(homeLinkPanel);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        creditsLabel.setText(Configuration.getResourceBundle().getString("about_credits")); // NOI18N
        jPanel3.add(creditsLabel);
        jPanel3.add(creditsLinkLabel);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        clearHistoryLinkLabel.setText("jLabel1");
        jPanel4.add(clearHistoryLinkLabel);

        jPanel2.add(jPanel4);

        upperInfoSubpanel.add(jPanel2);

        upperPanel.add(upperInfoSubpanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(upperPanel, java.awt.BorderLayout.NORTH);

        bottomPanel.setPreferredSize(new java.awt.Dimension(400, 40));

        okButton.setText("OK");
        bottomPanel.add(okButton);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel clearHistoryLinkLabel;
    private javax.swing.JLabel creditsLabel;
    private javax.swing.JLabel creditsLinkLabel;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel homeLinkLabel;
    private javax.swing.JPanel homeLinkPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel nameAndVersionSubpanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel upperInfoSubpanel;
    private javax.swing.JPanel upperMainSubpanel;
    private javax.swing.JPanel upperPanel;
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
        versionLabel.setText(Configuration.getResourceBundle().getString("about_version") 
                + ": " + properties.getProperty("version"));
    }

    private void addHomeLink() {
        homeLinkLabel.setText("<html><a href=\"\">" + HOME_LINK + "</a></html>");
        homeLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        homeLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(HOME_LINK));
                } catch (Exception ex) {
                    ex.printStackTrace(System.err);
                }
            }
        });
    }

    private void addCreditsLink() {
        
        // calculator
        creditsLinkLabel.setText(CALCULATOR_IMAGE_LINK);
        creditsLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        creditsLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(CALCULATOR_LINK));
                } catch (Exception ex) {
                    ex.printStackTrace(System.err);
                }
            }
        });
        
        // clearing history
        clearHistoryLinkLabel.setText(CLEAR_HISTORY_IMAGE_LINK);
        clearHistoryLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearHistoryLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(CLEAR_HISTORY_LINK));
                } catch (Exception ex) {
                    ex.printStackTrace(System.err);
                }
            }
        });
    }

    private void bindKeyListenersToOkButton() {
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ok");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ok");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "ok");

        this.getRootPane().getActionMap().put("ok", okButtonAction);
    }

    private void initListeners() {

        okButtonAction = new OkButtonActionForDialogs(this);
        okButton.addActionListener(okButtonAction);
    }
}
