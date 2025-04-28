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
public class PlusPressedAction extends AbstractAction {

    private MainWindow mw;

    public PlusPressedAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Operation operation = mw.getOperation();
        operation.stage = OperationStage.USING_OPERATORS;

        if (operation.operandRight == null) {
            operation.operator = OperatorType.ADDITION;
        } else {
            operation.performOperation(OperatorType.ADDITION);
        }

        mw.updateTextFields();
    }

}
