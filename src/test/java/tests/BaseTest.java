package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserSetup;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private WebDriver driver;
    private String url;

    public BaseTest(String url) {
        this.url = url;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = BrowserSetup.getDriver();
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        Thread.sleep(10000);
        BrowserSetup.closeDriver();
    }
}
