package lab2.logarithmic;

import lab2.Functions;

/**
 * Created by Andrey on 18.04.2018.
 */
public class Log2 extends LogN {
    public static final int BASE = 2;

    {
        table.put(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        table.put(BASE - 0.01, 0.992768);
        table.put((double) BASE, 1.0);
        table.put(BASE + 0.01, 1.00720);

        table.put(0.0 - 0.01, Double.NaN);
        table.put(0.0, Double.NEGATIVE_INFINITY);
        table.put(0.0 + 0.01, -6.632979274557514);

        table.put(1.0 - 0.01, -0.0144996);
        table.put(1.0, 0.0);
        table.put(1.0 + 0.01, 0.0143553);
        function = Functions.LOG_2;
    }

    public Log2(double precision) {
        super(precision);
    }

    @Override
    protected double calculate(double arg) {
        return log(arg, BASE);
    }
}
