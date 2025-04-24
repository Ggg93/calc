package dev.gl.calc.main.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class ClearPressedAction extends AbstractAction {

    private JTextField resultTextField;

    public ClearPressedAction(JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resultTextField.setText("0");
    }

}
