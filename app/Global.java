import models.Contact;
import models.ContactDB;
import play.Application;
import play.GlobalSettings;

/**
 * Adds seed data upon startup.
 *
 * Created by Branden Ogata on 3/30/2015.
 *
 */
public class Global extends GlobalSettings {

  /**
   * Populates ContactDB.
   *
   * @param app    The Application to start.
   *
   */

  @Override
  public void onStart(Application app) {
    ContactDB.addContact(new Contact(1, "Ira", "Fuse", "124-816-3264",
                                     "This is not a real address, just a placeholder", "Mobile"));
    ContactDB.addContact(new Contact(2, "Dewey", "Havtoo", "112-358-1321",
                                     "This is not a real address, just a placeholder", "Home"));
    ContactDB.addContact(new Contact(3, "Millie", "Meter", "123-456-7890",
                                     "This is not a real address, just a placeholder", "Work"));
    ContactDB.addContact(new Contact(4, "Sandy", "Beech", "101-010-1010",
                                     "This is not a real address, just a placeholder", "Mobile"));
  }
}
