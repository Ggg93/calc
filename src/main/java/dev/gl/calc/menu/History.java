package dev.gl.calc.menu;

import dev.gl.calc.Operation;
import dev.gl.calc.main.gui.MainWindow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author gl
 */
public class History {

    // TODO: need to remove List<Operation> operations
    private List<Operation> operations = new ArrayList<>();
    private Map<Integer, Operation> operationsById = new TreeMap<>(Collections.reverseOrder());
    private MainWindow mw;

    public History(MainWindow mw) {
        this.mw = mw;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public Map<Integer, Operation> getOperationsById() {
        return operationsById;
    }
    
    public void clearHistory() {
        operations.clear();
        operationsById.clear();
        mw.getOperation().resetCounter();
    }

}
