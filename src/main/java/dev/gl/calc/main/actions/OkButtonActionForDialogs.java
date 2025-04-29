package dev.gl.calc.main.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;

/**
 *
 * @author gl
 */
public class OkButtonActionForDialogs extends AbstractAction {
    
    private JDialog parent;

    public OkButtonActionForDialogs(JDialog parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.dispose();
    }

}
