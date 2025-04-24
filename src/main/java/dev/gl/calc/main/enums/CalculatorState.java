package dev.gl.calc.main.enums;

/**
 *
 * @author gl
 */
public enum CalculatorState {
    OK(1, "OK"),
    DIVIDING_BY_ZERO(2, "CANNOT DIVIDE BY ZERO");
    
    private int code;
    private String message;

    private CalculatorState(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
}
