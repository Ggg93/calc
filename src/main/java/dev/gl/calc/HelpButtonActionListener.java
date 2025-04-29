package dev.gl.calc;

import dev.gl.calc.main.gui.HelpDialog;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

/**
 *
 * @author gl
 */
public class HelpButtonActionListener implements ActionListener {

    private MainWindow mw;

    public HelpButtonActionListener(MainWindow mw) {
        this.mw = mw;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog helpDialog = new HelpDialog(mw, true);
        helpDialog.setVisible(true);
    }
    
}
