package lab2;

import java.lang.IndexOutOfBoundsException;
import java.lang.Long;

public class GeneralFunctions {

  public static double defaultAccuracy = 1E-10;
  public static final double PI = 3.14159265358979323846;

  public static double factorial(long n) {
      if (n < 0) return Double.NaN;

      double result = 1;
      for ( ; n > 0; result *= ( n-- )) 
          if (Double.isInfinite(result) || Double.isNaN(result)) break;

      return result;
  }

  public static double pow(double x, long e) {
    if (e == 0) return 1;
    if (e < 0) return Double.NaN;

    if (Double.isInfinite(x)) {
      if (x == Double.NEGATIVE_INFINITY && e % 2 == 1)
        return Double.NEGATIVE_INFINITY;
      else
        return Double.POSITIVE_INFINITY;
    }

    double pow = 1;

    for (long i = 0; i < e; i++) {
      pow *= x;
      if (Double.isInfinite(pow) || Double.isNaN(pow) || pow == 0.0D) break;
    }

    if (Double.isInfinite(pow) && x < 0 && e % 2 == 1)
      return Double.NEGATIVE_INFINITY;

    return pow;
  } 

  public static double abs(double x) {
    if (Double.isNaN(x)) return Double.NaN;
    if (Double.isInfinite(x)) return Double.POSITIVE_INFINITY;
    if (x >= 0) return x;
      else return -x;
  }

}
