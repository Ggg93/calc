package dev.gl.calc.main.gui;

import dev.gl.calc.Operation;
import dev.gl.calc.main.actions.OkButtonActionForDialogs;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gl
 */
public class HistoryDialog extends javax.swing.JDialog {

    private MainWindow mw;
    private OkButtonActionForDialogs okButtonAction;

    public HistoryDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(null);
        this.mw = (MainWindow) parent;
        initComponents();
        createTableModel();
        initListeners();
        bindKeyListenersToOkButton();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        operationsTableScrollPane = new javax.swing.JScrollPane();
        operationsTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("History");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        upperPanel.setLayout(new java.awt.BorderLayout(2, 2));

        operationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        operationsTableScrollPane.setViewportView(operationsTable);

        upperPanel.add(operationsTableScrollPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(upperPanel);

        okButton.setText("OK");
        bottomPanel.add(okButton);

        getContentPane().add(bottomPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JTable operationsTable;
    private javax.swing.JScrollPane operationsTableScrollPane;
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

    private void createTableModel() {
        List<Operation> operations = mw.getHistory().getOperations();
        Collections.reverse(operations);
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Operation"}, 
                operations.size());
        for (int i = 0; i < operations.size(); i++) {
            model.setValueAt(operations.get(i).printForHistory(), i, 0);
        }
        
        operationsTable.setModel(model);
        
    }

}
