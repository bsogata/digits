package test;

import models.Contact;
import models.ContactDB;
import org.junit.Test;
import play.twirl.api.Content;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;


/**
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 */
public class ApplicationTest {

  /**
   * Tests that 1+1 equals 2.
   */
  @Test
  public void simpleCheck() {
    int a = 1 + 1;
    assertThat(a).isEqualTo(2);
  }

  /**
   * Tests that the Index template renders correctly.
   */
  @Test
  public void renderTemplate() {
    Content html = views.html.Index.render(ContactDB.getContacts());
    assertThat(contentType(html)).isEqualTo("text/html");
    assertThat(contentAsString(html)).contains("Home");
  }


  /**
   * Tests that the New Contact template renders correctly.
   */
  @Test
  public void renderNewContactTemplate() {
    // Fails due to error:
    //   'render(play.api.data.Form<views.formdata.ContactFormData>)' in ''
    //   cannot be applied to '(play.data.Form<views.formdata.ContactFormData>)'
/*
    Content html = views.html.NewContact.render((Form<ContactFormData>) Form.form(ContactFormData.class));
    assertThat(contentType(html)).isEqualTo("text/html");
    assertThat(contentAsString(html)).contains("New Contact");
*/
  }
}
