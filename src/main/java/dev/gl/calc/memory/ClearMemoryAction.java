package dev.gl.calc.memory;

import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class ClearMemoryAction extends AbstractAction {

    private MainWindow mw;
    private Memory memory;

    public ClearMemoryAction(MainWindow mw, Memory memory) {
        this.mw = mw;
        this.memory = memory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Operation operation = mw.getOperation();
        operation.stage = OperationStage.USING_OPERATORS;
        memory.clear();
    }

}
