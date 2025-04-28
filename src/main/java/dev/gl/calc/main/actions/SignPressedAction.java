package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class SignPressedAction extends AbstractAction {

    private MainWindow mw;

    public SignPressedAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Operation operation = mw.getOperation();
        operation.stage = OperationStage.USING_OPERATORS;
        
        String operand = operation.getActiveOperand();
        if (operand == null) {
            operand = operation.operandLeft;
        }

        if (operand.equals("0")) {
            return;
        }

        StringBuilder sb = new StringBuilder(operand);
        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
        } else {
            sb.insert(0, "-");
        }

        operation.setActiveOperand(sb.toString());
        
        mw.updateTextFields();
    }
}
