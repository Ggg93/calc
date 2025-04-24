package dev.gl.calc;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class DigitPressedAction extends AbstractAction {

    private JTextField resultTextField;
    private Operation operation;

    public DigitPressedAction(JTextField resultTextField, Operation operation) {
        this.resultTextField = resultTextField;
        this.operation = operation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numberAsString = e.getActionCommand();
        String currentResultString = resultTextField.getText();

        if (operation.operandRight == null) {
            resultTextField.setText(numberAsString);
        } else if (currentResultString.equals("0")) {
            resultTextField.setText(numberAsString);
        } else {
            resultTextField.setText(currentResultString + numberAsString);
        }

        if (operation.operandLeft != null && operation.operator != null) {
            operation.operandRight = Double.valueOf(resultTextField.getText());
        }
    }

}
