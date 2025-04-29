package dev.gl.calc.menu;

import dev.gl.calc.main.gui.HistoryDialog;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JDialog;

/**
 *
 * @author gl
 */
public class HistoryButtonActionListener implements MouseListener {

    private MainWindow mw;

    public HistoryButtonActionListener(MainWindow mw) {
        this.mw = mw;
    }
    

    @Override
    public void mouseClicked(MouseEvent noNeed) {
        mw.getButtonActions().historyButtonAction.actionPerformed(null);
    }

    @Override
    public void mousePressed(MouseEvent ignored) {
    }

    @Override
    public void mouseReleased(MouseEvent ignored) {
    }

    @Override
    public void mouseEntered(MouseEvent ignored) {
    }

    @Override
    public void mouseExited(MouseEvent ignored) {
    }
    
}
