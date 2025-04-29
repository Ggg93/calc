package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.enums.OperatorType;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class MultiplyPressedAction extends AbstractAction {

    private MainWindow mw;

    public MultiplyPressedAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Operation operation = mw.getOperation();
        operation.stage = OperationStage.USING_OPERATORS;

        if (operation.operandRight == null) {
            operation.operator = OperatorType.MULTIPLICATION;
        } else {
            operation.performOperation(OperatorType.MULTIPLICATION);
        }

        mw.getAudioPlayer().playClickSound();
        mw.updateTextFields();
    }

}
