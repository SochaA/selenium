import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestBase {

    PageObject pageObject = new PageObject();

    @BeforeMethod
    public void setUp() {
        pageObject.openAllegroPage();
    }

    @AfterMethod
    public void tearDown() {
        // close chromedriver and browser
        pageObject.closeBrowser();
    }


}

