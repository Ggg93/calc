package dev.gl.calc.menu;

import dev.gl.calc.main.gui.AboutDialog;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

/**
 *
 * @author gl
 */
public class AboutButtonActionListener implements ActionListener {
    
    private MainWindow mw;

    public AboutButtonActionListener(MainWindow mw) {
        this.mw = mw;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog aboutDialog = new AboutDialog(mw, true);
        aboutDialog.setVisible(true);
    }
    
}
