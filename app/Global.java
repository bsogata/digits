import models.Contact;
import models.ContactDB;
import play.Application;
import play.GlobalSettings;

/**
 * Initializes data.
 * <p>
 * Created by Branden Ogata on 3/29/2015.
 */

public class Global extends GlobalSettings {

  /**
   * Adds four Contacts to ContactDB.
   *
   * @param app The Application that is about to start.
   */

  @Override
  public void onStart(Application app) {
    ContactDB.addContact(new Contact(1, "Ira", "Fuse", "124-816-3264", "This is not really an address.", "Home"));
    ContactDB.addContact(new Contact(2, "Dewey", "Havtoo", "124-816-3264", "This is not really an address.", "Mobile"));
    ContactDB.addContact(new Contact(3, "Sandy", "Beech", "124-816-3264", "This is not really an address.", "Work"));
    ContactDB.addContact(new Contact(4, "Millie", "Meter", "124-816-3264", "This is not really an address.", "Home"));
  }
}
