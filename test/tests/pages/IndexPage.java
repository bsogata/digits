package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Testing support for the Index view.
 *
 * Created by Branden Ogata on 3/25/2015.
 */

public class IndexPage extends FluentPage {
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

  public IndexPage(WebDriver driver, int port) {
    super(driver);
    this.url = "http://localhost:" + port;
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("digits - Home");
  }
}
