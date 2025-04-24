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
public class DivisionPressedAction extends AbstractAction {

    private MainWindow mw;

    public DivisionPressedAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Operation operation = mw.getOperation();

        if (operation.operandRight == null) {
            operation.operator = OperatorType.DIVISION;
        } else {
            operation.performOperation(OperatorType.DIVISION);
        }

        mw.updateTextFields();
    }

}
