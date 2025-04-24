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

    public DigitPressedAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        Integer pressedDigit = Integer.valueOf(e.getActionCommand());
        String pressedDigit = e.getActionCommand();
        String operand = mw.getOperation().getActiveOperand();

        if (operand == null || operand.equals("0")) {
            mw.getOperation().setActiveOperand(pressedDigit);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(operand);
            sb.append(pressedDigit);
            mw.getOperation().setActiveOperand(sb.toString());
        }

        mw.updateTextFields();
    }
}
