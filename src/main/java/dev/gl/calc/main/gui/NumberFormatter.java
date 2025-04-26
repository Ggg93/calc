package dev.gl.calc.main.gui;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author gl
 */
public class NumberFormatter {

    private static final DecimalFormat DEFAULT_FORMATTER;
    private static final DecimalFormat SCIENTIFIC_FORMATTER;

    static {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(Locale.US);
        symbols.setGroupingSeparator(' ');
        DEFAULT_FORMATTER = new DecimalFormat("#,###.##############", symbols);
        SCIENTIFIC_FORMATTER = new DecimalFormat("0.##########E0###");
    }

    public static String format(String doubleVal) {

        // check for (1) last char is '.' and calculate amount of tralinig zeros
        boolean isTheLastCharacterADot = doubleVal.charAt(doubleVal.length() - 1) == '.';
        int trailingZeros = 0;
        if (!isTheLastCharacterADot && doubleVal.contains(".")) {
            char c = '0';
            int idx = doubleVal.length() - 1;
            while (c == '0') {
                c = doubleVal.charAt(idx--);
                if (c == '0') {
                    trailingZeros++;
                }
            }
        }

        String formatted = DEFAULT_FORMATTER.format(new BigDecimal(doubleVal));

        StringBuilder sb = new StringBuilder(formatted);
        if (isTheLastCharacterADot) {
            sb.append(".");
        } else if (trailingZeros > 0) {
            // avoid adding second delimeter
            if (sb.indexOf(".") == -1) {
                sb.append(".");
            }
            while (trailingZeros-- > 0) {
                sb.append("0");
            }
        }

        // if the number is too small, than apply another formatter
        if (sb.toString().equals("0") && !doubleVal.equals("0")) {
            formatted = SCIENTIFIC_FORMATTER.format(new BigDecimal(doubleVal));
            sb = new StringBuilder(formatted);
        } else {
            // if value is more then lengthLimit (see MainWindow.OPERAND_LENGTH_LIMIT),
            // show it in scientific notation
            String preparedString = sb.toString().replaceAll(" ", "");
            preparedString = preparedString.replaceAll(",", "."); // in case for not US locales
            if (preparedString.length() > MainWindow.OPERAND_LENGTH_LIMIT) {
                String exponentialOutput = SCIENTIFIC_FORMATTER.format(new BigDecimal(preparedString));
                sb = new StringBuilder(exponentialOutput);
            }

        }

        return String.valueOf(sb.toString());

    }
}
