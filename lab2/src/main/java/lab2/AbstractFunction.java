package lab2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrey on 18.04.2018.
 */
public abstract class AbstractFunction {

    private static final double DEFAULT_PRECISION = 0.000001;
    public static final double DELTA = 1e-4;
    public static final int MAX_ITERATIONS = 1_000_000;
    public final Boolean DEFAULT_IS_STUB = true;

    // stub values
    private static Map<Functions, Boolean> funcIsStub = new HashMap<>();
    protected Functions function;

    private double precision;

    protected Map<Double, Double> table = new HashMap<>();

    public AbstractFunction() {
        this.precision = DEFAULT_PRECISION;
    }

    protected AbstractFunction(double precision) {
        this.precision = precision;
        funcIsStub.put(function, DEFAULT_IS_STUB);
    }

    public double calc(double arg) {
        Boolean isStub;
        if (function == null){
            throw new NullPointerException();
        }
        if((isStub = funcIsStub.get(function)) == null) {
            isStub = DEFAULT_IS_STUB;
        }
        if(isStub.booleanValue()){
            return stub(arg);
        } else {
            return calculate(arg);
        }
    }

    // Precision
    public double getPrecision() {
        return precision;
    }
    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public void setFuncIsStub(boolean funcIsStub) {
        this.funcIsStub.put(function, funcIsStub);
    }

    protected double stub(double arg) {
        Double result;

        if((result = table.get(arg)) != null)
            return result.doubleValue();
        else
            return Double.NaN;
    }

    protected abstract double calculate(double arg);
}
