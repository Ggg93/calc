package dev.gl.calc;

import dev.gl.calc.main.enums.CalculatorState;
import dev.gl.calc.main.enums.ModificationType;
import dev.gl.calc.main.enums.OperationStage;
import dev.gl.calc.main.enums.OperatorType;
import dev.gl.calc.main.gui.MainWindow;
import dev.gl.calc.main.gui.NumberFormatter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gl
 */
public class Operation implements Comparable<Operation> {

    private static final BigDecimal MAX_VALUE = new BigDecimal("9.9E9999");
    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    private static int counter = 0;
    
    public int id;
    public String operandLeft;
    public String operandRight;
    public BigDecimal result;
    public OperatorType operator;
    public List<ModificationType> operandLeftModificators = new ArrayList<>();
    public List<ModificationType> operandRightModificators = new ArrayList<>();
    public OperationStage stage;
    
    private MainWindow mw;

    public Operation(MainWindow mw) {
        this.mw = mw;

        this.stage = OperationStage.TYPING_NUMBER;
        operandLeft = "0";
    }

    public Operation(Operation operation) {
        this.operandLeft = operation.operandLeft;
        this.operandRight = operation.operandRight;
        this.operandLeftModificators = new ArrayList<>(operation.operandLeftModificators);
        this.operandRightModificators = new ArrayList<>(operation.operandRightModificators);
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
                calculationResult = left.divide(right, Configuration.operationScale, Configuration.roundingMode);
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
        mw.getHistory().getOperations().put(id, finalizedOperation);

        if (nextOperationType != null) {
            operandLeftModificators.clear();
            operandRightModificators.clear();
            operandLeft = result.toString();
            operandRight = null;
            result = null;
            operator = nextOperationType;
        }
    }

    public void performModification(ModificationType type) {
        String activeOperand = getActiveOperand();
        if (activeOperand == null) {
            activeOperand = "0";
        }

        BigDecimal operand = new BigDecimal(activeOperand);

        switch (type) {
            case MAKING_DECIMAL:
                if (operand.compareTo(BigDecimal.ZERO) == 0) {
                    mw.setCalculatorState(CalculatorState.DIVIDING_BY_ZERO);
                    return;
                }

                operand = BigDecimal.ONE.divide(operand, Configuration.operationScale, Configuration.roundingMode);
                if (isLeftOperandActive()) {
                    operandLeftModificators.add(type);
                } else {
                    operandRightModificators.add(type);
                }
                break;

            case ROOT:
                operand = operand.sqrt(MathContext.DECIMAL64);
                if (isLeftOperandActive()) {
                    operandLeftModificators.add(type);
                } else {
                    operandRightModificators.add(type);
                }
                break;

            case SQUARING:
                operand = operand.pow(2);
                if (isLeftOperandActive()) {
                    operandLeftModificators.add(type);
                } else {
                    operandRightModificators.add(type);
                }
                break;

            case PERCENT:
                if (operator == null) {
                    operand = BigDecimal.ZERO; // this is left operand
                    break;
                }

                switch (operator) {
                    case ADDITION:
                    case SUBTRACTION: {
                        if (operandRight == null) {
                            operandRight = "0";
                        }

                        BigDecimal leftOperand = new BigDecimal(operandLeft);
                        operand = new BigDecimal(getActiveOperand());
                        operand = leftOperand.multiply(operand).divide(ONE_HUNDRED);
                        break;
                    }
                    case DIVISION:
                    case MULTIPLICATION:
                        operand = new BigDecimal(getActiveOperand());
                        operand = operand.divide(ONE_HUNDRED);
                        break;
                }
        }

        // check for overflow wrong state
        if (operand.compareTo(MAX_VALUE) > 0) {
            mw.setCalculatorState(CalculatorState.OVERFLOW);
            return;
        }

        setActiveOperand(operand.toString());
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
        sb.append(id).append(Configuration.ID_DELIMETER).append(" ")
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

    private Boolean isLeftOperandActive() {
        return operator == null;
    }

    @Override
    public int compareTo(Operation o) {
        return this.id > o.id ? 1 : -1;
    }

    public void resetCounter() {
        counter = 0;
    }

}
