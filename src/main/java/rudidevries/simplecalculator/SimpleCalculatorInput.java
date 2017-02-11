package rudidevries.simplecalculator;

public class SimpleCalculatorInput {
    private final int operand1;

    private final int operand2;

    private final char operator;

    /**
     * Input that can be used during simple calculation.
     * 
     * @param operand1
     *            the first operand
     * @param operand2
     *            the second operand
     * @param operator
     *            the operator ('+', '-', '*' or '/')
     */
    public SimpleCalculatorInput(int operand1, int operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public int getOperand1() {
        return this.operand1;
    }

    public int getOperand2() {
        return this.operand2;
    }

    public char getOperator() {
        return this.operator;
    }

}
