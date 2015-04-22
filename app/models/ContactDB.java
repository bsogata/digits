package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the Contacts for this application.
 *
 * Created by Branden Ogata on 3/14/2015.
 */
public class ContactDB {

  /**
   * Adds the given ContactFormData to the ContactDB if valid.
   *
   * @param toAdd    The ContactFormData to add to this ContactDB.
   *
   * @return A boolean that is true if the given ContactFormData is valid,
   *                           false otherwise.
   *
   */

  public static boolean addContact(ContactFormData toAdd) {
    // If not in the database, add new Contact
    if ((toAdd.validate() == null) && (toAdd.id == 0)) {
      Contact toCreate = new Contact(toAdd);
      toCreate.save();
      toCreate.getTelephoneType().addContact(toCreate);
      List<DietType> dietTypes = new ArrayList<>();

      for (String diet : toAdd.dietTypes) {
        DietType nextDietType = DietType.find().where().eq("dietType", diet).findUnique();
        dietTypes.add(nextDietType);
        nextDietType.addContact(toCreate);
      }

      toCreate.setDietTypes(dietTypes);

      return true;
    }
    // Else if valid and in the map, update value
    else if (toAdd.validate() == null) {
      Contact toUpdate = Contact.find().byId(toAdd.id);
      toUpdate.setFirstName(toAdd.firstName);
      toUpdate.setLastName(toAdd.lastName);
      toUpdate.setPhoneNumber(toAdd.phoneNumber);
      toUpdate.setAddress(toAdd.address);
      toUpdate.setTelephoneType(TelephoneType.find().where().eq("telephoneType", toAdd.telephoneType).findUnique());

      List<DietType> dietTypes = new ArrayList<>();

      for (String diet : toAdd.dietTypes) {
        DietType nextDietType = DietType.find().where().eq("dietType", diet).findUnique();
        dietTypes.add(nextDietType);
        nextDietType.addContact(toUpdate);
      }

      toUpdate.setDietTypes(dietTypes);

      toUpdate.save();
      toUpdate.getTelephoneType().addContact(toUpdate);
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Returns the List of Contacts stored in the ContactDB.
   *
   * @return A List<Contact> of the Contacts stored in the ContactDB.
   *
   */

  public static List<Contact> getContacts() {
    return Contact.find().all();
  }

  /**
   * Returns the Contact with the given ID number.
   *
   * @param id    The long equal to the ID to search for.
   *
   * @return A Contact that is at the given ID,
   *         null if no match was found.
   *
   */

  public static Contact getContact(long id) {
    return Contact.find().byId(id);
  }

  /**
   * Deletes the Contact with the given ID number.
   *
   * @param id    The long equal to the ID of the Contact to delete.
   *
   */

  public static void deleteContact(long id) {
    Contact.find().byId(id).delete();
  }

  /**
   * Adds the given DietType to the database.
   *
   * @param toAdd    The DietType to add.
   *
   */

  public static void addDietType(DietType toAdd) {
    toAdd.save();
  }

  /**
   * Adds the given TelephoneType to the database.
   *
   * @param toAdd    The TelephoneType to add.
   *
   */

  public static void addTelephoneType(TelephoneType toAdd) {
    toAdd.save();
  }

  /**
   * Returns the DietType with the given name.
   *
   * @param type    The String containing the name of the DietType to retrieve.
   *
   * @return A DietType with the name provided.
   *
   * @throws RuntimeException if no match was found.
   *
   */

  public static DietType getDietType(String type) {
    DietType dietType = DietType.find().where().eq("dietType", type).findUnique();

    if (dietType == null) {
      throw new RuntimeException(type + " is not a valid diet type");
    }

    return dietType;
  }

  /**
   * Returns the TelephoneType with the given name.
   *
   * @param type    The String containing the name of the TelephoneType to retrieve.
   *
   * @return A TelephoneType with the name provided.
   *
   * @throws RuntimeException if no match was found.
   *
   */

  public static TelephoneType getTelephoneType(String type) {
    TelephoneType telephoneType = TelephoneType.find().where().eq("telephoneType", type).findUnique();

    if (telephoneType == null) {
      throw new RuntimeException(type + " is not a valid telephone type");
    }

    return telephoneType;

  }
}
