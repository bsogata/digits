package models;

import java.util.ArrayList;
import java.util.List;

/**
 * The valid telephone types.
 *
 * Created by Branden Ogata on 4/20/2015.
 */

public class TelephoneType {
  /**
   * The ID of this TelephoneType.
   *
   * This will be more useful when the database is implemented.
   *
   */
  private long id = 0;

  /**
   * The name of this TelephoneType.
   *
   */
  private String telephoneType = "";

  /**
   * The list of Contacts with this TelephoneType.
   */
  private List<Contact> contacts = new ArrayList<>();

  /**
   * Creates a new TelephoneType.
   *
   * @param telephoneType    The String containing the name to assign to the new TelephoneType.
   *
   */

  public TelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Returns the ID of this TelephoneType.
   *
   * @return A long equal to the ID of this TelephoneType.
   *
   */

  public long getId() {
    return this.id;
  }

  /**
   * Sets the ID of this TelephoneType.
   *
   * @param id    The long equal to the ID to assign to this TelephoneType.
   *
   */

  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns the name of this TelephoneType.
   *
   * @return A String containing the name of this TelephoneType.
   *
   */

  public String getTelephoneType() {
    return this.telephoneType;
  }

  /**
   * Sets the name of this TelephoneType.
   *
   * @param telephoneType    The String containing the name to assign to this TelephoneType.
   *
   */

  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Returns the list of Contacts with this TelephoneType.
   *
   * @return A List<Contact> containing the Contacts with this TelephoneType.
   *
   */

  public List<Contact> getContacts() {
    return this.contacts;
  }

  /**
   * Sets the list of Contacts with this TelephoneType.
   *
   * @param contacts    The List<Contact> containing the Contacts with this TelephoneType.
   *
   */

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Adds a Contact to this TelephoneType.
   *
   * @param toAdd    The Contact to add to this TelephoneType.
   *
   */

  public void addContact(Contact toAdd) {
    this.contacts.add(toAdd);
  }
}
