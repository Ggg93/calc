package dev.gl.calc;

import dev.gl.calc.main.enums.CalculatorState;
import dev.gl.calc.main.enums.OperatorType;

/**
 *
 * @author gl
 */
public class Operation {

    public String operandLeft; // should be String?
    public String operandRight; // should be String?
    public Double result;
    public OperatorType operator;
    public CalculatorState state;

    public Operation(CalculatorState state) {
        operandLeft = "0";
        this.state = state;
    }

    public Operation(Operation operation) {
        this.operandLeft = operation.operandLeft;
        this.operandRight = operation.operandRight;
        this.result = operation.result;
        this.operator = operation.operator;
        this.state = operation.state;
    }

    @Override
    public String toString() {
        if (state != CalculatorState.OK) {
            return state.getMessage();
        }

        if (operator == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(operandLeft);
        sb.append(" ");
        sb.append(operator.getCharacter());
        sb.append(" ");
        
        if (result == null) {
            return sb.toString();
        }

        sb.append(operandRight);
        sb.append(" = ").append(result);
        return sb.toString();
    }

    public String getActiveOperand() {
        return operator != null ? operandRight : operandLeft;
    }

    public void setActiveOperand(String newValue) {
        if (operator != null) {
            operandRight = newValue;
        } else {
            operandLeft = newValue;
        }
    }

}
