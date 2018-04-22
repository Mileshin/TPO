package lab2.trigonometric;

import java.util.HashMap;

public class Tangent {

  public static boolean isStub = false;

  public static void setStub(boolean st) {
    isStub = st;
  }

  public static double calculate(double x, double accuracy) {
    if (isStub) {
      return calculateStub(x);
    }
    else{
      double res = Sine.calculate(x, accuracy) / Cosine.calculate(x, accuracy);
      // Java doesn't support complex infinity so use positive infinity instead
      if(Double.isInfinite(res)) res = Double.POSITIVE_INFINITY;
      return res;
    }
  }

  private static double calculateStub(double x) {
    HashMap<Double, Double> testMap = new HashMap<Double, Double>();
    testMap.put(Double.NaN,Double.NaN);
    testMap.put(Double.POSITIVE_INFINITY,Double.NaN);
    testMap.put(Double.NEGATIVE_INFINITY,Double.NaN);
    testMap.put(Math.PI/6,0.577350269189625);
    testMap.put( Math.PI*3/4,-1.0);
    testMap.put( -Math.PI/4,-1.0);
    testMap.put( -Math.PI*5/6,0.577350269189626);
    testMap.put( Math.PI*9/4,0.999999999999919);
    testMap.put( -Math.PI*11/6,0.577350269189625);
    testMap.put(0.0,0.0);
    testMap.put( 0-0.01,-0.0100003333466672);
    testMap.put(0.01,0.0100003333466672);
    testMap.put(Math.PI-0.01,-0.0100003333466668);
    testMap.put( Math.PI,0.0);
    testMap.put( Math.PI+0.01,0.0100003333466665);
    testMap.put( -Math.PI-0.01,-0.0100003333466665);
    testMap.put( -Math.PI,0.0);
    testMap.put( -Math.PI+0.01,0.0100003333466668);
    testMap.put(Math.PI/2-0.01,99.996666644448);
    testMap.put( Math.PI/2,Double.POSITIVE_INFINITY);
    testMap.put( Math.PI/2+0.01,-99.9966666444508);
    testMap.put( -Math.PI/2-0.01,99.9966666444441);
    testMap.put( -Math.PI/2,Double.POSITIVE_INFINITY);
    testMap.put( -Math.PI/2+0.01,-99.9966666444441);

    testMap.put(-Math.PI/6,-0.577350269189625);
    testMap.put(-Math.PI*3/4,1.0);
    testMap.put(-Math.PI*9/4,-0.999999999999961);

    double result = testMap.get(x);
    return result;
  }
}
