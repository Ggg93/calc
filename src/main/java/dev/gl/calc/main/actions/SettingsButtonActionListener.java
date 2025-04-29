package dev.gl.calc.main.actions;

import dev.gl.calc.main.gui.MainWindow;
import dev.gl.calc.main.gui.SettingsDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

/**
 *
 * @author gl
 */
public class SettingsButtonActionListener implements ActionListener {

    private MainWindow mw;

    public SettingsButtonActionListener(MainWindow mw) {
        this.mw = mw;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog settingsDialog = new SettingsDialog(mw, true);
        settingsDialog.setVisible(true);
    }
    
}
