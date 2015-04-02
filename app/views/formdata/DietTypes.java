package views.formdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A backing class that identifies valid types of diet types.
 * <p>
 * Created by Branden Ogata on 3/29/2015.
 */

public class DietTypes {
  private static List<String> dietTypes = new ArrayList<>();

  static {
    DietTypes.dietTypes.add("Chicken");
    DietTypes.dietTypes.add("Fish");
    DietTypes.dietTypes.add("Beef");
    DietTypes.dietTypes.add("Dairy");
    DietTypes.dietTypes.add("Gluten");
  }

  /**
   * Returns a map of all diet types.
   *
   * @return A Map<String, Boolean> where the Strings are the types of diets
   * and the Booleans are all false.
   */

  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> dietTypes = new HashMap<String, Boolean>();

    for (String type : DietTypes.dietTypes) {
      dietTypes.put(type, false);
    }

    return dietTypes;
  }

  /**
   * Returns a map of all diet types with the given type selected.
   *
   * @param toSelect The String containing the name of the type to select.
   * @return A Map<String, Boolean> where the Strings are the types of diet
   * and the Booleans are all false except for the value paired with the given type.
   */

  public static Map<String, Boolean> getTypes(List<String> toSelect) {
    Map<String, Boolean> dietTypes = getTypes();
    for (String type : toSelect) {
      if (DietTypes.isType(type)) {
        dietTypes.put(type, true);
      }
    }

    return dietTypes;
  }

  /**
   * Indicates whether the given String represents a valid type of diet.
   *
   * @param toCheck The String to examine.
   * @return A boolean that is true if the given String matches a valid diet type,
   * false otherwise.
   */

  public static boolean isType(String toCheck) {
    return DietTypes.dietTypes.contains(toCheck);
  }

  /**
   * Indicates whether the given String represents a valid type of diet.
   *
   * @param toCheck The String to examine.
   * @return A boolean that is true if the given String matches a valid diet type,
   * false otherwise.
   */

  public static boolean isType(List<String> toCheck) {
    Map<String, Boolean> dietTypes = getTypes();
    for (String type : toCheck) {
      if (!DietTypes.isType(type)) {
        return false;
      }
    }
    return true;
  }
}