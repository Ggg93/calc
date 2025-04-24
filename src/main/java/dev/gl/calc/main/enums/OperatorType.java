package dev.gl.calc.main.enums;

/**
 *
 * @author gl
 */
public enum OperatorType {
    ADDITION(1, "+"),
    SUBTRACTION(2, "-"),
    MULTIPLICATION(3, "x"),
    DIVISION(4, "/");

    private int code;
    private String character;

    private OperatorType(int code, String character) {
        this.code = code;
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
    
}
