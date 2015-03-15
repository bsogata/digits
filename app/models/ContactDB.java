package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the Contacts for this application.
 *
 * Created by Branden Ogata on 3/14/2015.
 */
public class ContactDB {

  /**
   * The List to store Contacts.
   *
   */
  private static List<Contact> contacts = new ArrayList<>();

  /**
   * Adds the given Contact to the "database".
   *
   * @param toAdd    The Contact to add to this ContactDB.
   *
   * @return A boolean that is true if the operation was successful,
   *                           false otherwise (ex. if the Contact is invalid).
   *
   */

  public static boolean addContact(Contact toAdd) {
    if (toAdd.isValid()) {
      ContactDB.contacts.add(toAdd);
      return true;
    }
    else {
      System.out.println("Error");
      return false;
    }
  }

  /**
   * Returns the List of Contacts.
   *
   * @return A List<Contact> containing the Contacts.
   *
   */

  public static List<Contact> getContacts() {
    return ContactDB.contacts;
  }
}
