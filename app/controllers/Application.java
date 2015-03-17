package controllers;

import models.Contact;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
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
   * Returns the New Contact page.
   *
   * @param id    The long equal to the ID of the contact; 0 if new, else an edited contact.
   * @return The NewContact.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? (new ContactFormData()) : (new ContactFormData(ContactDB.getContact(id)));
    return ok(NewContact.render((Form<ContactFormData>) Form.form(ContactFormData.class).fill(data)));

  }

  /**
   * Handles the POST request for the new contact.
   * @return The NewContact page.
   *
   */
  public static Result postContact() {
    Form<ContactFormData> form = Form.form(ContactFormData.class).bindFromRequest();

    if (form.errors().size() > 0) {
      return badRequest(NewContact.render(form));
    }
    else {
      ContactFormData data = form.get();
      ContactDB.addContact(new Contact(data.id, data.firstName, data.lastName, data.phoneNumber));
      System.out.format("%s %s %s%n", data.firstName, data.lastName, data.phoneNumber);
      return ok(NewContact.render(form));
    }
  }

}
