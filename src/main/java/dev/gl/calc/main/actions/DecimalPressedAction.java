package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class DecimalPressedAction extends AbstractAction {
    
    private MainWindow mw;

    public DecimalPressedAction(MainWindow mw) {
        this.mw = mw;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Operation operation = mw.getOperation();
        String operand = operation.getActiveOperand();
        if (operand == null) {
            operand = operation.operandLeft;
        }
        
        if (operand.contains(".")) {
            return;
        }
        
        StringBuilder sb = new StringBuilder(operand);
        sb.append(".");
        operation.setActiveOperand(sb.toString());
        
        mw.updateTextFields();
    }
    
}
