package controllers;

import models.Contact;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.NewContact;
import views.formdata.ContactFormData;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Returns newContact, a simple example of a second page to illustrate navigation.
   * @param id    The long equal to the Contact ID.
   * @return The NewContact.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? (new ContactFormData()) : (new ContactFormData(ContactDB.getContact(id)));
    return ok(NewContact.render((Form<ContactFormData>) Form.form(ContactFormData.class).fill(data),
                                TelephoneTypes.getTypes(data.telephoneType)));
  }

  /**
   * Handles the POST request for the new contact.
   * @return The NewContact page.
   *
   */
  public static Result postContact() {
    Form<ContactFormData> form = Form.form(ContactFormData.class).bindFromRequest();

    if (form.errors().size() > 0) {
      return badRequest(NewContact.render(form, TelephoneTypes.getTypes()));
    }
    else {
      ContactFormData data = form.get();
      ContactDB.addContact(new Contact(0, data.firstName, data.lastName,
                                       data.phoneNumber, data.address, data.telephoneType));
      System.out.format("%s %s %s %s %s%n", data.firstName, data.lastName, data.phoneNumber,
                                            data.address, data.telephoneType);
      return ok(NewContact.render(form, TelephoneTypes.getTypes(data.telephoneType)));
    }
  }

  /**
   * Removes the given contact and returns the index page.
   *
   * @param id    The long equal to the ID of the Contact to remove.
   *
   * @return The index page.
   *
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
  }

}
