package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Testing support for the New Contact view.
 *
 * Created by Branden Ogata on 3/25/2015.
 */

public class NewContactPage extends FluentPage {
  /**
   * The URL of the page.
   *
   */
  private String url;

  /**
   * Creates a new IndexPage.
   *
   * @param driver    The WebDriver that serves as the driver.
   * @param port      The int equal to the number of the port used.
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
    assertThat(title()).isEqualTo("digits - NewContact");
  }

  /**
   * Fills the form in the New Contact view with the given data, then sends the form.
   *
   * @param firstName      The String containing the first name of the contact to create.
   * @param lastName       The String containing the last name of the contact to create.
   * @param phoneNumber    The String containing the phone number of the contact to create.
   * @param address        The String containing the address of the contact to create.
   *
   */

  public void submitForm(String firstName, String lastName, String phoneNumber, String address) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#phoneNumber").with(phoneNumber);
    fill("#address").with(address);
    submit("#submit");
  }
}
