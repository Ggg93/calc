package dev.gl.calc.menu;

import dev.gl.calc.Operation;
import dev.gl.calc.main.gui.MainWindow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gl
 */
public class History {

    private List<Operation> operations = new ArrayList<>();
    private MainWindow mw;

    public History(MainWindow mw) {
        this.mw = mw;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void clearHistory() {
        operations.clear();
        mw.getOperation().resetCounter();
    }

}
