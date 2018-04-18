package lab2.logarithmic;

import lab2.TestUtil;
import org.junit.Before;
import org.junit.Test;

import static lab2.AbstractFunction.DELTA;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 18.04.2018.
 */
public class FunctionTest {
    private double precision = DELTA;
    private TestUtil util = new TestUtil(new LogFunction(precision));

    @Before
    public void setUp(){
        Ln ln = new Ln(DELTA);
        ln.setFuncIsStub(false);
        Log2 log2 = new Log2(DELTA);
        log2.setFuncIsStub(false);
        Log3 log3 = new Log3(DELTA);
        log3.setFuncIsStub(false);
        Log5 log5 = new Log5(DELTA);
        log5.setFuncIsStub(false);
    }

    @Test
    public void negativeInfinity(){
        util.doCheck(Double.NEGATIVE_INFINITY, precision);
    }

    @Test
    public void positiveInfinity(){
        util.doCheck(Double.POSITIVE_INFINITY, precision);
    }

    @Test
    public void nan(){
        util.doCheck(Double.NaN, precision);
    }

    @Test
    public void ltZero() {
        util.doCheck(-0.01, precision);
    }

    @Test
    public void zero() {
        util.doCheck(0.0, precision);
    }

    @Test
    public void gtZero() {
        util.doCheck(0.01, precision);
    }

    @Test
    public void ltOne() {
        util.doCheck(1 - 0.01, precision);
    }

    @Test
    public void one() {
        util.doCheck(1.0, precision);
    }

    @Test
    public void gtOne() {
        util.doCheck(1.0 + 0.01, precision);
    }

}