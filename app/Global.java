import models.Contact;
import models.ContactDB;
import play.Application;
import play.GlobalSettings;

import java.util.ArrayList;
import java.util.List;

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
    List<String> dietTypesOne = new ArrayList<>();
    List<String> dietTypesTwo = new ArrayList<>();
    List<String> dietTypesThree = new ArrayList<>();
    List<String> dietTypesFour = new ArrayList<>();

    dietTypesOne.add("Fish");
    dietTypesTwo.add("Chicken");
    dietTypesTwo.add("Fish");
    dietTypesTwo.add("Beef");
    dietTypesTwo.add("Dairy");
    dietTypesTwo.add("Gluten");
    dietTypesThree.add("Chicken");
    dietTypesThree.add("Fish");
    dietTypesThree.add("Beef");
    dietTypesThree.add("Dairy");
    ContactDB.addContact(new Contact(1, "Ira", "Fuse", "124-816-3264",
                                     "This is not a real address, just a placeholder", "Mobile", dietTypesOne));
    ContactDB.addContact(new Contact(2, "Dewey", "Havtoo", "112-358-1321",
                                     "This is not a real address, just a placeholder", "Home", dietTypesTwo));
    ContactDB.addContact(new Contact(3, "Millie", "Meter", "123-456-7890",
                                     "This is not a real address, just a placeholder", "Work", dietTypesThree));
    ContactDB.addContact(new Contact(4, "Sandy", "Beech", "101-010-1010",
                                     "This is not a real address, just a placeholder", "Mobile", dietTypesFour));
  }
}
