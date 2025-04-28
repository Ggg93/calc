package dev.gl.calc.main.gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author gl
 */
public class LimitedLengthDocumentFilter extends DocumentFilter {

    private int lengthLimit;
    private boolean ignoreLimit = false;

    public LimitedLengthDocumentFilter(int lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    public void ignoreLengthLimitForNextOperation() {
        ignoreLimit = true;
    }

    private boolean isEnoughSpace(String text) {
        if (ignoreLimit) {
            ignoreLimit = false;
            return true;
        }

        return text.replaceAll("\\D", "").length() <= lengthLimit;
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
        if (isEnoughSpace(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
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
