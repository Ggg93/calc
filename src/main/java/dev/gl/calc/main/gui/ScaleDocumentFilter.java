package dev.gl.calc.main.gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author gl
 */
public class ScaleDocumentFilter extends DocumentFilter {

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        Document doc = fb.getDocument();
        String oldText = doc.getText(0, doc.getLength());
        StringBuilder sb = new StringBuilder(oldText);

        sb.replace(offset, offset + length, text);
        try {
            Integer value = Integer.parseInt(sb.toString());
            if (value >= 0 && value <= 10) {
                super.replace(fb, offset, length, text, attrs);
            }
        } catch (Exception ignored) {
        }
    }
}
