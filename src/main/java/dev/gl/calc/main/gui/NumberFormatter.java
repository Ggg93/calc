package dev.gl.calc.main.gui;

/**
 *
 * @author gl
 */
public class NumberFormatter {
    public static String convertDoubleToIntegerIfNoDecimalPart(String doubleVal) {
        // case when user started to write decimal number
        if (doubleVal.charAt(doubleVal.length() - 1) == '.') return doubleVal;
        
        // all other cases
        return Double.parseDouble(doubleVal) % 1 == 0
                ? String.valueOf(((Double) Double.parseDouble(doubleVal)).longValue())
                : String.valueOf(Double.parseDouble(doubleVal));
    }
}
