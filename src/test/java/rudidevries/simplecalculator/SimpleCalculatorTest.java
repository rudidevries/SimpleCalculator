package rudidevries.simplecalculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class SimpleCalculatorTest {

    private static final double DOUBLE_DELTA = 0.0000000000000001;

    /**
     * Test simple additions.
     */
    @Test
    public void simpleAdditionTest() {
        SimpleCalculator calc = new SimpleCalculator();

        assertEquals(4, calc.add(2, 2), DOUBLE_DELTA);
        assertEquals(5, calc.add(2, 3), DOUBLE_DELTA);
        assertEquals(1, calc.add(-2, 3), DOUBLE_DELTA);
        assertEquals(-1, calc.add(-3, 2), DOUBLE_DELTA);
    }

    /**
     * Test simple subtractions.
     */
    @Test
    public void simpleSubtractionTest() {
        SimpleCalculator calc = new SimpleCalculator();

        assertEquals(0, calc.substract(2, 2), DOUBLE_DELTA);
        assertEquals(-1, calc.substract(2, 3), DOUBLE_DELTA);
        assertEquals(6, calc.substract(3, -3), DOUBLE_DELTA);
        assertEquals(0, calc.substract(-3, -3), DOUBLE_DELTA);
    }

    /**
     * Test simple multiplications.
     */
    @Test
    public void simpleMultiplicationTest() {
        SimpleCalculator calc = new SimpleCalculator();

        assertEquals(4, calc.multiply(2, 2), DOUBLE_DELTA);
        assertEquals(60000, calc.multiply(200, 300), DOUBLE_DELTA);
        assertEquals(-4, calc.multiply(-2, 2), DOUBLE_DELTA);
        assertEquals(4, calc.multiply(-2, -2), DOUBLE_DELTA);
    }

    /**
     * Test simple divisions.
     */
    @Test
    public void simpleDivisionTest() {
        SimpleCalculator calc = new SimpleCalculator();

        assertEquals(1, calc.divide(2, 2), DOUBLE_DELTA);
        assertEquals(0.66666666666666666, calc.divide(2, 3), DOUBLE_DELTA);
        assertEquals(-1, calc.divide(-3, 3), DOUBLE_DELTA);
        assertEquals(1, calc.divide(-3, -3), DOUBLE_DELTA);
    }

    /**
     * Test simple calculations bases on the input provider, without edge cases.
     */
    @Test
    public void simpleInputProviderTest() {
        SimpleCalculatorInputProvider provider = mock(SimpleCalculatorInputProvider.class);
        when(provider.next()).thenReturn(new SimpleCalculatorInput(2, 2, '+'), new SimpleCalculatorInput(2, 2, '/'),
                new SimpleCalculatorInput(2, 2, '*'), null);

        SimpleCalculator calc = new SimpleCalculator();
        List<Double> result = calc.calculate(provider);

        Iterator<Double> i = result.iterator();
        assertEquals(i.next(), 4, DOUBLE_DELTA);
        assertEquals(i.next(), 1, DOUBLE_DELTA);
        assertEquals(i.next(), 4, DOUBLE_DELTA);
    }

    /**
     * Test if an exception is thrown on an invalid operator input.
     */
    @Test(expected = IllegalArgumentException.class)
    public void invalidParameterTest() {
        SimpleCalculatorInputProvider provider = mock(SimpleCalculatorInputProvider.class);
        when(provider.next()).thenReturn(new SimpleCalculatorInput(2, 2, '+'), new SimpleCalculatorInput(2, 2, ','),
                new SimpleCalculatorInput(2, 2, '*'), null);

        SimpleCalculator calc = new SimpleCalculator();
        calc.calculate(provider);
    }
}
