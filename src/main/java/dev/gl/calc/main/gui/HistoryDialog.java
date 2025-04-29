package dev.gl.calc.main.gui;

import dev.gl.calc.Operation;
import dev.gl.calc.main.actions.OkButtonActionForDialogs;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gl
 */
public class HistoryDialog extends javax.swing.JDialog {

    private MainWindow mw;
    private OkButtonActionForDialogs okButtonAction;
    private DefaultTableModel model;

    public HistoryDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(null);
        this.mw = (MainWindow) parent;
        initComponents();
        createTableModel();
        initClearHistoryButton();
        initListeners();
        bindKeyListenersToOkButton();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        operationsTableScrollPane = new javax.swing.JScrollPane();
        operationsTable = new javax.swing.JTable();
        tableControlsPanel = new javax.swing.JPanel();
        clearHistoryButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("History");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        upperPanel.setLayout(new javax.swing.BoxLayout(upperPanel, javax.swing.BoxLayout.PAGE_AXIS));

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

        upperPanel.add(operationsTableScrollPane);

        tableControlsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableControlsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        tableControlsPanel.add(clearHistoryButton);

        upperPanel.add(tableControlsPanel);

        getContentPane().add(upperPanel);

        okButton.setText("OK");
        bottomPanel.add(okButton);

        getContentPane().add(bottomPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton clearHistoryButton;
    private javax.swing.JButton okButton;
    private javax.swing.JTable operationsTable;
    private javax.swing.JScrollPane operationsTableScrollPane;
    private javax.swing.JPanel tableControlsPanel;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables

    private void initListeners() {

        okButtonAction = new OkButtonActionForDialogs(this);
        okButton.addActionListener(okButtonAction);

        operationsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                Point point = e.getPoint();
                int row = table.rowAtPoint(point);
                if (e.getClickCount() == 2
                        && table.getSelectedRow() != -1
                        && row != -1) {
                    int modelRow = table.convertRowIndexToModel(row);
                    
                    // find the historical operation
                    String operation = (String) model.getValueAt(modelRow, 0);
                    String idSubstring = operation.substring(0, operation.indexOf(Operation.ID_DELIMETER));
                    Integer operationId = Integer.parseInt(idSubstring);
                    Operation historicalOperation = mw.getHistory().getOperationsById().get(operationId);
                    
                    // adjusting the active operation, bringing it to state of the historical operation
                    mw.getOperation().operandLeft = historicalOperation.operandLeft;
                    mw.getOperation().operandRight = historicalOperation.operandRight;
                    mw.getOperation().operator = historicalOperation.operator;
                    mw.getOperation().result = historicalOperation.result;
                    mw.updateTextFields();
                    
                    // closing the dialog
                    okButtonAction.actionPerformed(null);
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

    private void createTableModel() {
        List<Operation> operations = new ArrayList<>(mw.getHistory().getOperationsById().values());
//        Collections.reverse(operations);

        model = new DefaultTableModel(new Object[]{"Operation"},
                operations.size()) {

            // disabling cell editing 
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (int i = 0; i < operations.size(); i++) {
            model.setValueAt(operations.get(i).printForHistory(), i, 0);
        }
        operationsTable.setModel(model);
    }

    private void initClearHistoryButton() {
        URL url = this.getClass().getClassLoader().getResource("icons8-clear-20.png");
        ImageIcon image = new ImageIcon(url);
        clearHistoryButton.setIcon(image);
        clearHistoryButton.setHorizontalTextPosition(JButton.CENTER);
        clearHistoryButton.setVerticalTextPosition(JButton.CENTER);
        clearHistoryButton.setMargin(new Insets(0, 0, 0, 0));

        clearHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mw.getHistory().clearHistory();

                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }

//                model.fireTableDataChanged(); // its strange, but this is not necessary
            }
        });
    }
}
