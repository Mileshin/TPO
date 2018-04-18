package lab2.logarithmic;

import lab2.AbstractFunction;
import lab2.Functions;

import static java.lang.Math.pow;

/**
 * Created by Andrey on 18.04.2018.
 */
public class LogFunction extends AbstractFunction {
    private double precision;
    Ln ln;
    Log2 log2;
    Log3 log3;
    Log5 log5;

    {
        table.put(0.01, 1.0211120502026794);
        table.put(0.99, 4.228769090946707E11);
        table.put(1.01, -4.445584570894382E11);
        function = Functions.LOG_FN;
    }

    public LogFunction(double precision) {
        super(precision);
        this.precision = precision;
        ln = new Ln(precision);
        log2 = new Log2(precision);
        log3 = new Log3(precision);
        log5 = new Log5(precision);

    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        ln.setPrecision(precision);
        log2.setPrecision(precision);
        log3.setPrecision(precision);
        log5.setPrecision(precision);
    }

    @Override
    public double calculate(double arg) {
        double lnx = ln.calc(arg);
        double log2x = log2.calc(arg);
        double log3x = log3.calc(arg);
        double log5x = log5.calc(arg);
        double dividend = (pow(pow(log5x,3),2) - log3x) - (log2x / (log3x / lnx));
        double divisor = pow(pow(log5x,2),3);
        return (dividend / divisor);
    }
}
