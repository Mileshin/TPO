import lab2.*;
import lab2.logarithmic.*;
import lab2.trigonometric.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static junit.framework.TestCase.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainFunctionTest {

  private final double D = 1E-40;
  private final double L = 1E-4;

  private double[] testValuesRight = {
          0.0001, 0.1, 1-0.1, 1, 1+0.1, 6.56541-0.01, 6.56541, 6.56541+0.01, 10, 100,
          1/Math.E-0.01, 1/Math.E, 1/Math.E+0.01, Math.E-0.01, Math.E, Math.E+0.01,
          1/2.0-0.01, 1/2.0, 1/2+0.01, 2-0.01, 2, 2+0.01,
          1/3.0-0.01, 1/3.0, 1/3.0+0.01, 3-0.01, 3, 3+0.01,
          1/5.0-0.01, 1/5.0, 1/5.0+0.01, 5-0.01, 5, 5+0.01,
          Double.POSITIVE_INFINITY, Double.NaN};

  private double[] testValuesLeft = {
          -Math.PI/6, -Math.PI*3/4, -Math.PI/4, -Math.PI*5/6, -Math.PI*9/4, -Math.PI*11/6, 0, -0, 0-0.01,
          -Math.PI-0.01, -Math.PI, -Math.PI+0.01, -Math.PI/2-0.01, -Math.PI/2, -Math.PI/2+0.01,
          Double.NEGATIVE_INFINITY, Double.NaN};

  private double[] testValuesTrig = {
          -Math.PI/6, -Math.PI*3/4, -Math.PI*9/4, Math.PI/6, Math.PI*3/4, -Math.PI/4, -Math.PI*5/6, Math.PI*9/4, -Math.PI*11/6, 0, 0-0.01, 0.01,
          Math.PI-0.01, Math.PI, Math.PI+0.01, -Math.PI-0.01, -Math.PI, -Math.PI+0.01,
          Math.PI/2-0.01, Math.PI/2, Math.PI/2+0.01, -Math.PI/2-0.01, -Math.PI/2, -Math.PI/2+0.01,
          Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN};

  private double[] testValuesLog = {
          -0.01, 0, 0.01, 1.0-0.1, 1, 1.0+0.1,
          1/Math.E-0.01, 1/Math.E, 1/Math.E+0.01, Math.E-0.01, Math.E, Math.E+0.01,
          1/2.0-0.01, 1/2.0, 1/2+0.01, 2-0.01, 2, 2+0.01,
          1/3.0-0.01, 1/3.0, 1/3.0+0.01, 3-0.01, 3, 3+0.01,
          1/5.0-0.01, 1/5.0, 1/5.0+0.01, 5-0.01, 5, 5+0.01,
          Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN};


  @Test
  public void integrationLevel0_main_less() {
    MoreThanZero.setStub(true);
    LessOrEqualZero.setStub(true);
    Ln.setStub(true);
    Log_2.setStub(true);
    Log_3.setStub(true);
    Log_5.setStub(true);
    Tangent.setStub(true);
    Cosine.setStub(true);
    Sine.setStub(true);
    for (int i = 0; i < testValuesLeft.length; i++) {
      double actual = MainFunction.calculate(testValuesLeft[i], D);
      double expected = LessOrEqualZero.calculate(testValuesLeft[i], D);
      assertEquals("x: " + testValuesLeft[i], expected, actual, L);
    }
  }


  @Test
  public void integrationLevel0_main_more() {
    MoreThanZero.setStub(true);
    LessOrEqualZero.setStub(true);
    Ln.setStub(true);
    Log_2.setStub(true);
    Log_3.setStub(true);
    Log_5.setStub(true);
    Tangent.setStub(true);
    Cosine.setStub(true);
    Sine.setStub(true);
    for (int i = 0; i < testValuesRight.length; i++) {
      double actual = MainFunction.calculate(testValuesRight[i], D);
      double expected = MoreThanZero.calculate(testValuesRight[i], D);
      assertEquals("x: " + testValuesRight[i], expected, actual, L);
    }
  }


  @Test
  public void integrationLevel1_more() {
    MoreThanZero.setStub(false);
    LessOrEqualZero.setStub(false);
    Ln.setStub(true);
    Log_2.setStub(true);
    Log_3.setStub(true);
    Log_5.setStub(true);
    Tangent.setStub(true);
    Cosine.setStub(true);
    Sine.setStub(true);
    for (int i = 0; i < testValuesRight.length; i++) {
      MoreThanZero.setStub(false);
      double actual = MainFunction.calculate(testValuesRight[i], D);
      MoreThanZero.setStub(true);
      double expected = MoreThanZero.calculate(testValuesRight[i], D);
      assertEquals("x: " + testValuesRight[i], expected, actual, L);
    }
  }


  @Test
  public void integrationLevel1_less() {
    MoreThanZero.setStub(false);
    LessOrEqualZero.setStub(false);
    Ln.setStub(true);
    Log_2.setStub(true);
    Log_3.setStub(true);
    Log_5.setStub(true);
    Tangent.setStub(true);
    Cosine.setStub(true);
    Sine.setStub(true);
    for (int i = 0; i < testValuesLeft.length; i++) {
      double actual = MainFunction.calculate(testValuesLeft[i], D);
      LessOrEqualZero.setStub(true);
      double expected = LessOrEqualZero.calculate(testValuesLeft[i], D);
      LessOrEqualZero.setStub(false);
      assertEquals("x: " + testValuesLeft[i], expected, actual, L);
    }
  }


  @Test
  public void integrationLevel2_logtrig_left() {
    MoreThanZero.setStub(false);
    LessOrEqualZero.setStub(false);
    Ln.setStub(true);
    Log_2.setStub(false);
    Log_3.setStub(false);
    Log_5.setStub(false);
    Tangent.setStub(false);
    Cosine.setStub(false);
    Sine.setStub(true);
    for (int i = 0; i < testValuesLeft.length; i++) {
      //System.out.println(testValuesLeft[i]);
      LessOrEqualZero.setStub(false);
      double actual = MainFunction.calculate(testValuesLeft[i], D);
      LessOrEqualZero.setStub(true);
      double expected = LessOrEqualZero.calculate(testValuesLeft[i], D);
      LessOrEqualZero.setStub(false);
      assertEquals("x: " + testValuesLeft[i] + " " + actual, expected, actual, L);
    }
  }


  @Test
  public void integrationLevel2_logtrig_right() {
    MoreThanZero.setStub(false);
    LessOrEqualZero.setStub(false);
    Ln.setStub(true);
    Log_2.setStub(false);
    Log_3.setStub(false);
    Log_5.setStub(false);
    Tangent.setStub(false);
    Cosine.setStub(false);
    Sine.setStub(true);
    for (int i = 0; i < testValuesRight.length; i++) {
      double actual = MainFunction.calculate(testValuesRight[i], D);
      MoreThanZero.setStub(true);
      double expected = MoreThanZero.calculate(testValuesRight[i], D);
      MoreThanZero.setStub(false);
      assertEquals("x: " + testValuesRight[i], expected, actual, L);
    }
  }

  @Test
  public void integrationLevel3_base_left() {
    MoreThanZero.setStub(false);
    LessOrEqualZero.setStub(false);
    Ln.setStub(false);
    Log_2.setStub(false);
    Log_3.setStub(false);
    Log_5.setStub(false);
    Tangent.setStub(false);
    Cosine.setStub(false);
    Sine.setStub(false);
    for (int i = 0; i < testValuesLeft.length; i++) {
      LessOrEqualZero.setStub(false);
      double actual = MainFunction.calculate(testValuesLeft[i], D);
      LessOrEqualZero.setStub(true);
      double expected = LessOrEqualZero.calculate(testValuesLeft[i], D);
      assertEquals("x: " + testValuesLeft[i], expected, actual, L);
    }
  }


  @Test
  public void integrationLevel3_base_right() {
    MoreThanZero.setStub(false);
    LessOrEqualZero.setStub(false);
    Ln.setStub(false);
    Log_2.setStub(false);
    Log_3.setStub(false);
    Log_5.setStub(false);
    Tangent.setStub(false);
    Cosine.setStub(false);
    Sine.setStub(false);
    for (int i = 0; i < testValuesRight.length; i++) {
      MoreThanZero.setStub(false);
      double actual = MainFunction.calculate(testValuesRight[i], D);
      MoreThanZero.setStub(true);
     double expected = MoreThanZero.calculate(testValuesRight[i], D);
     assertEquals("x: " + testValuesRight[i], expected, actual, L);
    }
  }

  // Testing of logarithmic functions {log2,log3,log5}->ln
  @Test
  public void testFieldLogActual() {
    for (int i = 0; i < testValuesLog.length; i++) {
      Ln.setStub(false);
      double actual = Ln.calculate(testValuesLog[i], D);
      Ln.setStub(true);
      double expected = Ln.calculate(testValuesLog[i], D);
      assertEquals("Ln, x: " + testValuesLog[i], expected, actual, L);
    }

    for (int i = 0; i < testValuesLog.length; i++) {
      Log_3.setStub(false);
      double actual = Log_3.calculate(testValuesLog[i], D);
      Log_3.setStub(true);
      double expected = Log_3.calculate(testValuesLog[i], D);
      assertEquals("Log_3, x: " + testValuesLog[i], expected, actual, L);
    }

    for (int i = 0; i < testValuesLog.length; i++) {
      Log_2.setStub(false);
      double actual = Log_2.calculate(testValuesLog[i], D);
      Log_2.setStub(true);
      double expected = Log_2.calculate(testValuesLog[i], D);
      assertEquals("Log_2, x: " + testValuesLog[i], expected, actual, L);
    }

    for (int i = 0; i < testValuesLog.length; i++) {
      Log_5.setStub(false);
      double actual = Log_5.calculate(testValuesLog[i], D);
      Log_5.setStub(true);
      double expected = Log_5.calculate(testValuesLog[i], D);
      assertEquals("Log_5, x: " + testValuesLog[i], expected, actual, L);
    }
  }

  // Testing of trigonometric functions. tg(x) -> cos(x) -> sin(x)
  @Test
  public void testFieldTrigActual() {

    for (int i = 0; i < testValuesTrig.length; i++) {
      Sine.setStub(false);
      double actual = Sine.calculate(testValuesTrig[i], D);
      Sine.setStub(true);
      double expected = Sine.calculate(testValuesTrig[i], D);
      assertEquals("Sin, x: " + testValuesTrig[i], expected, actual, L);
    }
    Sine.setStub(false);

    for (int i = 0; i < testValuesTrig.length; i++) {
      Cosine.setStub(false);
      double actual = Cosine.calculate(testValuesTrig[i], D);
      Cosine.setStub(true);
      double expected = Cosine.calculate(testValuesTrig[i], D);
      assertEquals("Cos, x: " + testValuesTrig[i], expected, actual, L);
    }



    Sine.setStub(false);
    Cosine.setStub(false);

    for (int i = 0; i < testValuesTrig.length; i++) {
      Tangent.setStub(false);
      double actual = Tangent.calculate(testValuesTrig[i], D);
      Tangent.setStub(true);
      double expected = Tangent.calculate(testValuesTrig[i], D);
      assertEquals("Tg x: " + testValuesTrig[i], expected, actual, L);
    }
  }
}
