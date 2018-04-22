package lab2.logarithmic;

import java.util.HashMap;

public class Log_5 {

  public static boolean isStub = false;

  public static void setStub(boolean st) {
    isStub = st;
  }

  public static double calculate(double x, double accuracy) {
    if (isStub) {
      return calculateStub(x);
    }
    return Ln.calculate(x, accuracy) / Ln.calculate(5, accuracy);
  }

  private static double calculateStub(double x) {
    HashMap<Double, Double> testMap = new HashMap<Double, Double>();
    testMap.put(Double.NaN,Double.NaN);
    testMap.put(Double.POSITIVE_INFINITY,Double.NaN);
    testMap.put(Double.NEGATIVE_INFINITY,Double.NaN);
    testMap.put(-0.01, Double.NaN);
    testMap.put(0.0, Double.NEGATIVE_INFINITY);
    testMap.put(0.01,-2.86135311614678);
    testMap.put(1.0/Math.E-0.01, -0.638458369758993);
    testMap.put(1.0/Math.E, -0.621334934559611);
    testMap.put(1.0/Math.E+0.01, -0.60467077693129);
    testMap.put(Math.E-0.01, 0.619044956307567);
    testMap.put(Math.E, 0.621334934559611);
    testMap.put(Math.E+0.01,0.623616503900819);
    testMap.put(1.0/2.0-0.01, -0.443229205902451);
    testMap.put(1.0/2.0, -0.430676558073393);
    testMap.put(1.0/2.0+0.01, -2.86135311614678);
    testMap.put(2.0-0.01, 0.427562090727483);
    testMap.put(2.0, 0.430676558073393);
    testMap.put(2.0+0.01,0.433775491851767);
    testMap.put(1.0/3.0-0.01, -0.701531564175234);
    testMap.put(1.0/3.0, -0.682606194485985);
    testMap.put(1.0/3.0+0.01, -0.664240278029574);
    testMap.put(3.0-0.01, 0.680531618486675);
    testMap.put(3.0, 0.682606194485985);
    testMap.put(3.0+0.01,0.684673866725445);
    testMap.put(1.0/5.0-0.01, -1.03187031571163);
    testMap.put(1.0/5.0, -1.0);
    testMap.put(1.0/5.0+0.01, -0.969684966538633);
    testMap.put(5.0-0.01, 0.998756085801629);
    testMap.put(5.0, 1.0);
    testMap.put(5.0+0.01,1.00124142885366);
    testMap.put(1.0,0.0);
    testMap.put(1.0+0.1, 0.059219544331);
    testMap.put(1.0-0.1, -0.065464169101);

    testMap.put(0.0001,-5.7227062322926);
    testMap.put(0.1,-1.43067655807338);
    testMap.put(1-0.1,-0.0654641691014222);
    testMap.put(1+0.1,0.059219544331585);
    testMap.put(6.56541-0.01,1.16829027600663);
    testMap.put(6.56541,1.16923737390883);
    testMap.put(6.56541+0.01,1.17018303035112);
    testMap.put(10.0,1.43067655807338);
    testMap.put(100.0,2.86135311614677);




    double result = testMap.get(x);
    return result;
  }
}
