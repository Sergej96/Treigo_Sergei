import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void addTest() {
        assertEquals(6, calc.add(1, 5), 0.001);
    }

    @Test
    public void addMaxValue() {
        assertEquals(Float.POSITIVE_INFINITY, calc.add(Float.MAX_VALUE, (float) 0.1E33), 0.001);
    }

    @Test
    public void subTest() {
        assertEquals(6, calc.sub(15, 9), 0.001);
    }

    @Test
    public void subMaxOtricValue() {
        assertEquals(-Float.POSITIVE_INFINITY, calc.sub(-Float.MAX_VALUE, (float) 0.1E33), 0.001);
    }

    @Test
    public void mulTest() {
        assertEquals(135, calc.mul(15, 9), 0.001);
    }

    @Test
    public void mulMaxValue() {
        assertEquals(Float.POSITIVE_INFINITY, calc.mul(Float.MAX_VALUE, (float) 0.1E5), 0.001);

    }

    @Test
    public void divTest() {
        assertEquals(36, calc.div(144, 4), 0.001);
        assertEquals(36, calc.div(-144, -4), 0.001);
        assertEquals(-36, calc.div(144, -4), 0.001);
        assertEquals(-36, calc.div(-144, 4), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() throws ArithmeticException {
        calc.div(2, 0);
    }

    @Test
    public void resultAllOperation() {
        List<String> str = new ArrayList<String>(Arrays.asList("2", "2", "+"));
        assertEquals(4, calc.evaluationOfExpression(str), 0.001);
        str.remove("+");
        str.add("-");
        assertEquals(0, calc.evaluationOfExpression(str), 0.001);
        str.remove("-");
        str.add("*");
        assertEquals(4, calc.evaluationOfExpression(str), 0.001);
        str.remove("*");
        str.add("/");
        assertEquals(1, calc.evaluationOfExpression(str), 0.001);
        str.remove("/");
        str.add("u-");
        assertEquals(-2, calc.evaluationOfExpression(str), 0.001);
    }


}