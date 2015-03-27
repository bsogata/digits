package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Testing support for the Index page.
 *
 * Created by Branden Ogata on 3/26/2015.
 */

public class IndexPage extends FluentPage {
  private String url;

  /**
   * Creates a new IndexPage.
   *
   * @param driver    The WebDriver that presumably drives this page.
   * @param port      The int equal to the port number to use.
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
    assertThat(title()).contains("Home");
  }

}
