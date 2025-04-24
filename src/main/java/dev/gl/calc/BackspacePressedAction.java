package dev.gl.calc;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class BackspacePressedAction extends AbstractAction {

    private JTextField resultTextField;

    public BackspacePressedAction(JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (resultTextField.getText().isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder(resultTextField.getText());

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
        resultTextField.setText(sb.toString());
    }

}
