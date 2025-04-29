package dev.gl.calc;

import dev.gl.calc.main.actions.DecimalPressedAction;
import dev.gl.calc.main.actions.ClearPressedAction;
import dev.gl.calc.main.actions.DigitPressedAction;
import dev.gl.calc.main.actions.PlusPressedAction;
import dev.gl.calc.main.actions.ClearEntryPressedAction;
import dev.gl.calc.main.actions.BackspacePressedAction;
import dev.gl.calc.main.actions.DivisionPressedAction;
import dev.gl.calc.main.actions.EqualsPressedAction;
import dev.gl.calc.main.actions.MinusPressedAction;
import dev.gl.calc.main.actions.MultiplyPressedAction;
import dev.gl.calc.main.actions.SignPressedAction;
import dev.gl.calc.main.gui.MainWindow;
import dev.gl.calc.memory.AddMemoryAction;
import dev.gl.calc.memory.ClearMemoryAction;
import dev.gl.calc.memory.Memory;
import dev.gl.calc.memory.RecallMemoryAction;
import dev.gl.calc.memory.SubtractMemoryAction;
import dev.gl.calc.menu.HistoryButtonAction;

/**
 *
 * @author gl
 */
public class ButtonActions {

    public DigitPressedAction digitPressedAction;
    public BackspacePressedAction backspacePressedAction;
    public DecimalPressedAction decimalPressedAction;
    public ClearEntryPressedAction clearEntryPressedAction;
    public ClearPressedAction clearPressedAction;
    public SignPressedAction signPressedAction;
    public PlusPressedAction plusPressedAction;
    public MinusPressedAction minusPressedAction;
    public MultiplyPressedAction multiplyPressedAction;
    public DivisionPressedAction divisionPressedAction;
    public EqualsPressedAction equalsPressedAction;

    // memory actions
    public AddMemoryAction addMemoryAction;
    public SubtractMemoryAction subtractMemoryAction;
    public RecallMemoryAction recallMemoryAction;
    public ClearMemoryAction clearMemoryAction;
    
    // other
    public HistoryButtonAction historyButtonAction;

    public ButtonActions(MainWindow mw, int lengthLimit, Memory memory) {
        digitPressedAction = new DigitPressedAction(mw, lengthLimit);
        backspacePressedAction = new BackspacePressedAction(mw);
        decimalPressedAction = new DecimalPressedAction(mw);
        clearEntryPressedAction = new ClearEntryPressedAction(mw);
        clearPressedAction = new ClearPressedAction(mw);
        signPressedAction = new SignPressedAction(mw);
        plusPressedAction = new PlusPressedAction(mw);
        minusPressedAction = new MinusPressedAction(mw);
        multiplyPressedAction = new MultiplyPressedAction(mw);
        divisionPressedAction = new DivisionPressedAction(mw);
        equalsPressedAction = new EqualsPressedAction(mw);
        
        // memory actions
        addMemoryAction = new AddMemoryAction(mw, memory);
        subtractMemoryAction = new SubtractMemoryAction(mw, memory);
        recallMemoryAction = new RecallMemoryAction(mw, memory);
        clearMemoryAction = new ClearMemoryAction(mw, memory);
        
        // other
        historyButtonAction = new HistoryButtonAction(mw);
    }

}
