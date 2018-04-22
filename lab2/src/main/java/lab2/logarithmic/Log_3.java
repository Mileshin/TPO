package lab2.logarithmic;

import java.util.HashMap;

public class Log_3 {

  public static boolean isStub = false;

  public static void setStub(boolean st) {
    isStub = st;
  }

  public static double calculate(double x, double accuracy) {
    if (isStub) {
      return calculateStub(x);
    }
    return Ln.calculate(x, accuracy) / Ln.calculate(3, accuracy);
  }

  private static double calculateStub(double x) {
    HashMap<Double, Double> testMap = new HashMap<Double, Double>();
    testMap.put(Double.NaN,Double.NaN);
    testMap.put(Double.POSITIVE_INFINITY,Double.NaN);
    testMap.put(Double.NEGATIVE_INFINITY,Double.NaN);
    testMap.put(-0.01, Double.NaN);
    testMap.put(0.0, Double.NEGATIVE_INFINITY);
    testMap.put(0.01,-4.19180654857876);
    testMap.put(1.0/Math.E-0.01, -0.93532460577766);
    testMap.put(1.0/Math.E, -0.910239226626837);
    testMap.put(1.0/Math.E+0.01, -0.885826676956276);
    testMap.put(Math.E-0.01, 0.906884469124572);
    testMap.put(Math.E, 0.910239226626837);
    testMap.put(Math.E+0.01,0.913581665297388);
    testMap.put(1.0/2.0-0.01, -0.649319050255924);
    testMap.put(1.0/2.0, -0.630929753571457);
    testMap.put(1.0/2.0+0.01, -4.19180654857876);
    testMap.put(2.0-0.01, 0.626367141378559);
    testMap.put(2.0, 0.630929753571457);
    testMap.put(2.0+0.01,0.635469609499234);
    testMap.put(1.0/3.0-0.01, -1.02772516546454);
    testMap.put(1.0/3.0, -1.0);
    testMap.put(1.0/3.0+0.01, -0.97309441870764);
    testMap.put(3.0-0.01, 0.996960801094294);
    testMap.put(3.0, 1.0);
    testMap.put(3.0+0.01,1.00302908508033);
    testMap.put(1.0/5.0-0.01, -1.51166268933239);
    testMap.put(1.0/5.0, -1.46497352071792);
    testMap.put(1.0/5.0+0.01, -1.42056279941734);
    testMap.put(5.0-0.01, 1.46315121935526);
    testMap.put(5.0, 1.46497352071792);
    testMap.put(5.0+0.01,1.46679218111639);
    testMap.put(1.0,0.0);
    testMap.put(1.0+0.1, 0.086755064354);
    testMap.put(1.0-0.1, -0.0959032742893);

    testMap.put(0.0001,-8.38361309715619);
    testMap.put(0.1,-2.09590327428939);
    testMap.put(1-0.1,-0.0959032742893851);
    testMap.put(1.0,0.0);
    testMap.put(1+0.1,0.0867550643547542);
    testMap.put(6.56541-0.01,1.71151431886196);
    testMap.put(6.56541,1.71290179221022);
    testMap.put(6.56541+0.01,1.71428715385788);
    testMap.put(10.0,2.09590327428939);
    testMap.put(100.0,4.19180654857878);


    double result = testMap.get(x);
    return result;
  }
}
