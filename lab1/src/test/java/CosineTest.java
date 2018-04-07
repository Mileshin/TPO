import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by Andrey on 19.03.2018.
 */
public class CosineTest extends Assert {
    private static final double DELTA = 0.001;

    @Test
    public void testCosRightPlus() {
        double expected, actual;
        String message;
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
        // Pi*3/4
        expected = (double) -Math.sqrt(2)/2;
        actual = CosineTaylor.cos(3* Math.PI /4);
        message = "Right Minus(PI/2;PI)\nEquals: X = " + Math.PI/4 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosLeftPlus() {
        double expected, actual;
        String message;
        // -Pi/4
        expected = (double) Math.sqrt(2)/2;
        actual = CosineTaylor.cos(-Math.PI /4);
        message = "Left Plus(-PI/2;0)\nEquals: X = " + Math.PI/4 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosLeftMinus() {
        double expected, actual;
        String message;
        // -Pi*5/6
        expected = (double) -Math.sqrt(3)/2;
        actual = CosineTaylor.cos(-Math.PI * 5/6);
        message = "Left Minus(-PI;-PI/2)\nEquals: X = " + Math.PI/6 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosZero() {
        double expected, actual;
        String message;
        // 0
        expected = (double) 1;
        actual = CosineTaylor.cos(0);
        message = "Zero \nEquals: X = " + 0 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosZeroPlusDelta() {
        double expected, actual;
        String message;
        // 0+delta
        expected = (double) 0.99999999849;
        actual = CosineTaylor.cos(Math.PI*0.001);
        message = "Zero \nEquals: X = " + Math.PI*0.001 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }
    @Test
    public void testCosZeroMinusDelta() {
        double expected, actual;
        String message;
        // 0-delta
        expected = (double) 0.99999999849;
        actual = CosineTaylor.cos(-Math.PI*0.001);
        message = "Zero \nEquals: X = " + -Math.PI*0.001 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosPlusPi() {
        double expected, actual;
        String message;
        // Pi
        expected = (double) -1;
        actual = CosineTaylor.cos(Math.PI);
        message = "Plus Pi \nEquals: X = " + Math.PI + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }



    @Test
    public void testCosPlusPiPlusDelta() {
        double expected, actual;
        String message;
        // Pi + delta
        expected = (double) -0.9999950652;
        actual = CosineTaylor.cos(Math.PI+Math.PI*0.001);
        message = "Plus Pi \nEquals: X = " + (Math.PI+Math.PI*0.001) + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosPlusPiMinusDelta() {
        double expected, actual;
        String message;
        // Pi + delta
        expected = (double) -0.9999950652;
        actual = CosineTaylor.cos(Math.PI-Math.PI*0.001);
        message = "Plus Pi \nEquals: X = " + (Math.PI-Math.PI*0.001) + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosMinusPi() {
        double expected, actual;
        String message;
        // -Pi
        expected = (double) -1;
        actual = CosineTaylor.cos(-Math.PI );
        message = "Minus Pi \nEquals: X = " + -Math.PI + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosMinusPiPlusDelta() {
        double expected, actual;
        String message;
        // -Pi+PI*0.001
        expected = (double) -0.9999950652;;
        actual = CosineTaylor.cos(-Math.PI+Math.PI*0.001 );
        message = "Minus Pi \nEquals: X = " + (-Math.PI+Math.PI*0.001) + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosMinusPiMinussDelta() {
        double expected, actual;
        String message;
        // -Pi-PI*0.001
        expected = (double) -0.9999950652;;
        actual = CosineTaylor.cos(-Math.PI-Math.PI*0.001 );
        message = "Minus Pi \nEquals: X = " + (-Math.PI-Math.PI*0.001) + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosPlusHalfPi() {
        double expected, actual;
        String message;
        // Pi/2
        expected = (double) 0;
        actual = CosineTaylor.cos(Math.PI/2);
        message = "Plus Pi/2 \nEquals: X = " + Math.PI/2 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosPlusHalfPiPlusDelta() {
        double expected, actual;
        String message;
        // Pi/2+Math.PI*0.001
        expected = (double) -0.00031415926;
        actual = CosineTaylor.cos(Math.PI/2+Math.PI*0.0001);
        message = "Plus Pi/2 \nEquals: X = " + (Math.PI/2+Math.PI*0.0001) + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosPlusHalfPiMinusDelta() {
        double expected, actual;
        String message;
        // Pi/2+Math.PI*0.001
        expected = (double) 0.00031415926;
        actual = CosineTaylor.cos(Math.PI/2-Math.PI*0.0001);
        message = "Plus Pi/2 \nEquals: X = " + (Math.PI/2-Math.PI*0.0001) + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosMinusHalfPi() {
        double expected, actual;
        String message;
        // -Pi/2
        expected = (double) 0;
        actual = CosineTaylor.cos(-Math.PI /2-Math.PI*0.0001);
        message = "Minus Pi/2 \nEquals: X = " + -Math.PI/2 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosMinusHalfPiMinusDelta() {
        double expected, actual;
        String message;
        // -Pi/2
        expected = (double) 0.00031415926;
        actual = CosineTaylor.cos(-Math.PI /2-Math.PI*0.0001);
        message = "Minus Pi/2 \nEquals: X = " + -Math.PI/2 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosMinusHalfPiPlusDelta() {
        double expected, actual;
        String message;
        // -Pi/2
        expected = (double) -0.00031415926;
        actual = CosineTaylor.cos(-Math.PI /2-Math.PI*0.0001);
        message = "Minus Pi/2 \nEquals: X = " + (-Math.PI/2-Math.PI*0.0001) + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }


    @Test
    public void testCosRightPeriodec() {
        double expected, actual;
        String message;
        // Pi9/4
        expected = (double) Math.sqrt(2)/2;
        actual = CosineTaylor.cos(Math.PI*9/4);
        message = "Plus Pi*9/4 \nEquals: X = " + Math.PI*9/4 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosLeftPeriodec() {
        double expected, actual;
        String message;
        // -Pi11/6
        expected = (double) Math.sqrt(3)/2;
        actual = CosineTaylor.cos(-Math.PI*11/6);
        message = "Plus -Pi*11/6 \nEquals: X = " + -Math.PI*11/6 + "; Cos(X) = " + expected;
        assertEquals(message,expected, actual, DELTA);
    }

    @Test
    public void testCosNaN() {
        double expected, actual;
        String message;
        // NaN
        actual = CosineTaylor.cos(Double.NaN);
        message = "NaN";
        assertEquals(message,Double.NaN, actual, DELTA);
    }

    @Test
    public void testCosPositiveInfinity() {
        double expected, actual;
        String message;
        // INFINITY
        actual = CosineTaylor.cos(Double.POSITIVE_INFINITY);
        message = "INFINITY";
        assertEquals(message,Double.NaN, actual, DELTA);
    }

    @Test
    public void testCosNegativeInfinity() {
        double expected, actual;
        String message;
        // NEGATIVE_INFINITY
        actual = CosineTaylor.cos(Double.NEGATIVE_INFINITY);
        message = "NEGATIVE_INFINITY";
        assertEquals(message,Double.NaN, actual, DELTA);
    }
}
