package dev.gl.calc;

import dev.gl.calc.main.enums.CalculatorState;
import dev.gl.calc.main.enums.OperatorType;
import dev.gl.calc.main.gui.MainWindow;
import dev.gl.calc.main.gui.NumberFormatter;
import java.math.BigDecimal;

/**
 *
 * @author gl
 */
public class Operation {

    private MainWindow mw;
    public String operandLeft; // should be String?
    public String operandRight; // should be String?
    public BigDecimal result;
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
        BigDecimal calculationResult = null;
        if (operator == null) {
            operator = nextOperationType;
        }
        
        switch (operator) {
            case ADDITION:
                calculationResult = new BigDecimal(operandLeft)
                        .add(new BigDecimal(operandRight));
                break;
            case SUBTRACTION:
                calculationResult = new BigDecimal(operandLeft)
                        .subtract(new BigDecimal(operandRight));
                break;
            case MULTIPLICATION:
                calculationResult = new BigDecimal(operandLeft)
                        .multiply(new BigDecimal(operandRight));
                break;
            case DIVISION:
                calculationResult = new BigDecimal(operandLeft)
                        .divide(new BigDecimal(operandRight));
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

        String showedOperandLeft = NumberFormatter.format(operandLeft);
        String showedOperandRight = operandRight != null
                ? showedOperandRight = NumberFormatter.format(operandRight)
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
