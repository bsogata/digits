package models;

import views.formdata.ContactFormData;
import views.formdata.DietTypes;
import views.formdata.TelephoneTypes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * A contact in this application.
 *
 * Created by Branden Ogata on 3/14/2015.
 */

@Entity
public class Contact extends play.db.ebean.Model {
  private String firstName;
  private String lastName;
  private String phoneNumber;

  @Id
  private long id;
  private String address;

  @ManyToOne(cascade=CascadeType.PERSIST)
  private TelephoneType telephoneType;

  @ManyToMany(cascade=CascadeType.PERSIST)
  private List<DietType> dietTypes;

  /**
   * Creates a new Contact.
   *
   * @param firstName        The String containing the first name of the new Contact.
   * @param lastName         The String containing the last name of the new Contact.
   * @param phoneNumber      The String containing the phone number of the new Contact.
   * @param address          The String containing the address of the new Contact.
   * @param telephoneType    The TelephoneType containing the telephone type of the new Contact.
   * @param dietTypes        The List<DietType> containing the diet types of the new Contact.
   *
   */

  public Contact(String firstName, String lastName, String phoneNumber,
                 String address, TelephoneType telephoneType, List<DietType> dietTypes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.telephoneType = telephoneType;
    this.dietTypes = dietTypes;
  }

  /**
   * Creates a new Contact.
   *
   * @param data    The ContactFormData containing the data with which to initialize the new Contact.
   *
   */

  public Contact(ContactFormData data) {
    this.id = data.id;
    this.firstName = data.firstName;
    this.lastName = data.lastName;
    this.phoneNumber = data.phoneNumber;
    this.address = data.address;
    this.telephoneType = ContactDB.getTelephoneType(data.telephoneType);
    this.dietTypes = new ArrayList<>();

    for (String diet : data.dietTypes) {
      this.dietTypes.add(ContactDB.getDietType(diet));
    }
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
   * Sets the ID of this Contact.
   *
   * @param id    The long equal to the ID to assign to this Contact.
   *
   */

  public void setId(long id) {
    this.id = id;
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
   * Sets the first name of this Contact.
   *
   * @param firstName    The String containing the first name to assign to this Contact.
   *
   */

  public void setFirstName(String firstName) {
    this.firstName = firstName;
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
   * Sets the last name of this Contact.
   *
   * @param lastName The String containing the last name to assign to this Contact.
   *
   */

  public void setLastName(String lastName) {
    this.lastName = lastName;
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
   * Sets the phone number of this Contact.
   *
   * @param phoneNumber    The String containing the phone number to assign to this Contact.
   *
   */

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
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
   * Sets the address of this Contact.
   *
   * @param address    The String containing the address to assign to this Contact.
   *
   */

  public void setAddress(String address) {
    this.address = address;
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
   * Sets the telephone type of this Contact.
   *
   * @param telephoneType    The TelephoneType to assign to this Contact.
   *
   */

  public void setTelephoneType(TelephoneType telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Returns the diet type of this Contact.
   *
   * @return A String containing the diet type of this Contact.
   *
   */

  public List<DietType> getDietTypes() {
    return this.dietTypes;
  }

  /**
   * Sets the diet types of this Contact.
   *
   * @param dietTypes    The List<DietTypes> containing the DietTypes to assign to this Contact.
   *
   */

  public void setDietTypes(List<DietType> dietTypes) {
    this.dietTypes = dietTypes;
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

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
  }
}
