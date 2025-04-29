package dev.gl.calc.main.actions;

import dev.gl.calc.Configuration;
import dev.gl.calc.main.gui.MainWindow;
import dev.gl.calc.main.gui.SettingsDialog;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class SettingsOkButtonAction extends AbstractAction {

    private SettingsDialog parent;
    private MainWindow mw;

    public SettingsOkButtonAction(SettingsDialog parent, MainWindow mw) {
        this.parent = parent;
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Configuration.operationScale = parent.getScale();
        Configuration.roundingMode = parent.getRoundingMode();

        // changing sorting order for the shistory of operations
        Configuration.sortingOrder = parent.getSortingOrder();
        mw.getHistory().changeSortingOrderIfNecessary();

        // closing parent
        parent.dispose();
    }

}
