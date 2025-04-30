package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.CalculatorState;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class ClearPressedAction extends AbstractAction {

    private MainWindow mw;

    public ClearPressedAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent ignored) {
        
        mw.getOperation().stage = OperationStage.TYPING_NUMBER;
        
        if (mw.getCalculatorState() != CalculatorState.OK) {
            mw.setCalculatorState(CalculatorState.OK);
        }
        Operation operation = mw.getOperation();
        operation.operandLeft = null;
        operation.operator = null;
        operation.operandRight = null;
        operation.result = null;
        operation.initialValueOperandLeft = null;
        operation.initialValueOperandRight = null;
        operation.operandLeftModificators = new ArrayList<>();
        operation.operandRightModificators = new ArrayList<>();
        
        operation.setActiveOperand("0");
        
        mw.getAudioPlayer().playClickSound();
        mw.updateTextFields();
    }

}
