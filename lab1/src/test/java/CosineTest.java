import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrey on 19.03.2018.
 */
public class CosineTest extends Assert {
    private static final double DELTA = 0.001;

    @Test
    public void testCosRightPlus() {
        double expected, actual;
        String message;
        // Pi/3
        expected = (double) 1/2;
        actual = CosineTaylor.cos(Math.PI /3);
        message = "Right Plus(0; PI/2)\nEquals: X = " + Math.PI/3 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // Pi/4
        expected = (double) Math.sqrt(2)/2;
        actual = CosineTaylor.cos(Math.PI /4);
        message = "Right Plus(0; PI/2)\nEquals: X = " + Math.PI/4 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // Pi/6
        expected = (double) Math.sqrt(3)/2;
        actual = CosineTaylor.cos(Math.PI /6);
        message = "Right Plus(0; PI/2)\nEquals: X = " + Math.PI/6 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

    }

    @Test
    public void testCosRightMinus() {
        double expected, actual;
        String message;
        // Pi*2/3
        expected = (double) - 1/2;
        actual = CosineTaylor.cos(2*Math.PI /3);
        message = "Right Minus(PI/2;PI)\nEquals: X = " + Math.PI/3 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // Pi*3/4
        expected = (double) -Math.sqrt(2)/2;
        actual = CosineTaylor.cos(3* Math.PI /4);
        message = "Right Minus(PI/2;PI)\nEquals: X = " + Math.PI/4 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // Pi*5/6
        expected = (double) -Math.sqrt(3)/2;
        actual = CosineTaylor.cos(Math.PI * 5/6);
        message = "Right Minus(PI/2;PI)\nEquals: X = " + Math.PI/6 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

    }

    @Test
    public void testCosLeftPlus() {
        double expected, actual;
        String message;
        // -Pi/3
        expected = (double) 1/2;
        actual = CosineTaylor.cos(-Math.PI /3);
        message = "Left Plus(-PI/2;0)\nEquals: X = " + -Math.PI/3 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // -Pi/4
        expected = (double) Math.sqrt(2)/2;
        actual = CosineTaylor.cos(-Math.PI /4);
        message = "Left Plus(-PI/2;0)\nEquals: X = " + Math.PI/4 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // -Pi/6
        expected = (double) Math.sqrt(3)/2;
        actual = CosineTaylor.cos(-Math.PI /6);
        message = "Left Plus(-PI/2;0)\nEquals: X = " + Math.PI/6 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

    }

    @Test
    public void testCosLeftMinus() {
        double expected, actual;
        String message;
        // -Pi*2/3
        expected = (double) - 1/2;
        actual = CosineTaylor.cos(-2*Math.PI /3);
        message = "Left Minus(-PI;-PI/2)\nEquals: X = " + Math.PI/3 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // -Pi*3/4
        expected = (double) -Math.sqrt(2)/2;
        actual = CosineTaylor.cos(-3* Math.PI /4);
        message = "Left Minus(-PI;-PI/2)\nEquals: X = " + Math.PI/4 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // -Pi*5/6
        expected = (double) -Math.sqrt(3)/2;
        actual = CosineTaylor.cos(-Math.PI * 5/6);
        message = "Left Minus(-PI;-PI/2)\nEquals: X = " + Math.PI/6 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

    }

    @Test
    public void testCosExtremum() {
        double expected, actual;
        String message;
        // 0
        expected = (double) 1;
        actual = CosineTaylor.cos(0);
        message = "Right Plus(0; PI/2)\nEquals: X = " + 0 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // Pi
        expected = (double) -1;
        actual = CosineTaylor.cos(Math.PI);
        message = "Right Plus(0; PI/2)\nEquals: X = " + Math.PI + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

        // -Pi
        expected = (double) -1;
        actual = CosineTaylor.cos(-Math.PI );
        message = "Right Plus(0; PI/2)\nEquals: X = " + -Math.PI + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);

    }

    @Test
    public void testCosNaNandInfinity() {
        double expected, actual;
        String message;
        // NaN
        actual = CosineTaylor.cos(Double.NaN);
        message = "NaN";
        assertEquals(message,Double.NaN, actual, DELTA);

        // INFINITY
        actual = CosineTaylor.cos(Double.POSITIVE_INFINITY);
        message = "INFINITY";
        assertEquals(message,Double.NaN, actual, DELTA);
    }
}
