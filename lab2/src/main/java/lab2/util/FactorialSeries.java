package lab2.util;

import java.util.HashMap;

/**
 * Created by Andrey on 18.04.2018.
 */
public class FactorialSeries {
    private static HashMap<Integer, Double> cache = new HashMap<>();

    public static Double factorial(int n) {
        Double ret;

        if (n == 0) {
            return 1.0;
        } else {
            if ((ret = cache.get(n)) != null) {
                return ret;
            }
            ret = n * factorial(n - 1);
            cache.put(n, ret);
        }
        return ret;
    }
}