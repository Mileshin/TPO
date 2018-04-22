package lab2;

public class MainFunction {
  public static double calculate(double x, double accuracy) {
    double result = (x <= 0) ? (LessOrEqualZero.calculate(x, accuracy)) : (MoreThanZero.calculate(x, accuracy));
    return result;
  }

}
