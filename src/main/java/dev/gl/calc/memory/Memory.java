package dev.gl.calc.memory;

import dev.gl.calc.main.gui.MainWindow;
import java.math.BigDecimal;

/**
 *
 * @author gl
 */
public class Memory {
    private BigDecimal value;
    private MainWindow mw;

    public Memory(MainWindow mw) {
        this.mw = mw;
    }
    
    public BigDecimal getValue() {
        return value;
    }
    
    public void addToMemory(BigDecimal addedValue) {
        if (value == null) {
            value = BigDecimal.ZERO;
        }
        
        value = value.add(addedValue);
        mw.changeStateForMemoryButtons(true);
    }
    
    public void subtractFromMemory(BigDecimal subtractedValue) {
        if (value == null) {
            value = BigDecimal.ZERO;
        }
        
        value = value.subtract(subtractedValue);
        mw.changeStateForMemoryButtons(true);
    }
    
    public BigDecimal recall() {
        return value;
    }
    
    public void clear() {
        value = null;
        mw.changeStateForMemoryButtons(false);
    }

    
}
