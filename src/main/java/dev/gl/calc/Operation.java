package dev.gl.calc;

import dev.gl.calc.enums.CalculatorState;
import dev.gl.calc.enums.OperatorType;

/**
 *
 * @author gl
 */
public class Operation {

    public Double operandLeft;
    public Double operandRight;
    public Double result;
    public OperatorType operator;
    public CalculatorState state;

    public Operation(CalculatorState state) {
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

        if (operandLeft == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder(operandLeft.toString());
        if (operator == null) {
            return sb.toString();
        }

        sb.append(" ").append(operator.getCharacter()).append(" ");

        if (operandRight == null) {
            return sb.toString();
        }

        sb.append(operandRight);

        if (result == null) {
            return sb.toString();
        }

        sb.append(" = ").append(result);
        return sb.toString();
    }

}
