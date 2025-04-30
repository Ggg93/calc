package dev.gl.calc.main.actions;

import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.ModificationType;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class RootAction extends AbstractAction {

    private MainWindow mw;

    public RootAction(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Operation operation = mw.getOperation();
        operation.stage = OperationStage.USING_OPERATORS;

        operation.performModification(ModificationType.ROOT);
        
        mw.getAudioPlayer().playClickSound();
        mw.updateTextFields();
    }
}
