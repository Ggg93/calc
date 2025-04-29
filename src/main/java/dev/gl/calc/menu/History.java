package dev.gl.calc.menu;

import dev.gl.calc.Operation;
import dev.gl.calc.main.gui.MainWindow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author gl
 */
public class History {

    private Map<Integer, Operation> operationsById = new TreeMap<>(Collections.reverseOrder());
    private MainWindow mw;

    public History(MainWindow mw) {
        this.mw = mw;
    }

    public Map<Integer, Operation> getOperations() {
        return operationsById;
    }
    
    public void clearHistory() {
        operationsById.clear();
        mw.getOperation().resetCounter();
    }

}
