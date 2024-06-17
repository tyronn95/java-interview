package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    try {
      if (n < 0) {
        throw new IllegalArgumentException("Only positive number (or zero) are accepted");
      }

      int result = 1;
      for (int j = 0; j < n; j++) {
        result *= i;
      }

      return Option.of(result);

    } catch (IllegalArgumentException e) {
      System.err.println("An error occurred: " + e.getMessage());
      return Option.none();
    }
  }

}
