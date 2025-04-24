package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.OperatorType;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class PlusPressedAction extends AbstractAction {

    private MainWindow mw;

    public PlusPressedAction(MainWindow mw) {
        this.mw = mw;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        Operation operation = mw.getOperation();

        if (operation.operandRight == null) {
            operation.operator = OperatorType.ADDITION;
        } else {
            // calculate operation; save it into history; update operation
            operation.result = Double.parseDouble(operation.operandLeft) 
                    + Double.parseDouble(operation.operandRight);
            Operation finalizedOperation = new Operation(operation);
            mw.getHistory().getOperations().add(finalizedOperation);

            operation.operandLeft = operation.result.toString();
            operation.operandRight = null;
            operation.result = null;
        }
        
        mw.updateTextFields();
    }

}
