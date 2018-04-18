package lab2.logarithmic;

import lab2.Functions;

/**
 * Created by Andrey on 18.04.2018.
 */
public class Log3 extends LogN {
    public static final int BASE = 3;

    {
        table.put(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        table.put(BASE - 0.01, 0.9970024821961635);
        table.put((double) BASE, 1.0);
        table.put(BASE + 0.01, 1.0030308137684487);

        table.put(0.0 - 0.01, Double.NaN);
        table.put(0.0, Double.NEGATIVE_INFINITY);
        table.put(0.0 + 0.01, -4.184948602553416);

        table.put(1.0 - 0.01, -0.009148574231092494);
        table.put(1.0, 0.0);
        table.put(1.0 + 0.01, 0.00905754364172839);
        function = Functions.LOG_2;
    }

    public Log3(double precision) {
        super(precision);
    }

    @Override
    protected double calculate(double arg) {
        return log(arg, BASE);
    }
}
