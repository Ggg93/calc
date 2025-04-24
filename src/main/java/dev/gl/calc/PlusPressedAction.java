package dev.gl.calc;

import dev.gl.calc.enums.OperatorType;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class PlusPressedAction extends AbstractAction {

    private JTextField historyTextField;
    private JTextField resultTextField;
    private Operation operation;
    private History history;

    public PlusPressedAction(JTextField historyTextField, JTextField resultTextField, Operation operation, History history) {
        this.historyTextField = historyTextField;
        this.resultTextField = resultTextField;
        this.operation = operation;
        this.history = history;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // init operation with ADDITION
        if (operation.operandLeft == null) {
            operation.operandLeft = Double.parseDouble(resultTextField.getText());
            operation.operator = OperatorType.ADDITION;
            historyTextField.setText(operation.toString());
            return;
        }

        // update operation: set operator to ADDITION
        if (operation.operandRight == null) {
            operation.operator = OperatorType.ADDITION;
            historyTextField.setText(operation.toString());
            return;
        }

        // calculate operation; save it into history; update operation
        operation.result = operation.operandLeft + operation.operandRight;
        Operation finalizedOperation = new Operation(operation);
        history.getOperations().add(finalizedOperation);

        operation.operandLeft = Double.valueOf(operation.result);
        operation.operandRight = null;
        operation.result = null;
        historyTextField.setText(operation.toString());
        resultTextField.setText(operation.operandLeft.toString());
    }

}
