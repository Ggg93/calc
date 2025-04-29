package dev.gl.calc;

import dev.gl.calc.main.enums.HistorySortingOrder;
import java.math.RoundingMode;

/**
 *
 * @author gl
 */
public class Configuration {
    public static Integer operationScale = 10;
    public static RoundingMode roundingMode = RoundingMode.HALF_UP;
    public static HistorySortingOrder sortingOrder = HistorySortingOrder.LAST_TO_FIRST;
    public static Boolean blockEqualsIfWrongStateOccured = false;
}
