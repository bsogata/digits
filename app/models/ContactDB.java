package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Stores the Contacts for this application.
 *
 * Created by Branden Ogata on 3/14/2015.
 */
public class ContactDB {
  private static Map<Long, Contact> contacts = new HashMap<>();
  private static long lastId = 5;

  /**
   * Stores the valid telephone types.
   *
   */
  private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();

  /**
   * Stores the valid diet types.
   *
   */
  private static Map<String, DietType> dietTypes = new HashMap<>();


  /**
   * Adds the given Contact to this ContactDB if valid.
   *
   * @param toAdd    The Contact to add to this ContactDB.
   *
   * @return A boolean that is true if the given Contact is valid,
   *                           false otherwise.
   *
   */

  public static boolean addContact(Contact toAdd) {
    // If not in the map, add new Contact
    if (toAdd.isValid() && toAdd.getId() == 0) {
      long id = lastId++;
      ContactDB.contacts.put(id, new Contact(id, toAdd.getFirstName(), toAdd.getLastName(),
                                             toAdd.getPhoneNumber(), toAdd.getAddress(),
                                             toAdd.getTelephoneType(), toAdd.getDietTypes()));
      return true;
    }
    // Else if valid and in the map, update value
    else if (toAdd.isValid()) {
      ContactDB.contacts.put(toAdd.getId(), toAdd);
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Returns the List of Contacts stored in this ContactDB.
   *
   * @return A List<Contact> of the Contacts stored in this ContactDB.
   *
   */

  public static List<Contact> getContacts() {
    return new ArrayList<Contact>(ContactDB.contacts.values());
  }

  /**
   * Returns the Contact with the given ID number.
   *
   * @param id    The long equal to the ID to search for.
   *
   * @return A Contact that is at the given ID,
   *         null if no match was found.
   *
   */

  public static Contact getContact(long id) {
    return ContactDB.contacts.get(id);
  }

  /**
   * Deletes the Contact with the given ID number.
   *
   * @param id    The long equal to the ID of the Contact to delete.
   *
   */

  public static void deleteContact(long id) {
    ContactDB.contacts.remove(id);
  }

  /**
   * Adds a DietType to the database.
   *
   * @param toAdd    The DietType to add to the ContactDB.
   *
   */

  public static void addDietType(DietType toAdd) {
    ContactDB.dietTypes.put(toAdd.getDietType(), toAdd);
  }

  /**
   * Adds a TelephoneType to the database.
   *
   * @param toAdd    The TelephoneType to add to the ContactDB.
   *
   */

  public static void addTelephoneType(TelephoneType toAdd) {
    ContactDB.telephoneTypes.put(toAdd.getTelephoneType(), toAdd);
  }

  /**
   * Returns the DietType with the given name.
   *
   * @param type    The String containing the name of the DietType to retrieve.
   *
   * @return A DietType instance with the given name.
   *
   * @throws RuntimeException if no matching DietType instance could be found.
   *
   */

  public static DietType getDietType(String type) {
    if (ContactDB.dietTypes.containsKey(type)) {
      return ContactDB.dietTypes.get(type);
    }
    else {
      throw new RuntimeException("Invalid diet type");
    }
  }

  /**
   * Returns the TelephoneType with the given name.
   *
   * @param type    The String containing the name of the TelephoneType to retrieve.
   *
   * @return A TelephoneType instance with the given name.
   *
   * @throws RuntimeException if no matching TelephoneType instance could be found.
   *
   */

  public static TelephoneType getTelephoneType(String type) {
    if (ContactDB.telephoneTypes.containsKey(type)) {
      return ContactDB.telephoneTypes.get(type);
    }
    else {
      throw new RuntimeException("Invalid telephone type");
    }
  }

}
