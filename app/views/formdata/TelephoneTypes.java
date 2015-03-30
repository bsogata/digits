package views.formdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A backing class that identifies valid types of telephones.
 *
 * Created by Branden Ogata on 3/29/2015.
 *
 */

public class TelephoneTypes {
  private static List<String> allTelephoneTypes = new ArrayList<>();

  static {
    TelephoneTypes.allTelephoneTypes.add("Home");
    TelephoneTypes.allTelephoneTypes.add("Mobile");
    TelephoneTypes.allTelephoneTypes.add("Work");
  }

  /**
   * Returns a map of all telephone types.
   *
   * @return A Map<String, Boolean> where the Strings are the types of phones
   *                                  and the Booleans are all false.
   *
   */

  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> phoneTypes = new HashMap<String, Boolean>();

    for (String type : TelephoneTypes.allTelephoneTypes) {
      phoneTypes.put(type, false);
    }

    return phoneTypes;
  }

  /**
   * Returns a map of all telephone types with the given type selected.
   *
   * @param toSelect    The String containing the name of the type to select.
   *
   * @return A Map<String, Boolean> where the Strings are the types of phones
   *                                  and the Booleans are all false except for the value paired with the given type.
   *
   */

  public static Map<String, Boolean> getTypes(String toSelect) {
    Map<String, Boolean> phoneTypes = getTypes();

    if (TelephoneTypes.isType(toSelect)) {
      phoneTypes.put(toSelect, true);
    }

    return phoneTypes;
  }

  /**
   * Indicates whether the given String represents a valid type of phone.
   *
   * @param toCheck    The String to examine.
   *
   * @return A boolean that is true if the given String matches a valid phone type,
   *                           false otherwise.
   *
   */

  public static boolean isType(String toCheck) {
    return TelephoneTypes.allTelephoneTypes.contains(toCheck);
  }
}
