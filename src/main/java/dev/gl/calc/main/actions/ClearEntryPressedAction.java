package dev.gl.calc.main.actions;

import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class ClearEntryPressedAction extends AbstractAction {

    private MainWindow mw;

    public ClearEntryPressedAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mw.getOperation().setActiveOperand("0");
        mw.updateTextFields();
    }
    
}
