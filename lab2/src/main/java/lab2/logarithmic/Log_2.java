package lab2.logarithmic;

import java.util.HashMap;

public class Log_2 {

  public static boolean isStub = false;

  public static void setStub(boolean st) {
    isStub = st;
  }

  public static double calculate(double x, double accuracy) {
    if (isStub) {
      return calculateStub(x);
    }
    return Ln.calculate(x, accuracy) / Ln.calculate(2, accuracy);
  }

  private static double calculateStub(double x) {
    HashMap<Double, Double> testMap = new HashMap<Double, Double>();
    testMap.put(Double.NaN,Double.NaN);
    testMap.put(Double.POSITIVE_INFINITY,Double.NaN);
    testMap.put(Double.NEGATIVE_INFINITY,Double.NaN);
    testMap.put(-0.01, Double.NaN);
    testMap.put(0.0, Double.NEGATIVE_INFINITY);
    testMap.put(0.01,-6.64385618977472);
    testMap.put(1.0/Math.E-0.01, -1.48245442615938);
    testMap.put(1.0/Math.E, -1.44269504088896);
    testMap.put(1.0/Math.E+0.01, -1.40400206511413);
    testMap.put(Math.E-0.01, 1.43737787604886);
    testMap.put(Math.E, 1.44269504088896);
    testMap.put(Math.E+0.01,1.44799268084274);
    testMap.put(1.0/2.0-0.01, -1.02914634565951);
    testMap.put(1.0/2.0, -1.0);
    testMap.put(1.0/2.0+0.01, -6.64385618977472);
    testMap.put(2.0-0.01, 0.992768430768924);
    testMap.put(2.0, 1.0);
    testMap.put(2.0+0.01,1.0071955014042);
    testMap.put(1.0/3.0-0.01, -1.62890584830875);
    testMap.put(1.0/3.0, -1.58496250072115);
    testMap.put(1.0/3.0+0.01, -1.54231816331266);
    testMap.put(3.0-0.01, 1.58014548442338);
    testMap.put(3.0, 1.58496250072115);
    testMap.put(3.0+0.01,1.58976348698497);
    testMap.put(1.0/5.0-0.01, -2.39592867633113);
    testMap.put(1.0/5.0, -2.32192809488736);
    testMap.put(1.0/5.0+0.01, -2.25153876699596);
    testMap.put(5.0-0.01, 2.31903981556253);
    testMap.put(5.0, 2.32192809488736);
    testMap.put(5.0+0.01,2.32481060342048);
    testMap.put(1.0,0.0);
    testMap.put(1.0+0.1, 0.13750352375);
    testMap.put(1.0-0.1, -0.15200309344);

    testMap.put(0.0001,-13.2877123795472);
    testMap.put(0.1,-3.32192809488735);
    testMap.put(1-0.1,-0.152003093445049);
    testMap.put(1+0.1,0.137503523749935);
    testMap.put(6.56541-0.01,2.7126860148435);
    testMap.put(6.56541,2.71488510807125);
    testMap.put(6.56541+0.01,2.71708085433271);
    testMap.put(10.0,3.32192809488735);
    testMap.put(100.0,6.64385618977469);

    double result = testMap.get(x);
    return result;
  }
}
