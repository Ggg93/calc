package dev.gl.calc;

import dev.gl.calc.main.enums.CalculatorState;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.enums.OperatorType;
import dev.gl.calc.main.gui.MainWindow;
import dev.gl.calc.main.gui.NumberFormatter;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author gl
 */
public class Operation implements Comparable<Operation>{

    public static final String ID_DELIMETER = ":";
    private static int counter = 0;
    private static final BigDecimal MAX_VALUE = new BigDecimal("9.9E9999");
    private MainWindow mw;
    public int id;
    public String operandLeft; // should be String?
    public String operandRight; // should be String?
    public BigDecimal result;
    public OperatorType operator;
    public OperationStage stage;

    public Operation(MainWindow mw) {
        this.mw = mw;

        this.stage = OperationStage.TYPING_NUMBER;
        operandLeft = "0";
    }

    public Operation(Operation operation) {
        this.operandLeft = operation.operandLeft;
        this.operandRight = operation.operandRight;
        this.result = operation.result;
        this.operator = operation.operator;
        this.id = operation.id;
    }

    public void performOperation(OperatorType nextOperationType) {
        BigDecimal calculationResult = null;
        if (operator == null) {
            operator = nextOperationType;
        }

        BigDecimal left = new BigDecimal(operandLeft);
        BigDecimal right = new BigDecimal(operandRight);

        switch (operator) {
            case ADDITION:
                calculationResult = left.add(right);
                break;
            case SUBTRACTION:
                calculationResult = left.subtract(right);
                break;
            case MULTIPLICATION:
                calculationResult = left.multiply(right);
                break;
            case DIVISION:
                if (left.compareTo(BigDecimal.ZERO) == 0
                        && right.compareTo(BigDecimal.ZERO) == 0) {
                    mw.setCalculatorState(CalculatorState.DIVIDING_ZERO_BY_ZERO);
                    return;
                } else if (right.compareTo(BigDecimal.ZERO) == 0) {
                    mw.setCalculatorState(CalculatorState.DIVIDING_BY_ZERO);
                    return;
                }
                calculationResult = left.divide(right, 10, RoundingMode.HALF_UP);
                break;
        }

        // check for overflow wrong state
        if (calculationResult.compareTo(MAX_VALUE) > 0) {
            mw.setCalculatorState(CalculatorState.OVERFLOW);
            return;
        }

        result = calculationResult;
        id = ++counter;
        Operation finalizedOperation = new Operation(this);
//        mw.getHistory().getOperations().add(finalizedOperation);
        mw.getHistory().getOperations().put(id, finalizedOperation);

        if (nextOperationType != null) {
            operandLeft = result.toString();
            operandRight = null;
            result = null;
            operator = nextOperationType;
        }

    }

    @Override
    public String toString() {

        String showedOperandLeft = NumberFormatter.format(operandLeft, OperationStage.USING_OPERATORS);
        String showedOperandRight = operandRight != null
                ? showedOperandRight = NumberFormatter.format(operandRight, OperationStage.USING_OPERATORS)
                : null;

        if (operator == null) {
            return result == null ? "" : showedOperandLeft + " = ";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(showedOperandLeft);
        sb.append(" ");
        sb.append(operator.getCharacter());
        sb.append(" ");

        if (result == null || operandRight == null) {
            return sb.toString();
        }

        sb.append(showedOperandRight);
        sb.append(" = ");
        return sb.toString();
    }
    
    public String printForHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(ID_DELIMETER).append(" ")
                .append(NumberFormatter.format(operandLeft, OperationStage.USING_OPERATORS)).append(" ")
                .append(operator.getCharacter()).append(" ")
                .append(NumberFormatter.format(operandRight, OperationStage.USING_OPERATORS)).append(" = ")
                .append(NumberFormatter.format(result.toString(), OperationStage.USING_OPERATORS));
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

    @Override
    public int compareTo(Operation o) {
        return this.id > o.id ? 1 : -1;
    }
    
    public void resetCounter() {
        counter = 0;
    }

}
