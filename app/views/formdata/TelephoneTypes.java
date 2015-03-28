package views.formdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A backing class to represent the different types of telephones.
 *
 * Created by Branden Ogata on 3/27/2015.
 */
public class TelephoneTypes {
  private static List<String> allTelephoneTypes = new ArrayList<>();

  static {
    TelephoneTypes.allTelephoneTypes.add("Home");
    TelephoneTypes.allTelephoneTypes.add("Work");
    TelephoneTypes.allTelephoneTypes.add("Mobile");
  }

  /**
   * Returns a mapping of all telephone types.
   *
   * @return A Map<String, Boolean> where the Strings are the names of the telephone types
   *                                  and the Booleans are false.
   *
   */

  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> telephoneTypes = new HashMap<>();

    for (String type : allTelephoneTypes) {
      telephoneTypes.put(type, false);
    }

    return telephoneTypes;
  }

  /**
   * Returns a mapping of all telephone types where the parameter is selected.
   *
   * @return A Map<String, Boolean> where the Strings are the names of the telephone types
   *                                  and the Booleans indicate whether the element is selected.
   *
   */

  public static Map<String, Boolean> getTypes(String toSelect) {
    Map<String, Boolean> telephoneTypes = getTypes();

    telephoneTypes.put(toSelect, true);

    return telephoneTypes;
  }

  /**
   * Indicates whether the given String is in the list of telephone types.
   *
   * @param toCheck    The String to examine.
   *
   * @return A boolean that is true if the given String is a valid telephone type,
   *                           false otherwise.
   *
   */

  public static boolean isType(String toCheck) {
    return TelephoneTypes.allTelephoneTypes.contains(toCheck);
  }
}
