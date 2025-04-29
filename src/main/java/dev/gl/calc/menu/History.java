package dev.gl.calc.menu;

import dev.gl.calc.Configuration;
import dev.gl.calc.Operation;
import dev.gl.calc.main.enums.HistorySortingOrder;
import dev.gl.calc.main.gui.MainWindow;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author gl
 */
public class History {

    private Map<Integer, Operation> operationsById;
    private HistorySortingOrder actualSortingOrder;
    private MainWindow mw;

    public History(MainWindow mw) {
        actualSortingOrder = Configuration.sortingOrder;
        
        switch (actualSortingOrder) {
            case FIRST_TO_LAST:
                operationsById = new TreeMap<>();
                break;
            case LAST_TO_FIRST:
                operationsById = new TreeMap<>(Collections.reverseOrder());
                break;
        }

        this.mw = mw;
    }

    public Map<Integer, Operation> getOperations() {
        return operationsById;
    }

    public void clearHistory() {
        operationsById.clear();
        mw.getOperation().resetCounter();
    }
    
    public void changeSortingOrderIfNecessary() {
        if (Configuration.sortingOrder == actualSortingOrder) {
            return;
        }
        
        if (Configuration.sortingOrder == HistorySortingOrder.FIRST_TO_LAST) {
            Map<Integer, Operation> substitutionMap = new TreeMap<>(this.operationsById);
            operationsById.clear();
            operationsById = substitutionMap;
            actualSortingOrder = HistorySortingOrder.FIRST_TO_LAST;
        } else {
            Map<Integer, Operation> substitutionMap = new TreeMap<>(Collections.reverseOrder());
            substitutionMap.putAll(operationsById);
            operationsById.clear();
            operationsById = substitutionMap;
            actualSortingOrder = HistorySortingOrder.LAST_TO_FIRST;
        }
    }

}
