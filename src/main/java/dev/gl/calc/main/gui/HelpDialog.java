package dev.gl.calc.main.gui;

import dev.gl.calc.main.actions.OkButtonActionForDialogs;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author gl
 */
public class HelpDialog extends javax.swing.JDialog {

    private OkButtonActionForDialogs okButtonAction;

    public HelpDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(null);
        initComponents();
        initListeners();
        bindKeyListenersToOkButton();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        memoryPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        operatorsPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Help");
        setMinimumSize(new java.awt.Dimension(400, 580));
        setPreferredSize(new java.awt.Dimension(400, 580));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        upperPanel.setLayout(new javax.swing.BoxLayout(upperPanel, javax.swing.BoxLayout.PAGE_AXIS));

        menuPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu shortcuts"));
        menuPanel.setLayout(new java.awt.GridLayout(9, 1, 0, 3));

        jLabel1.setText("About: F1");
        menuPanel.add(jLabel1);

        jLabel2.setText("Settings: F2");
        menuPanel.add(jLabel2);

        jLabel22.setText("Help: F3");
        menuPanel.add(jLabel22);

        jLabel3.setText("Save: Ctrl+S");
        menuPanel.add(jLabel3);

        jLabel4.setText("Exit: F12");
        menuPanel.add(jLabel4);

        jLabel5.setText("History: Ctrl+H");
        menuPanel.add(jLabel5);

        jLabel17.setText("Clear History: Ctrl+Shift+D");
        menuPanel.add(jLabel17);

        jLabel6.setText("Switch to English: Ctrl+Shift+1");
        menuPanel.add(jLabel6);

        jLabel7.setText("Switch to Russian: Ctrl+Shift+2");
        menuPanel.add(jLabel7);

        upperPanel.add(menuPanel);

        memoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Memory shortcuts"));
        memoryPanel.setLayout(new java.awt.GridLayout(4, 1, 0, 3));

        jLabel8.setText("Memory Add: Ctrl+P");
        memoryPanel.add(jLabel8);

        jLabel9.setText("Memory Subtract: Ctrl+Q");
        memoryPanel.add(jLabel9);

        jLabel10.setText("Memory Recall: Ctrl+R");
        memoryPanel.add(jLabel10);

        jLabel11.setText("Memory Clear: Ctrl+L");
        memoryPanel.add(jLabel11);

        upperPanel.add(memoryPanel);

        operatorsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Operators shortcuts"));
        operatorsPanel.setLayout(new java.awt.GridLayout(9, 1, 0, 3));

        jLabel12.setText("Equals: Enter");
        operatorsPanel.add(jLabel12);

        jLabel13.setText("Change sign: F9");
        operatorsPanel.add(jLabel13);

        jLabel14.setText("DEL: Backspace");
        operatorsPanel.add(jLabel14);

        jLabel15.setText("CE: Delete");
        operatorsPanel.add(jLabel15);

        jLabel16.setText("C: Escape");
        operatorsPanel.add(jLabel16);

        jLabel18.setText("Percent: Shift+5");
        operatorsPanel.add(jLabel18);

        jLabel21.setText("1/x: R");
        operatorsPanel.add(jLabel21);

        jLabel19.setText("x^2: Q");
        operatorsPanel.add(jLabel19);

        jLabel20.setText("2√x: Shift+2");
        operatorsPanel.add(jLabel20);

        upperPanel.add(operatorsPanel);

        getContentPane().add(upperPanel);

        bottomPanel.setPreferredSize(new java.awt.Dimension(400, 20));

        okButton.setText("OK");
        bottomPanel.add(okButton);

        getContentPane().add(bottomPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel memoryPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel operatorsPanel;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables

    private void initListeners() {
        okButtonAction = new OkButtonActionForDialogs(this);
        okButton.addActionListener(okButtonAction);
    }

    private void bindKeyListenersToOkButton() {
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ok");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ok");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "ok");

        this.getRootPane().getActionMap().put("ok", okButtonAction);
    }
}
