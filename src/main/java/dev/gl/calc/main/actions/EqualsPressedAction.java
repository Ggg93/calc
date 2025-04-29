package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.CalculatorState;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class EqualsPressedAction extends AbstractAction {

    private MainWindow mw;

    public EqualsPressedAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (!mw.getEqualsButton().isEnabled()) {
            return;
        }
        
        if (mw.getCalculatorState() != CalculatorState.OK) {
            mw.getButtonActions().clearPressedAction.actionPerformed(null);
            return;
        }

        Operation operation = mw.getOperation();
        operation.stage = OperationStage.USING_OPERATORS;
        
        // repeated 'equals' entering after the initial completion of operation
        if (operation.result != null && operation.operandRight != null) {
            operation.operandLeft = String.valueOf(operation.result);
        }
        
        if (operation.result != null && operation.operandRight == null && operation.operator != null) {
            operation.operandRight = String.valueOf(operation.result);
        }

        if (operation.operandRight != null && operation.operator != null) {
            operation.performOperation(null);
        } else {
            operation.result = new BigDecimal(operation.operandLeft);
        }

        mw.getAudioPlayer().playClickSound();
        mw.updateTextFields();
    }

}
