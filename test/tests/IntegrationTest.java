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
  private final int port = 3333;

  /**
   * Check to see that both the index and newContact pages can be retrieved.
   */
  @Test
  public void test() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        assertThat(browser.pageSource()).contains("Home");

        browser.goTo("http://localhost:3333/newContact");
        assertThat(browser.pageSource()).contains("New Contact");
      }
    });
  }

  /**
   * Tests that the Index page can be retrieved.
   *
   */

  @Test
  public void testRetrieveIndexPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        IndexPage index = new IndexPage(browser.getDriver(), port);
        browser.goTo(index);
        index.isAt();
      }
    });
  }

  /**
   * Tests that creating a new Contact works.
   *
   */

  @Test
  public void testCreateNewContact() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();

        // Go to New Contact and submit form
        NewContactPage newContact = new NewContactPage(browser.getDriver(), port);
        browser.goTo(newContact);
        String firstName = "Ira";
        String lastName = "Fuse";
        String phoneNumber = "124-816-3264";
        String address = "This is not actually an address, just a string long enough to pass the validation";
        newContact.isAt();
        newContact.submitForm(firstName, lastName, phoneNumber, address);

        // Now go to the Index view to ensure that the values from the form submission are displayed
        IndexPage index = new IndexPage(browser.getDriver(), port);
        browser.goTo(index);
        index.isAt();
        assertThat(browser.pageSource()).contains(firstName);
        assertThat(browser.pageSource()).contains(lastName);
        assertThat(browser.pageSource()).contains(phoneNumber);
        assertThat(browser.pageSource()).contains(address);
      }
    });
  }
}
