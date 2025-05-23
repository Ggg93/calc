package dev.gl.calc.main.gui;

import dev.gl.calc.Configuration;
import dev.gl.calc.main.actions.SettingsOkButtonAction;
import dev.gl.calc.main.enums.HistorySortingOrder;
import dev.gl.calc.main.enums.RoundingModeLocalized;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.text.PlainDocument;

/**
 *
 * @author gl
 */
public class SettingsDialog extends javax.swing.JDialog {

    private AbstractAction okButtonAction;
    private MainWindow mw;

    public SettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.mw = (MainWindow) parent;
        
        initComponents();
        initScaleTextField();
        initRoundingModeComboBox();
        initSortingOrderComboBox();
        initWrongStateCheckBox();
        initSoundCheckBox();
        initListeners();
        bindKeyListenersToOkButton();
        
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        calculationsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scaleTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        roundingModeComboBox = new javax.swing.JComboBox();
        IOPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SortingOrderComboBox = new javax.swing.JComboBox();
        GUIPanel = new javax.swing.JPanel();
        soundCheckBox = new javax.swing.JCheckBox();
        DebuggingPanel = new javax.swing.JPanel();
        wrongStateCheckBox = new javax.swing.JCheckBox();
        bottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(Configuration.getResourceBundle().getString("settings_title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        upperPanel.setLayout(new javax.swing.BoxLayout(upperPanel, javax.swing.BoxLayout.PAGE_AXIS));

        calculationsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(Configuration.getResourceBundle().getString("settings_calculations"))); // NOI18N
        calculationsPanel.setLayout(new java.awt.GridLayout(2, 2, 0, 5));

        jLabel1.setText(Configuration.getResourceBundle().getString("settings_scale")); // NOI18N
        calculationsPanel.add(jLabel1);
        calculationsPanel.add(scaleTextField);

        jLabel2.setText(Configuration.getResourceBundle().getString("settings_rm")); // NOI18N
        calculationsPanel.add(jLabel2);

        roundingModeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        calculationsPanel.add(roundingModeComboBox);

        upperPanel.add(calculationsPanel);

        IOPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(Configuration.getResourceBundle().getString("settings_io"))); // NOI18N
        IOPanel.setLayout(new java.awt.GridLayout(1, 2, 0, 5));

        jLabel3.setText(Configuration.getResourceBundle().getString("settings_sorting_order")); // NOI18N
        IOPanel.add(jLabel3);

        SortingOrderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        IOPanel.add(SortingOrderComboBox);

        upperPanel.add(IOPanel);

        GUIPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(Configuration.getResourceBundle().getString("settings_gui"))); // NOI18N

        soundCheckBox.setText(Configuration.getResourceBundle().getString("settings_sound")); // NOI18N

        javax.swing.GroupLayout GUIPanelLayout = new javax.swing.GroupLayout(GUIPanel);
        GUIPanel.setLayout(GUIPanelLayout);
        GUIPanelLayout.setHorizontalGroup(
            GUIPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GUIPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(soundCheckBox)
                .addContainerGap(266, Short.MAX_VALUE))
        );
        GUIPanelLayout.setVerticalGroup(
            GUIPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GUIPanelLayout.createSequentialGroup()
                .addComponent(soundCheckBox)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        upperPanel.add(GUIPanel);

        DebuggingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(Configuration.getResourceBundle().getString("settings_debugging"))); // NOI18N

        wrongStateCheckBox.setText(Configuration.getResourceBundle().getString("settings_equals_button")); // NOI18N

        javax.swing.GroupLayout DebuggingPanelLayout = new javax.swing.GroupLayout(DebuggingPanel);
        DebuggingPanel.setLayout(DebuggingPanelLayout);
        DebuggingPanelLayout.setHorizontalGroup(
            DebuggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DebuggingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wrongStateCheckBox)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        DebuggingPanelLayout.setVerticalGroup(
            DebuggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DebuggingPanelLayout.createSequentialGroup()
                .addComponent(wrongStateCheckBox)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        upperPanel.add(DebuggingPanel);

        getContentPane().add(upperPanel);

        okButton.setText("OK");
        bottomPanel.add(okButton);

        getContentPane().add(bottomPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DebuggingPanel;
    private javax.swing.JPanel GUIPanel;
    private javax.swing.JPanel IOPanel;
    private javax.swing.JComboBox SortingOrderComboBox;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel calculationsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox roundingModeComboBox;
    private javax.swing.JTextField scaleTextField;
    private javax.swing.JCheckBox soundCheckBox;
    private javax.swing.JPanel upperPanel;
    private javax.swing.JCheckBox wrongStateCheckBox;
    // End of variables declaration//GEN-END:variables

    private void initListeners() {
        okButtonAction = new SettingsOkButtonAction(this, mw);
        okButton.addActionListener(okButtonAction);
    }

    private void bindKeyListenersToOkButton() {
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ok");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ok");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "ok");

        this.getRootPane().getActionMap().put("ok", okButtonAction);
    }

    private void initScaleTextField() {
        scaleTextField.setText(String.valueOf(Configuration.operationScale));

        ScaleDocumentFilter filter = new ScaleDocumentFilter();
        PlainDocument pd = (PlainDocument) scaleTextField.getDocument();
        pd.setDocumentFilter(filter);
    }
    
    public Integer getScale() {
        if (scaleTextField.getText().isEmpty()) {
            return Configuration.operationScale;
        } else {
            return Integer.parseInt(scaleTextField.getText());
        }

    }
    
    private void initRoundingModeComboBox() {
        DefaultComboBoxModel<RoundingModeLocalized> model = new DefaultComboBoxModel<>(RoundingModeLocalized.values());
        roundingModeComboBox.setModel(model);
        roundingModeComboBox.setSelectedItem(RoundingModeLocalized.getValueByRoundingMode(Configuration.roundingMode));
    }
    
    public RoundingMode getRoundingMode() {
        return ((RoundingModeLocalized) roundingModeComboBox.getSelectedItem()).getRoundingMode();
    }
    
    private void initSortingOrderComboBox() {
        DefaultComboBoxModel<HistorySortingOrder> model = new DefaultComboBoxModel<>(HistorySortingOrder.values());
        SortingOrderComboBox.setModel(model);
        SortingOrderComboBox.setSelectedItem(Configuration.sortingOrder);
    }
    
    public HistorySortingOrder getSortingOrder() {
        return (HistorySortingOrder) SortingOrderComboBox.getSelectedItem();
    }
    
    private void initWrongStateCheckBox() {
        wrongStateCheckBox.setSelected(Configuration.blockEqualsIfWrongStateOccured);
    }
    
    public Boolean shouldEqualsButtonBeBlockedIfWrongStateOccured() {
        return wrongStateCheckBox.isSelected();
    }
    
    private void initSoundCheckBox() {
        soundCheckBox.setSelected(Configuration.soundIsOn);
    }
    
    public Boolean isSoundOn() {
        return soundCheckBox.isSelected();
    }
}
