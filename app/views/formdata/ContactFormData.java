package views.formdata;

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

    return (errors.isEmpty()) ? (null) : (errors);
  }
}
