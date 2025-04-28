package dev.gl.calc.main.enums;

/**
 *
 * @author gl
 */
public enum CalculatorState {
    OK(1, "0"),
    DIVIDING_BY_ZERO(2, "CANNOT DIVIDE BY ZERO"),
    DIVIDING_ZERO_BY_ZERO(3, "UNDEFINED RESULT"),
    OVERFLOW(4, "OVERFLOW");
    
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
