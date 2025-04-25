package dev.gl.calc;

import dev.gl.calc.main.enums.CalculatorState;
import dev.gl.calc.main.enums.OperatorType;
import dev.gl.calc.main.gui.MainWindow;
import dev.gl.calc.main.gui.NumberFormatter;

/**
 *
 * @author gl
 */
public class Operation {

    private MainWindow mw;
    public String operandLeft; // should be String?
    public String operandRight; // should be String?
    public Double result;
    public OperatorType operator;
    public CalculatorState state;

    public Operation(MainWindow mw) {
        this.mw = mw;
        this.state = mw.getCalculatorState();

        operandLeft = "0";
    }

    public Operation(Operation operation) {
        this.operandLeft = operation.operandLeft;
        this.operandRight = operation.operandRight;
        this.result = operation.result;
        this.operator = operation.operator;
        this.state = operation.state;
    }

    public void performOperation(OperatorType nextOperationType) {
        Double calculationResult = null;
        switch (operator) {
            case ADDITION:
                calculationResult = Double.parseDouble(operandLeft)
                        + Double.parseDouble(operandRight);
                break;
            case SUBTRACTION:
                calculationResult = Double.parseDouble(operandLeft)
                        - Double.parseDouble(operandRight);
                break;
            case MULTIPLICATION:
                calculationResult = Double.parseDouble(operandLeft)
                        * Double.parseDouble(operandRight);
                break;
            case DIVISION:
                calculationResult = Double.parseDouble(operandLeft)
                        / Double.parseDouble(operandRight);
                break;
        }
        result = calculationResult;
        Operation finalizedOperation = new Operation(this);
        mw.getHistory().getOperations().add(finalizedOperation);

        if (nextOperationType != null) {
            operandLeft = result.toString();
            operandRight = null;
            result = null;
            operator = nextOperationType;
        }

    }

    @Override
    public String toString() {
        if (state != CalculatorState.OK) {
            return state.getMessage();
        }

        String showedOperandLeft = NumberFormatter.convertDoubleToIntegerIfNoDecimalPart(operandLeft);
        String showedOperandRight = operandRight != null
                ? showedOperandRight = NumberFormatter.convertDoubleToIntegerIfNoDecimalPart(operandRight)
                : null;

        if (operator == null) {
            return result == null ? "" : showedOperandLeft + " = ";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(showedOperandLeft);
        sb.append(" ");
        sb.append(operator.getCharacter());
        sb.append(" ");

        if (result == null) {
            return sb.toString();
        }

        sb.append(showedOperandRight);
        sb.append(" = ");
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
