package models;

import views.formdata.ContactFormData;

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
  private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();
  private static Map<String, DietType> dietTypes = new HashMap<>();

  /**
   * Adds the given ContactFormData to the ContactDB if valid.
   *
   * @param toAdd    The ContactFormData to add to this ContactDB.
   *
   * @return A boolean that is true if the given ContactFormData is valid,
   *                           false otherwise.
   *
   */

  public static boolean addContact(ContactFormData toAdd) {
    // If not in the map, add new Contact
    if ((toAdd.validate() == null) && (toAdd.id == 0)) {
      long id = lastId++;
      toAdd.id = id;
      ContactDB.contacts.put(id, new Contact(toAdd));
      return true;
    }
    // Else if valid and in the map, update value
    else if (toAdd.validate() == null) {
      ContactDB.contacts.put(toAdd.id, new Contact(toAdd));
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Returns the List of Contacts stored in the ContactDB.
   *
   * @return A List<Contact> of the Contacts stored in the ContactDB.
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
   * Adds the given DietType to the database.
   *
   * @param toAdd    The DietType to add.
   *
   */

  public static void addDietType(DietType toAdd) {
    ContactDB.dietTypes.put(toAdd.getDietType(), toAdd);
  }

  /**
   * Adds the given TelephoneType to the database.
   *
   * @param toAdd    The TelephoneType to add.
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
   * @return A DietType with the name provided.
   *
   * @throws RuntimeException if no match was found.
   *
   */

  public static DietType getDietType(String type) {
    if (!ContactDB.dietTypes.containsKey(type)) {
      throw new RuntimeException(type + " is not a valid diet type");
    }

    return ContactDB.dietTypes.get(type);
  }

  /**
   * Returns the TelephoneType with the given name.
   *
   * @param type    The String containing the name of the TelephoneType to retrieve.
   *
   * @return A TelephoneType with the name provided.
   *
   * @throws RuntimeException if no match was found.
   *
   */

  public static TelephoneType getTelephoneType(String type) {
    if (!ContactDB.telephoneTypes.containsKey(type)) {
      throw new RuntimeException(type + " is not a valid telephone type");
    }

    return ContactDB.telephoneTypes.get(type);
  }
}
