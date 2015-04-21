package models;

import views.formdata.DietTypes;
import views.formdata.TelephoneTypes;

import java.util.List;

/**
 * A contact in this application.
 *
 * Created by Branden Ogata on 3/14/2015.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private long id;
  private String address;
  private TelephoneType telephoneType;
  private List<DietType> dietTypes;

  /**
   * Creates a new Contact.
   *
   * @param id               The long equal to the ID for the new Contact.
   * @param firstName        The String containing the first name of the new Contact.
   * @param lastName         The String containing the last name of the new Contact.
   * @param phoneNumber      The String containing the phone number of the new Contact.
   * @param address          The String containing the address of the new Contact.
   * @param telephoneType    The TelephoneType containing the telephone type of the new Contact.
   * @param dietTypes        The List<DietType> containing the diet types of the new Contact.
   *
   */

  public Contact(long id, String firstName, String lastName, String phoneNumber,
                 String address, TelephoneType telephoneType, List<DietType> dietTypes) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.telephoneType = telephoneType;
    this.dietTypes = dietTypes;
  }

  /**
   * Returns the ID of this Contact.
   *
   * @return A long equal to the ID number of this Contact.
   *
   */

  public long getId() {
    return this.id;
  }

  /**
   * Returns the first name of this Contact.
   *
   * @return A String containing the first name of this Contact.
   *
   */

  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns the last name of this Contact.
   *
   * @return A String containing the last name of this Contact.
   *
   */

  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns the phone number of this Contact.
   *
   * @return A String containing the phone number of this Contact.
   *
   */

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  /**
   * Returns the address of this Contact.
   *
   * @return A String containing the address of this Contact.
   *
   */

  public String getAddress() {
    return this.address;
  }

  /**
   * Returns the telephone type of this Contact.
   *
   * @return A String containing the telephone type of this Contact.
   *
   */

  public TelephoneType getTelephoneType() {
    return this.telephoneType;
  }

  /**
   * Returns the telephone type of this Contact.
   *
   * @return A String containing the telephone type of this Contact.
   *
   */

  public List<DietType> getDietTypes() {
    return this.dietTypes;
  }

  /**
   * Returns the diet type of this Contact.
   *
   * @return A String containing the diet type of this Contact.
   *
   */
   
  public String getFormattedDietTypes() {
    String s = "";
  
    for (DietType type : this.dietTypes) {
      s += type.getDietType() + ", ";
    }

    if (s.length() > 0) {
      s = s.substring(0, s.length() - 2);
    }

    return s;
  }

  /**
   * Indicates whether this is a valid Contact.
   *
   * @return A boolean that is true if this Contact is valid,
   *                           false otherwise.
   *
   */

  public boolean isValid() {
    return (((this.firstName != null) && (this.firstName.length() > 0))
         && ((this.lastName != null) && (this.lastName.length() > 0))
         && ((this.phoneNumber != null) && (this.phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")))
         && ((this.telephoneType != null) && (TelephoneTypes.isType(this.telephoneType.getTelephoneType())))
         && ((this.address != null) && (this.address.length() >= 24))
         && ((this.dietTypes != null) && (DietTypes.isType(this.dietTypes))));
  }
}
