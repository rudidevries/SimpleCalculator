package rudidevries.simplecalculator;

public interface SimpleCalculatorInputProvider {
    /**
     * Returns the next input from the provider.
     * 
     * @return the next input from the provider,
      * or null if the end is reached.
     */
    SimpleCalculatorInput next();

}
