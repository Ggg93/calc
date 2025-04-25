package dev.gl.calc.main.gui;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author gl
 */
public class LimitedLengthDocumentFilter extends DocumentFilter {
    private static final DecimalFormat DEFAULT_FORMATTER;
    private static final DecimalFormat SCIENTIFIC_FORMATTER;
    private int lengthLimit;
    
    static {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        DEFAULT_FORMATTER = new DecimalFormat("###,###.########", symbols);
        SCIENTIFIC_FORMATTER = new DecimalFormat("0.###E0");
    }
    
    public LimitedLengthDocumentFilter(int lengthLimit) {
        this.lengthLimit = lengthLimit;
    }
    
    private boolean isEnoughSpace(String text) {
        return text.replaceAll(" ", "").length() <= lengthLimit;
    }
    
    @Override
    public void insertString(FilterBypass fb, int offset, String string,
            AttributeSet attr) throws BadLocationException {
        
        Document doc = fb.getDocument();
        String oldText = doc.getText(0, doc.getLength());
        StringBuilder sb = new StringBuilder(oldText);
        sb.insert(offset, string);
        
        if (isEnoughSpace(sb.toString())) {
            super.insertString(fb, offset, string, attr);
        }
        
    }
    
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        Document doc = fb.getDocument();
        String oldText = doc.getText(0, doc.getLength());
        StringBuilder sb = new StringBuilder(oldText);
        
        sb.replace(offset, offset + length, text);
        String copy = sb.toString(); // needed in case to apply another formatter
        boolean isTheLastCharacterADot = sb.charAt(sb.length() - 1) == '.';
        String formatted = DEFAULT_FORMATTER.format(Double.parseDouble(sb.toString()));
        sb = new StringBuilder(formatted);
        
        if (isTheLastCharacterADot) {
            sb.append(".");
        }
        
        // if the number is too small, than apply another formatter
        if (sb.toString().equals("0") && !copy.toString().equals("0")) {
            formatted = SCIENTIFIC_FORMATTER.format(Double.parseDouble(copy.toString()));
            sb = new StringBuilder(formatted);
        }
        
        if (isEnoughSpace(sb.toString())) {
            super.replace(fb, offset, length, sb.toString(), attrs);
//            super.replace(fb, offset, length, text, attrs);
        } else {
            // if value is more then lengthLimit (see MainWindow.OPERAND_LENGTH_LIMIT),
            // show it in scientific notation
            String preparedString = sb.toString().replaceAll(" ", "");
            preparedString = preparedString.replaceAll(",", ".");
            String exponentialOutput = SCIENTIFIC_FORMATTER.format(Double.parseDouble(preparedString));
            super.replace(fb, offset, length, exponentialOutput, attrs);
        }
    }
    
    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        Document doc = fb.getDocument();
        String oldText = doc.getText(0, doc.getLength());
        StringBuilder sb = new StringBuilder(oldText);
        
        sb.replace(offset, offset + length, "");
        
        if (isEnoughSpace(sb.toString())) {
            super.remove(fb, offset, length);            
        }
    }
    
}
