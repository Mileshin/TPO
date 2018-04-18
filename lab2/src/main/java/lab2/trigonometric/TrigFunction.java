package lab2.trigonometric;

import lab2.AbstractFunction;
import lab2.Functions;

import static java.lang.Double.NaN;
import static java.lang.Math.PI;
import static java.lang.Math.pow;

/**
 * Created by Andrey on 18.04.2018.
 */
public class TrigFunction extends AbstractFunction {
    private double precision;
    Tangent tan;

    {
        table.put(0.01, 1.0099607597055473E10);
        table.put(-0.01, -9.899637632677807E9);
        table.put(0.0, NaN);

        table.put(1.01, 0.9898052287352547);
        table.put(1.0, 1.0514533523222378);
        table.put(0.99, 1.1170816671751458);

        table.put(1.570900018 + 0.01, 2.001475909139914e-4);
        table.put(1.570900018, 0.0);
        table.put(1.570900018 - 0.01, 1.9888998093426087e-4);

        table.put(-17.278800 + 0.01, 2.001475909139914e-4);
        table.put(-17.278800, 0.0);
        table.put(-17.278800 - 0.01, 1.9888998093426087e-4);

        table.put(-2.19038087 + 0.01, 0.11978582280904848);
        table.put(-2.19038087, 0.12017868464179626);
        table.put(-2.19038087 - 0.01, 0.11982030530484743);

        table.put(-2.31976664 + 0.01, 0.022961039961962967);
        table.put(-2.31976664, -2.6625611618416215E-4);
        table.put(-2.31976664 - 0.01, -0.02735194917552614);

        table.put(-4.713001 + 0.01, 1.7714445555187369E-4);
        table.put(-4.713001, 0.0);
        table.put(-4.713001 - 0.01, 2.2436897140541053E-4);

        table.put(-PI - 0.01, 1.0035656447616072E10);
        table.put(-PI, NaN);
        table.put(-PI + 0.01, -9.836662592201763E9);

        function = Functions.TRIG_FN;
    }

    public TrigFunction(double precision) {
        super(precision);
        this.precision = precision;
        tan = new Tangent(precision);
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        tan.setPrecision(precision);
    }

    @Override
    public double calculate(double arg) {
        double tanVal = tan.calc(arg);
        return tanVal;
    }
}
