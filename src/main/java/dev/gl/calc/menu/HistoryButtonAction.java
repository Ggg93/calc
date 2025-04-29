package dev.gl.calc.menu;

import dev.gl.calc.main.gui.HistoryDialog;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;

/**
 *
 * @author gl
 */
public class HistoryButtonAction extends AbstractAction {

    private MainWindow mw;

    public HistoryButtonAction(MainWindow mw) {
        this.mw = mw;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog historyDialog = new HistoryDialog(mw, true);
        historyDialog.setVisible(true);
    }
    
}
