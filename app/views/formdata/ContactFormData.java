package views.formdata;

import models.Contact;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * A backing class for the contact form.
 *
 * Created by Branden Ogata on 3/12/2015.
 */
public class ContactFormData {
  /**
   * The ID number of the contact.
   *
   */
  public long id = 0;

  /**
   * The first name of the contact.
   *
   */
  public String firstName = "";

  /**
   * The last name of the contact.
   *
   */
  public String lastName = "";

  /**
   * The phone number of the contact.
   *
   */
  public String phoneNumber = "";

  /**
   * The address of the contact.
   *
   */
  public String address = "";

  /**
   * The phone type of the contact.
   *
   */
  public String telephoneType = "";


  /**
   * Creates a new ContactFormData instance.
   *
   */

  public ContactFormData() {
    this(new Contact(0, "", "", "", "", ""));
  }

  /**
   * Creates a new ContactFormData instance.
   *
   * @param toCreate    The Contact to base this ContactFormData on.
   *
   */

  public ContactFormData(Contact toCreate) {
    this.id = toCreate.getId();
    this.firstName = toCreate.getFirstName();
    this.lastName = toCreate.getLastName();
    this.phoneNumber = toCreate.getPhoneNumber();
    this.address = toCreate.getAddress();
    this.telephoneType = toCreate.getTelephoneType();
  }

  /**
   * Validates the data inside this backing class.
   *
   * @return    A List<ValidationError> containing the errors if any,
   *            null otherwise.
   *
   */

  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if ((this.firstName == null) || (this.firstName.length() == 0)) {
     errors.add(new ValidationError("firstName", "Invalid first name"));
    }
    if ((this.lastName == null) || (this.lastName.length() == 0)) {
      errors.add(new ValidationError("lastName", "Invalid last name"));
    }
    if ((this.phoneNumber == null) || (!this.phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}"))) {
      errors.add(new ValidationError("phoneNumber", "Invalid phone number"));
    }
    if ((this.address == null) || (this.address.length() < 24)) {
      errors.add(new ValidationError("address", "Invalid address"));
    }
    if ((this.telephoneType == null) || (!TelephoneTypes.isType(this.telephoneType))) {
      errors.add(new ValidationError("telephoneType", "Invalid telephone type"));
    }

    return (errors.isEmpty()) ? (null) : (errors);
  }
}
