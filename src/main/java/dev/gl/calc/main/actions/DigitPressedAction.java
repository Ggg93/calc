package dev.gl.calc.main.actions;

import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class DigitPressedAction extends AbstractAction {

    private MainWindow mw;
    private int lengthLimit;

    public DigitPressedAction(MainWindow mw, int lengthLimit) {
        this.mw = mw;
        this.lengthLimit = lengthLimit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pressedDigit = e.getActionCommand();
        // clearing operation and start again from scratch if the previous operation ended by entering 'equals'
        if (mw.getOperation().result != null && mw.getOperation().operandRight != null) {
            mw.getButtonActions().clearPressedAction.actionPerformed(null);
        }

        String operand = mw.getOperation().getActiveOperand();

        if (operand == null || operand.equals("0")) {
            mw.getOperation().setActiveOperand(pressedDigit);
            if (mw.getOperation().result != null) {
                mw.getOperation().result = null;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(operand);
            if (sb.length() < lengthLimit) {
                sb.append(pressedDigit);
            }
            mw.getOperation().setActiveOperand(sb.toString());
        }

        mw.updateTextFields();
    }
}
