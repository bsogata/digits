package views.formdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A backing class representing the different types of telephones.
 *
 * Created by Branden Ogata on 3/27/2015.
 */
public class TelephoneTypes {
  private static List<String> allPhoneTypes = new ArrayList<>();

  static {
    allPhoneTypes.add("Home");
    allPhoneTypes.add("Work");
    allPhoneTypes.add("Mobile");
  }

  /**
   * Returns a Map containing telephone types.
   *
   * @return A Map<String, Boolean> where the Strings represent phone types and the Booleans are false.
   *
   */

  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> phoneTypes = new HashMap<>();

    for (String type : TelephoneTypes.allPhoneTypes) {
      phoneTypes.put(type, false);
    }

    return phoneTypes;
  }

  /**
   * Indicates whether the given String represents a valid phone type.
   *
   * @param candidate    The String equal to the value to check.
   *
   * @return A boolean that is true if the candidate is valid,
   *                           false otherwise.
   *
   */

  public static boolean isType(String candidate) {
    return TelephoneTypes.allPhoneTypes.contains(candidate);
  }

  /**
   * Returns a Map containing telephone types where the given type is selected.
   *
   * @param toSelect    The String containing the value to select in the returned Map.
   *
   * @return A Map<String, Boolean> where Strings represent phone types
   *         and Booleans indicate if the type is selected.
   *
   */

  public static Map<String, Boolean> getTypes (String toSelect) {
    Map<String, Boolean> phoneTypes = TelephoneTypes.getTypes();

    phoneTypes.put(toSelect, true);

    return phoneTypes;
  }

}
