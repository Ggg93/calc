package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class BackspacePressedAction extends AbstractAction {

    private MainWindow mw;

    public BackspacePressedAction(MainWindow mw) {
        this.mw = mw;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Operation operation = mw.getOperation();
        String operand = operation.getActiveOperand();
        if (operand == null) {
            operand = operation.operandLeft;
        }

        StringBuilder sb = new StringBuilder(operand);

        if (sb.length() == 1) {
            sb.setLength(0);
            sb.append("0");
        } else if (sb.length() == 2 && sb.charAt(0) == '-') {
            sb.setLength(0);
            sb.append("0");
        } else if (sb.length() == 3 && sb.toString().equals("-0.")) {
            sb.setLength(0);
            sb.append("0");
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }
        operation.setActiveOperand(sb.toString());
        
        mw.updateTextFields();
    }

}
