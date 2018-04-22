package lab2.trigonometric;

import java.util.HashMap;

public class Cosine {

  public static boolean isStub = false;

  public static void setStub(boolean st) {
    isStub = st;
  }

  public static double calculate(double x, double accuracy) {
    if (isStub) {
      return calculateStub(x);
    }
    return Sine.calculate(x + Math.PI / 2, accuracy);
  }

  private static double calculateStub(double x) {
    HashMap<Double, Double> testMap = new HashMap<Double, Double>();
    testMap.put(Double.NaN,Double.NaN);
    testMap.put(Double.POSITIVE_INFINITY,Double.NaN);
    testMap.put(Double.NEGATIVE_INFINITY,Double.NaN);
    testMap.put(Math.PI/6,0.866025403784438);
    testMap.put( Math.PI*3/4,-0.707106781186547);
    testMap.put( -Math.PI/4,0.707106781186547);
    testMap.put( -Math.PI*5/6,-0.866025403784438);
    testMap.put( Math.PI*9/4,0.707106781186547);
    testMap.put( -Math.PI*11/6,0.866025403784438);
    testMap.put(0.0,1.0);
    testMap.put( 0-0.01,0.999950000416665);
    testMap.put(0.01,0.999950000416665);
    testMap.put(Math.PI-0.01,-0.999950000416665);
    testMap.put( Math.PI,-1.0);
    testMap.put( Math.PI+0.01,-0.999950000416665);
    testMap.put( -Math.PI-0.01,-0.999950000416665);
    testMap.put( -Math.PI,-1.0);
    testMap.put( -Math.PI+0.01,-0.999950000416665);
    testMap.put(Math.PI/2-0.01,0.00999983333416673);
    testMap.put( Math.PI/2,6.12323399573676E-17);
    testMap.put( Math.PI/2+0.01,-0.00999983333416661);
    testMap.put( -Math.PI/2-0.01,-0.00999983333416661);
    testMap.put( -Math.PI/2,6.12323399573676E-17);
    testMap.put( -Math.PI/2+0.01,0.00999983333416673);

    testMap.put(-Math.PI/6,0.866025403784438);
    testMap.put(-Math.PI*3/4,-0.707106781186547);
    testMap.put(-Math.PI*9/4,0.707106781186547);

    double result = testMap.get(x);
    return result;
  }
}
