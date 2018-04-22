package lab2;

import lab2.logarithmic.*;
import lab2.trigonometric.*;

public class App {
  public static void main( String[] args ) {
    double acc = 1E-4;

    double start = -0;
    double end = 0;
    double step = 0.1;

    double a = Double.POSITIVE_INFINITY;
    double b = Double.POSITIVE_INFINITY;

    try {
      start = Double.parseDouble(args[0]);
      end = Double.parseDouble(args[1]);
      step = Double.parseDouble(args[2]);
    }
    catch (Exception e) {
      System.out.println("Usage: java lab2.App [start] [end] [step]");
    }
    MoreThanZero.setStub(false);
    LessOrEqualZero.setStub(false);
    Ln.setStub(false);
    Log_2.setStub(false);
    Log_3.setStub(false);
    Log_5.setStub(false);
    Tangent.setStub(false);
    Cosine.setStub(false);
    Sine.setStub(false);
 
    Dumper dump = new Dumper("log.csv");
   
    for (double x = start; x < end; x += step) {
       double cos = Cosine.calculate(x, acc);
       double tg = Tangent.calculate(x, acc);
       double sin = Sine.calculate(x, acc);
 
       double ln = Ln.calculate(x, acc);
       double log_2 = Log_2.calculate(x, acc);
       double log_3 = Log_3.calculate(x, acc);
       double log_5 = Log_5.calculate(x, acc);
 
       double left = LessOrEqualZero.calculate(x, acc);
       double right = MoreThanZero.calculate(x, acc);
 
       double main = MainFunction.calculate(x, acc);
       
       dump.writeLine(x, cos, tg, sin, ln, log_2, log_3, log_5, left, right, main);
 
     }
 
    dump.close();
  }
}
