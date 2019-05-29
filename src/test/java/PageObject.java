import org.openqa.selenium.WebDriver;
import utils.BrowserSetup;

public class PageObject {
    private BrowserSetup browserSetup;
    private WebDriver driver;

    public PageObject() {
        setUpBrowser();
    }


    private void setUpBrowser() {
        browserSetup = new BrowserSetup();
        driver = browserSetup.getWebDriver();
    }

    public void openAllegroPage() {
        driver.get("www.allegro.pl");
    }

    public void closeBrowser() {
        driver.close();
    }


}
