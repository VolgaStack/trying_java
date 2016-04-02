package Calculator.Tests;

import Calculator.Calculator;

import static org.junit.Assert.assertEquals;

/**
 * Тестируем калькулятор
 */
public class CalculatorTest {
    private Calculator calc;

    @org.junit.Before
    public void setUp() throws Exception {
        this.calc = new Calculator();
    }

    @org.junit.Test
    public void add() throws Exception {
        calc.calculate(1, 1, "+");
        assertEquals(2, calc.getLastResult(), 0);

    }

    @org.junit.Test
    public void sub() throws Exception {
        calc.calculate(1, 1, "-");
        assertEquals(0, calc.getLastResult(), 0);
    }

    @org.junit.Test
    public void mult() throws Exception {
        calc.calculate(1, 3, "*");
        assertEquals(3, calc.getLastResult(), 0);
    }

    @org.junit.Test
    public void div() throws Exception {
        calc.calculate(20, 10, "/");
        assertEquals(2, calc.getLastResult(), 0);
    }

    @org.junit.Test
    public void divByZero() throws Exception {
        calc.calculate(20, 0, "/");
        assertEquals(Double.POSITIVE_INFINITY, calc.getLastResult(), 0);
    }

    @org.junit.Test
    public void getLastResult() throws Exception {
        Calculator newCalc = new Calculator();
        assertEquals(0, newCalc.getLastResult(), 0);
    }
}