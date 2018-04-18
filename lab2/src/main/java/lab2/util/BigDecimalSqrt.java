package lab2.util;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Andrey on 18.04.2018.
 */
public class BigDecimalSqrt {

    private static final BigDecimal TWO = BigDecimal.valueOf(2L);

    public static BigDecimal sqrt(BigDecimal x, MathContext mc) {
        BigDecimal g = x.divide(TWO, mc);
        boolean done = false;
        final int maxIterations = mc.getPrecision() + 1;
        for (int i = 0; !done && i < maxIterations; i++) {
            BigDecimal r = x.divide(g, mc);
            r = r.add(g);
            r = r.divide(TWO, mc);
            done = r.equals(g);
            g = r;
        }
        return g;
    }
}
