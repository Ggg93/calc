package dev.gl.calc.main.actions;

import dev.gl.calc.Configuration;
import dev.gl.calc.main.gui.SettingsDialog;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class SettingsOkButtonAction extends AbstractAction {

    private SettingsDialog parent;

    public SettingsOkButtonAction(SettingsDialog parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Configuration.operationScale = parent.getScale();
        Configuration.roundingMode = parent.getRoundingMode();

        // closing parent
        parent.dispose();
    }

}
