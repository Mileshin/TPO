package lab2;

import lab2.logarithmic.*;

import java.util.*; //for test Map

import static java.lang.Math.pow;

public class MoreThanZero {

  public static boolean isStub = false;

  public static void setStub(boolean st) {
    isStub = st;
  }

  public static double calculate(double x, double accuracy) {
    if (isStub) {
      return calculateStub(x);
    }

    if (x > 0) {
      double ln = Ln.calculate(x, accuracy);
      double log_2 = Log_2.calculate(x, accuracy);
      double log_3 = Log_3.calculate(x, accuracy);
      double log_5 = Log_5.calculate(x, accuracy);

      double dividend = (pow(pow(log_5,3),2) - log_3) - ((log_2 / log_3) / ln);
      double divisor = pow(pow(log_5,2),3);
      return (dividend / divisor);
    } else
      return Double.NaN;
  }


  private static double calculateStub(double x) {
    HashMap<Double, Double> testMap = new HashMap<Double, Double>();
    testMap.put(Double.NaN,Double.NaN);
    testMap.put(Double.POSITIVE_INFINITY,Double.NaN);
    testMap.put(0.0001,1.00024358286934);
    testMap.put(0.1,1.32468220372257);
    testMap.put( 1-0.1,1.9234418575613645E8);
    testMap.put(1.0,Double.NaN);
    testMap.put( 1+0.1,-3.875690857303391E8);
    testMap.put( 6.56541-0.01,-0.00459888277148908);
    testMap.put(6.56541,-2.11823163871935E-06);
    testMap.put( 6.56541+0.01,0.00456240081479463);
    testMap.put(10.0,0.675317796277427);
    testMap.put(100.0,0.991735014771465);
    testMap.put(1/Math.E-0.01,37.5819595235536);
    testMap.put( 1/Math.E,44.3661659446621);
    testMap.put( 1/Math.E+0.01,52.4437298038434);
    testMap.put( Math.E-0.01,-43.3822064913816);
    testMap.put( Math.E,-42.3661659446621);
    testMap.put( Math.E+0.01,-41.3811096532404);
    testMap.put(1/2.0-0.01,379.69522427895);
    testMap.put( 1/2.0,458.204507471473);
    testMap.put( 1/2+0.01,1.00826498522853);
    testMap.put( 2-0.01,-478.533826012144);
    testMap.put(2.0,-456.204507471473);
    testMap.put( 2+0.01,-435.182643727115);
    testMap.put( 1/3.0-0.01,21.3981617966228);
    testMap.put( 1/3.0,25.1461503352262);
    testMap.put( 1/3.0+0.01,29.5904113121646);
    testMap.put( 3-0.01,-23.6048613426394);
    testMap.put(3.0,-23.1461503352263);
    testMap.put( 3+0.01,-22.6990321146991);
    testMap.put(1/5.0-0.01,3.04290995077336);
    testMap.put( 1/5.0,3.44976609238294);
    testMap.put( 1/5.0+0.01,3.93034497176137);
    testMap.put( 5-0.01,-1.46752950805015);
    testMap.put(5.0,-1.44976609238294);
    testMap.put( 5+0.01,-1.43219104727175);
    double result = testMap.get(x);
    return result;
   }


  //Test hashmap for when stub, provided by
  //WolframAlpha

}
