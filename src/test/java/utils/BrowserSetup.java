package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSetup {
    private WebDriver webDriver;
    public static WebDriver driver;
    public BrowserSetup() {
        // set directory to your chromedriver
        System.setProperty("webdriver.chrome.driver", "c:/drivers/chromedriver.exe");

        // create chrome options and add argument to run it maximized
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // initialize chromedriver with previously specified options and open browser
        webDriver = new ChromeDriver(options);
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            new BrowserSetup();
        }

        return driver;
    }

    public static void closeDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
