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
  private static long lastId = 1;

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
                                             toAdd.getTelephoneType()));
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
}
