package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
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
        Operation operation = mw.getOperation();
        operation.operandLeft = "0";
        operation.operator = null;
        operation.operandRight = null;
        operation.result = null;
        
        mw.updateTextFields();
    }

}
