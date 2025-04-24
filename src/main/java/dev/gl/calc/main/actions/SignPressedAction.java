package dev.gl.calc.main.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class SignPressedAction extends AbstractAction {

    private JTextField resultTextField;

    public SignPressedAction(JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (resultTextField.getText().equals("0")) {
            return;
        }

        StringBuilder sb = new StringBuilder(resultTextField.getText());
        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
        } else {
            sb.insert(0, "-");
        }

        resultTextField.setText(sb.toString());
    }
}
