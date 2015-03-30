package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Testing support for the NewContact page.
 *
 * Created by Branden Ogata on 3/26/2015.
 */

public class NewContactPage extends FluentPage {
  private String url;

  /**
   * Creates a new NewContactPage.
   *
   * @param driver    The WebDriver that presumably drives this page.
   * @param port      The int equal to the port number to use.
   *
   */

  public NewContactPage(WebDriver driver, int port) {
    super(driver);
    this.url = "http://localhost:" + port + "/newContact";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).contains("NewContact");
  }


  /**
   * Simulates form submission.
   *
   * @param firstName        The String containing the first name of the contact.
   * @param lastName         The String containing the last name of the contact.
   * @param phoneNumber      The String containing the phone number of the contact.
   * @param address          The String containing the address of the contact.
   * @param telephoneType    The String containing the telephone type of the contact.
   *
   */

  public void submitForm(String firstName, String lastName, String phoneNumber,
                         String address, String telephoneType) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#phoneNumber").with(phoneNumber);
    fill("#address").with(address);
    find("#telephoneType").find("option", withId(telephoneType)).click();

    submit("#submit");
  }
}
