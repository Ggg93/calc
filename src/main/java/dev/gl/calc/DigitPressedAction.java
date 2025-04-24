package dev.gl.calc;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class DigitPressedAction extends AbstractAction {

    private JTextField resultTextField;

    public DigitPressedAction(JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numberAsString = e.getActionCommand();
        String currentResultString = resultTextField.getText();
        
        if (currentResultString.equals("0")) {
            resultTextField.setText(numberAsString);
        } else {
            resultTextField.setText(currentResultString + numberAsString);
        }
    }

}
