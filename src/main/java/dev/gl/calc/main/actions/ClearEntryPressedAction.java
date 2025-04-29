package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.CalculatorState;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class ClearEntryPressedAction extends AbstractAction {

    private MainWindow mw;

    public ClearEntryPressedAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        mw.getOperation().stage = OperationStage.TYPING_NUMBER;
        
        if (mw.getCalculatorState() != CalculatorState.OK) {
            mw.getButtonActions().clearPressedAction.actionPerformed(null);
            return;
        }
        
        Operation operation = mw.getOperation();
        if (operation.result == null) {
            mw.getOperation().setActiveOperand("0");
            
            mw.getAudioPlayer().playClickSound();
            mw.updateTextFields();
        } else {
            mw.getButtonActions().clearPressedAction.actionPerformed(e);
        }
    }

}
