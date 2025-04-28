package dev.gl.calc.memory;

import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class RecallMemoryAction extends AbstractAction {

    private MainWindow mw;
    private Memory memory;

    public RecallMemoryAction(MainWindow mw, Memory memory) {
        this.mw = mw;
        this.memory = memory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Operation operation = mw.getOperation();
        operation.stage = OperationStage.USING_OPERATORS;
        BigDecimal operand = new BigDecimal(operation.getActiveOperand());
        
        operation.setActiveOperand(memory.recall().toString());
        mw.updateTextFields();
        
    }

}
