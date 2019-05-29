package components;

import org.openqa.selenium.By;
import utils.BrowserSetup;

public class AlertsPageObject extends BaseWebControl {
    private By simpleAlertButton = By.id("simple-alert");
    private By simpleAlertLabel = By.id("simple-alert-label");

    public AlertsPageObject() {
        super(BrowserSetup.getDriver());
    }

    public void clickSimpleAlertButton() {
        this.clickElement(simpleAlertButton);
    }

    public String getSimpleAlertLabelText() {
        return this.getText(simpleAlertLabel);
    }
}
