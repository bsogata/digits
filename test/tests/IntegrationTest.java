package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;
import tests.pages.NewContactPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs a server with a fake in-memory database to test the system.
 */
public class IntegrationTest {
  private static final int PORT = 3333;

  /**
   * Check to see that both the index and newContact pages can be retrieved.
   */
  @Test
  public void test() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        assertThat(browser.pageSource()).contains("Home");

        browser.goTo("http://localhost:3333/newContact");
        assertThat(browser.pageSource()).contains("New Contact");
      }
    });
  }

  /**
   * Tests that the index page is properly retrieved.
   *
   */

  @Test
  public void testRetrieveIndexPage() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        IndexPage index = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(index);
        index.isAt();
      }
    });
  }

  /**
   * Tests addition of a new contact.
   *
   */

  @Test
  public void testCreateNewContact() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();

        // Add new contact
        NewContactPage newContact = new NewContactPage(browser.getDriver(), PORT);
        browser.goTo(newContact);
        newContact.isAt();
        String firstName = "Ira";
        String lastName = "Fuse";
        String phoneNumber = "124-816-3264";
        String address = "This is not really an address, just a placeholder.";
        String telephoneType = "Mobile";

        newContact.submitForm(firstName, lastName, phoneNumber, address, telephoneType);

        IndexPage index = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(index);
        index.isAt();
        assertThat(browser.pageSource()).contains(firstName);
        assertThat(browser.pageSource()).contains(lastName);
        assertThat(browser.pageSource()).contains(phoneNumber);
        assertThat(browser.pageSource()).contains(address);
        assertThat(browser.pageSource()).contains(telephoneType);
      }
    });
  }


}
