package lab2.logarithmic;

import java.util.HashMap;

public class Ln {

  public static boolean isStub = false;

  public static void setStub(boolean st) {
    isStub = st;
  }

  public static double calculate(double x, double accuracy) {
    if (isStub) {
      return calculateStub(x);
    }
    double y = 0;
    double d = 1;
    double term = 0;

    if (x > 0) {
      for (int n = 0 ; d > accuracy ; n++) {
        d = y;
 
        term = 2.0 / (2.0 * n + 1) * Math.pow(((x - 1.0) / (x + 1.0)), 2 * n + 1);
        y += term;
        d = Math.abs(y - d);
      }
      return y;
    } else
      if (x == 0)
        return Double.NEGATIVE_INFINITY;
      else
        return Double.NaN;
  }

  private static double calculateStub(double x) {
   HashMap<Double, Double> testMap = new HashMap<Double, Double>();
    testMap.put(Double.NaN,Double.NaN);
    testMap.put(Double.POSITIVE_INFINITY,Double.NaN);
    testMap.put(Double.NEGATIVE_INFINITY,Double.NaN);
    testMap.put(-0.01, Double.NaN);
    testMap.put(0.0, Double.NEGATIVE_INFINITY);
    testMap.put(0.01,-4.60517018598809);
    testMap.put(1.0/Math.E-0.01, -1.02755910580099);
    testMap.put(1.0/Math.E, -1.0);
    testMap.put(1.0/Math.E+0.01, -0.973180072934201);
    testMap.put(Math.E-0.01, 0.99631442218251);
    testMap.put(Math.E, 1.0);
    testMap.put(Math.E+0.01,1.00367204419758);
    testMap.put(1.0/2.0-0.01, -0.713349887877464);
    testMap.put(1.0/2.0, -0.693147180559945);
    testMap.put(1.0/2.0+0.01, -4.60517018598809);
    testMap.put(2.0-0.01, 0.688134638736401);
    testMap.put(2.0, 0.693147180559945);
    testMap.put(2.0+0.01,0.698134722070984);
    testMap.put(1.0/3.0-0.01, -1.12907149615281);
    testMap.put(1.0/3.0, -1.0986122886681);
    testMap.put(1.0/3.0+0.01, -1.06905348642656);
    testMap.put(3.0-0.01, 1.09527338740259);
    testMap.put(3.0, 1.0986122886681);
    testMap.put(3.0+0.01,1.10194007876078);
    testMap.put(1.0/5.0-0.01, -1.66073120682165);
    testMap.put(1.0/5.0, -1.6094379124341);
    testMap.put(1.0/5.0+0.01, -1.56064774826466);
    testMap.put(5.0-0.01, 1.60743590976342);
    testMap.put(5.0, 1.6094379124341);
    testMap.put(5.0+0.01,1.61143591509677);
    testMap.put(1.0,0.0);
    testMap.put(1.0+0.1, 0.095310179804324);
    testMap.put(1.0-0.1, -0.10536051565782);

    testMap.put(0.0001,-9.21034037197462);
    testMap.put(0.1,-2.30258509299404);
    testMap.put(1-0.1,-0.105360515657826);
    testMap.put(1+0.1,0.0953101798043249);
    testMap.put(6.56541-0.01,1.88029066293317);
    testMap.put(6.56541,1.88181495820377);
    testMap.put(6.56541+0.01,1.88333693353413);
    testMap.put(10.0,2.30258509299404);
    testMap.put(100.0,4.60517018598807);



    double result = testMap.get(x);
    return result;
  }
}
