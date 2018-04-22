package lab2.trigonometric;

import lab2.GeneralFunctions;

import java.util.HashMap;

public class Sine {

  public static boolean isStub = false;

  public static void setStub(boolean st) {
    isStub = st;
  }

  public static double calculate(double x, double accuracy) {
    if (isStub) {
      return calculateStub(x);
    }

    if (Double.isNaN(x) || Double.isInfinite(x)) return Double.NaN;

    double result = 0;
    double term;
    long n = 0;

    for( ; ; n++) {
      term = (Math.pow( -1, n ) / GeneralFunctions.factorial( 2 * n + 1 )) * Math.pow( x, 2 * n + 1 );
      if (Double.isNaN(term) || Double.isInfinite(term)) return Double.NaN;
      if (Math.abs(term) < accuracy) break;

      result += term;
    }
    // Snap to 0 to get rid of rounding errors
    if (Math.abs(result) < 1E-10) result = 0;
    return result;
  }

  private static double calculateStub(double x) {
    HashMap<Double, Double> testMap = new HashMap<Double, Double>();
    testMap.put(Double.NaN,Double.NaN);
    testMap.put(Double.POSITIVE_INFINITY,Double.NaN);
    testMap.put(Double.NEGATIVE_INFINITY,Double.NaN);
    testMap.put(Math.PI/6,0.499999999999999);
    testMap.put( Math.PI*3/4,0.707106781186547);
    testMap.put( -Math.PI/4,-0.707106781186547);
    testMap.put( -Math.PI*5/6,-0.499999999999999);
    testMap.put( Math.PI*9/4,0.707106781186547);
    testMap.put( -Math.PI*11/6,0.5);
    testMap.put(0.0,0.0);
    testMap.put( 0-0.01,-0.00999983333416666);
    testMap.put(0.01,0.00999983333416666);
    testMap.put(Math.PI-0.01,0.00999983333416657);
    testMap.put( Math.PI,0.0);
    testMap.put( Math.PI+0.01,-0.00999983333416633);
    testMap.put( -Math.PI-0.01,0.00999983333416633);
    testMap.put( -Math.PI,0.0);
    testMap.put( -Math.PI+0.01,-0.00999983333416657);
    testMap.put(Math.PI/2-0.01,0.999950000416665);
    testMap.put( Math.PI/2,1.0);
    testMap.put( Math.PI/2+0.01,0.999950000416665);
    testMap.put( -Math.PI/2-0.01,-0.999950000416665);
    testMap.put( -Math.PI/2,-1.0);
    testMap.put( -Math.PI/2+0.01,-0.999950000416665);

    testMap.put(-Math.PI/6,-0.499999999999999);
    testMap.put(-Math.PI*3/4,-0.707106781186547);
    testMap.put(-Math.PI*9/4,-0.70710678118652);

    testMap.put(-Math.PI/6+Math.PI/2,0.866025403784438);
    testMap.put( -Math.PI*3/4+Math.PI/2,-0.707106781186547);
    testMap.put( -Math.PI*9/4+Math.PI/2,0.707106781186547);
    testMap.put( Math.PI/6+Math.PI/2,0.866025403784439);
    testMap.put( Math.PI*3/4+Math.PI/2,-0.707106781186547);
    testMap.put( -Math.PI/4+Math.PI/2,0.707106781186547);
    testMap.put( -Math.PI*5/6+Math.PI/2,-0.866025403784438);
    testMap.put( Math.PI*9/4+Math.PI/2,0.707106781186577);
    testMap.put( -Math.PI*11/6+Math.PI/2,0.866025403784437);
    testMap.put( 0+Math.PI/2,1.0);
    testMap.put( 0-0.01+Math.PI/2,0.999950000416665);
    testMap.put( 0.01+Math.PI/2,0.999950000416665);
    testMap.put(Math.PI-0.01+Math.PI/2,-0.999950000416665);
    testMap.put( Math.PI+Math.PI/2,-0.999999999999999);
    testMap.put( Math.PI+0.01+Math.PI/2,-0.99995000041666);
    testMap.put( -Math.PI-0.01+Math.PI/2,-0.999950000416665);
    testMap.put( -Math.PI+Math.PI/2,-1.0);
    testMap.put( -Math.PI+0.01+Math.PI/2,-0.999950000416665);
    testMap.put(Math.PI/2-0.01+Math.PI/2,0.00999983333416628);
    testMap.put( Math.PI/2+Math.PI/2,0.0);
    testMap.put( Math.PI/2+0.01+Math.PI/2,-0.009999833334166);
    testMap.put( -Math.PI/2-0.01+Math.PI/2,-0.00999983333416667);
    testMap.put( -Math.PI/2+Math.PI/2,0.0);
    testMap.put( -Math.PI/2+0.01+Math.PI/2,0.00999983333416667);

    double result = testMap.get(x);
    return result;
  }
}
