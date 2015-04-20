package models;

import java.util.ArrayList;
import java.util.List;

/**
 * The valid diet types.
 *
 * Created by Branden Ogata on 4/20/2015.
 */

public class DietType {
  /**
   * The ID of this DietType.
   *
   * This will be more useful when the database is implemented.
   *
   */
  private long id = 0;

  /**
   * The name of this DietType.
   *
   */
  private String dietType = "";

  /**
   * The list of Contacts with this DietType.
   */
  private List<Contact> contacts = new ArrayList<>();

  /**
   * Creates a new DietType.
   *
   * @param dietType    The String containing the name to assign to the new DietType.
   *
   */

  public DietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * Returns the ID of this DietType.
   *
   * @return A long equal to the ID of this DietType.
   *
   */

  public long getId() {
    return this.id;
  }

  /**
   * Sets the ID of this DietType.
   *
   * @param id    The long equal to the ID to assign to this DietType.
   *
   */

  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns the name of this DietType.
   *
   * @return A String containing the name of this DietType.
   *
   */

  public String getDietType() {
    return this.dietType;
  }

  /**
   * Sets the name of this DietType.
   *
   * @param dietType    The String containing the name to assign to this DietType.
   *
   */

  public void setDietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * Returns the list of Contacts with this DietType.
   *
   * @return A List<Contact> containing the Contacts with this DietType.
   *
   */

  public List<Contact> getContacts() {
    return this.contacts;
  }

  /**
   * Sets the list of Contacts with this DietType.
   *
   * @param contacts    The List<Contact> containing the Contacts with this DietType.
   *
   */

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Adds a Contact to this DietType.
   *
   * @param toAdd    The Contact to add to this DietType.
   *
   */

  public void addContact(Contact toAdd) {
    this.contacts.add(toAdd);
  }
}
