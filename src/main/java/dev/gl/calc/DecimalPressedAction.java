package dev.gl.calc;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class DecimalPressedAction extends AbstractAction {
    
    private JTextField resultTextField;
    
    public DecimalPressedAction(JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String currentText = resultTextField.getText();
        if (currentText.contains(".")) {
            return;
        }
        
        StringBuilder sb = new StringBuilder(currentText);
        sb.append(".");
        resultTextField.setText(sb.toString());
    }
    
}
