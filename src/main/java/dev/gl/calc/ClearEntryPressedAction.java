package dev.gl.calc;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class ClearEntryPressedAction extends AbstractAction {

    private JTextField resultTextField;

    public ClearEntryPressedAction(JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resultTextField.setText("0");
    }

}
