package rudidevries.simplecalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Performs basic calculations based on two integers or a
 * {@link SimpleCalculatorInputProvider} to process multiple calculations at
 * once.
 *
 */
public class SimpleCalculator {

    public double add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public double substract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public double multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public double divide(int operand1, int operand2) {
        return (double) operand1 / operand2;
    }

    /**
     * Performs multiple calculations based on the input provided.
     * 
     * @param provider
     *            Provides {@link SimpleCalculatorInput} instances to perform
     *            calculations with.
     * @return List of results in the same order as the input was provided.
     */
    public List<Double> calculate(SimpleCalculatorInputProvider provider) {
        List<Double> result = new ArrayList<Double>();

        SimpleCalculatorInput input;
        while ((input = provider.next()) != null) {
            result.add(this.calculate(input));
        }

        return result;
    }

    private double calculate(SimpleCalculatorInput input) {
        switch (input.getOperator()) {
        case '+':
            return this.add(input.getOperand1(), input.getOperand2());
        case '-':
            return this.substract(input.getOperand1(), input.getOperand2());
        case '*':
            return this.multiply(input.getOperand1(), input.getOperand2());
        case '/':
            return this.divide(input.getOperand1(), input.getOperand2());
        default:
            throw new IllegalArgumentException(String.format("Unknown operator: %s.", input.getOperator()));
        }
    }
}
