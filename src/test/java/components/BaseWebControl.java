package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class  BaseWebControl {
    private WebDriver driver;

    protected BaseWebControl(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public String getText(By element) {
        return waitForElementToBeVisible(element).getText();
    }

    protected void clickElement(By element) {
        waitForElementToBeVisible(element).click();
    }

    protected void sendText(By element, String text) {
        waitForElementToBeVisible(element).sendKeys(text);
    }

    private WebElement waitForElementToBeVisible(By elementIdentifier) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(elementIdentifier));
    }

    public void waitForTextToBePresentInElement(By elementIdentifier, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = findElement(elementIdentifier);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}
