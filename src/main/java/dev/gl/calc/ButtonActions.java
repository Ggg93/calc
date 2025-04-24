package dev.gl.calc;

import dev.gl.calc.main.actions.DecimalPressedAction;
import dev.gl.calc.main.actions.ClearPressedAction;
import dev.gl.calc.main.actions.DigitPressedAction;
import dev.gl.calc.main.actions.PlusPressedAction;
import dev.gl.calc.main.actions.ClearEntryPressedAction;
import dev.gl.calc.main.actions.BackspacePressedAction;
import dev.gl.calc.main.actions.DivisionPressedAction;
import dev.gl.calc.main.actions.MinusPressedAction;
import dev.gl.calc.main.actions.MultiplyPressedAction;
import dev.gl.calc.main.actions.SignPressedAction;
import dev.gl.calc.main.gui.MainWindow;

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

    public ButtonActions(MainWindow mw) {
        digitPressedAction = new DigitPressedAction(mw);
        backspacePressedAction = new BackspacePressedAction(mw);
        decimalPressedAction = new DecimalPressedAction(mw);
        clearEntryPressedAction = new ClearEntryPressedAction(mw);
        clearPressedAction = new ClearPressedAction(mw);
        signPressedAction = new SignPressedAction(mw);
        plusPressedAction = new PlusPressedAction(mw);
        minusPressedAction = new MinusPressedAction(mw);
        multiplyPressedAction = new MultiplyPressedAction(mw);
        divisionPressedAction = new DivisionPressedAction(mw);
    }

}
