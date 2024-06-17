package collection;

import java.util.ArrayList;
import java.util.List;



/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    List<Double> output = new ArrayList<>();

    for (Integer x : input) {
      double result = Math.pow((x * 2 + 3), 5);
      output.add(result);
    }

    return output;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    List<String> output = new ArrayList<>();

    for (String str : input) {
      if (str != null && !str.isEmpty()) {
        String DoubleCamel = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        DoubleCamel += DoubleCamel;
        output.add(DoubleCamel);
        return output;
      }
    }
    return null;
  }

}
