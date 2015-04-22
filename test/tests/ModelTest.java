package tests;

import models.Contact;
import models.ContactDB;
import models.DietType;
import models.TelephoneType;
import org.junit.Test;
import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;
import static play.test.Helpers.inMemoryDatabase;

/**
 * Tests that models are properly implemented.
 *
 * Created by Branden Ogata on 4/21/2015.
 *
 */
public class ModelTest {
  /**
   * Checks that the Contact, DietType, and TelephoneType models all interact properly.
   *
   */

  @Test
  public void test() {
    running(fakeApplication(inMemoryDatabase()), new Runnable() {
      public void run() {
        // Ensure that the global data is already set up
        assertThat(TelephoneType.find().all().size()).isEqualTo(3);
        assertThat(DietType.find().all().size()).isEqualTo(5);

        // Create a test contact
        List<DietType> dietTypes = new ArrayList<>();
        dietTypes.add(ContactDB.getDietType("Chicken"));
        dietTypes.add(ContactDB.getDietType("Fish"));
        dietTypes.add(ContactDB.getDietType("Beef"));
        dietTypes.add(ContactDB.getDietType("Dairy"));

        Contact testContact = new Contact("Marcus", "Absent", "808-123-4567", "This is a very annoying exercise",
                                          TelephoneType.find().where().eq("telephoneType", "Mobile").findUnique(),
                                          dietTypes);
        ContactDB.addContact(new ContactFormData(testContact));

        // Verify that the relationships between the models work properly
        Contact contactInDatabase = Contact.find().where().eq("firstName", "Marcus").findUnique();
        assertThat(contactInDatabase.getTelephoneType()).isEqualTo(ContactDB.getTelephoneType("Mobile"));
        assertThat(contactInDatabase.getDietTypes()).contains(ContactDB.getDietType("Chicken"));
        assertThat(contactInDatabase.getDietTypes()).contains(ContactDB.getDietType("Fish"));
        assertThat(contactInDatabase.getDietTypes()).contains(ContactDB.getDietType("Beef"));
        assertThat(contactInDatabase.getDietTypes()).contains(ContactDB.getDietType("Dairy"));

        assertThat(ContactDB.getTelephoneType("Mobile").getContacts()).contains(contactInDatabase);
        assertThat(ContactDB.getDietType("Chicken").getContacts()).contains(contactInDatabase);
        assertThat(ContactDB.getDietType("Fish").getContacts()).contains(contactInDatabase);
        assertThat(ContactDB.getDietType("Beef").getContacts()).contains(contactInDatabase);
        assertThat(ContactDB.getDietType("Dairy").getContacts()).contains(contactInDatabase);
      }
    });
  }


}

