import models.Contact;
import models.ContactDB;
import models.DietType;
import models.TelephoneType;
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
    ContactDB.addTelephoneType(new TelephoneType("Mobile"));
    ContactDB.addTelephoneType(new TelephoneType("Home"));
    ContactDB.addTelephoneType(new TelephoneType("Work"));
    ContactDB.addDietType(new DietType("Chicken"));
    ContactDB.addDietType(new DietType("Fish"));
    ContactDB.addDietType(new DietType("Beef"));
    ContactDB.addDietType(new DietType("Dairy"));
    ContactDB.addDietType(new DietType("Gluten"));

    List<DietType> dietTypesOne = new ArrayList<>();
    List<DietType> dietTypesTwo = new ArrayList<>();
    List<DietType> dietTypesThree = new ArrayList<>();
    List<DietType> dietTypesFour = new ArrayList<>();

    dietTypesOne.add(ContactDB.getDietType("Fish"));
    dietTypesTwo.add(ContactDB.getDietType("Chicken"));
    dietTypesTwo.add(ContactDB.getDietType("Fish"));
    dietTypesTwo.add(ContactDB.getDietType("Beef"));
    dietTypesTwo.add(ContactDB.getDietType("Dairy"));
    dietTypesTwo.add(ContactDB.getDietType("Gluten"));
    dietTypesThree.add(ContactDB.getDietType("Chicken"));
    dietTypesThree.add(ContactDB.getDietType("Fish"));
    dietTypesThree.add(ContactDB.getDietType("Beef"));
    dietTypesThree.add(ContactDB.getDietType("Dairy"));
    ContactDB.addContact(new Contact(1, "Ira", "Fuse", "124-816-3264",
                                     "This is not a real address, just a placeholder",
                                     ContactDB.getTelephoneType("Mobile"), dietTypesOne));
    ContactDB.addContact(new Contact(2, "Dewey", "Havtoo", "112-358-1321",
                                     "This is not a real address, just a placeholder",
                                     ContactDB.getTelephoneType("Home"), dietTypesTwo));
    ContactDB.addContact(new Contact(3, "Millie", "Meter", "123-456-7890",
                                     "This is not a real address, just a placeholder",
                                     ContactDB.getTelephoneType("Work"), dietTypesThree));
    ContactDB.addContact(new Contact(4, "Sandy", "Beech", "101-010-1010",
                                     "This is not a real address, just a placeholder",
                                     ContactDB.getTelephoneType("Mobile"), dietTypesFour));
  }
}
