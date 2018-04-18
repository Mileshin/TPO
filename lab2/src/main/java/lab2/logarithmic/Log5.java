package lab2.logarithmic;

import lab2.Functions;

/**
 * Created by Andrey on 18.04.2018.
 */
public class Log5 extends LogN {
    public static final int BASE = 5;

    {
        table.put(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        table.put(BASE - 0.01, 0.9987847960319418);
        table.put((double) BASE, 1.0);
        table.put(BASE + 0.01, 1.001242355407259);

        table.put(0.0 - 0.01, Double.NaN);
        table.put(0.0, Double.NEGATIVE_INFINITY);
        table.put(0.0 + 0.01, -2.8565920345582074);

        table.put(1.0 - 0.01, -0.006244698981525837);
        table.put(1.0, 0.0);
        table.put(1.0 + 0.01, 0.006182562673251948);
        function = Functions.LOG_2;
    }

    public Log5(double precision) {
        super(precision);
    }

    @Override
    protected double calculate(double arg) {
        return log(arg, BASE);
    }
}
