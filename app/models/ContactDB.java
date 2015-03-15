package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the Contacts for this application.
 *
 * Created by Branden Ogata on 3/14/2015.
 */
public class ContactDB {
  private static List<Contact> contacts = new ArrayList<>();

  /**
   * Adds the given Contact to the list if valid.
   *
   * @param toAdd    The Contact to add to this ContactDB.
   *
   * @return A boolean that is true if the given Contact is valid,
   *                           false otherwise.
   *
   */

  public static boolean addContact(Contact toAdd) {
    if (toAdd.isValid()) {
      ContactDB.contacts.add(toAdd);
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
    return ContactDB.contacts;
  }
}
