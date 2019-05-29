package components;

import org.openqa.selenium.By;
import utils.BrowserSetup;

public class TablePageObject extends BaseWebControl {
    private By basicFunctionsDropdown = By.xpath("//a[@class='nav-link dropdown-toggle'][1]");

    public TablePageObject() {
        super(BrowserSetup.getDriver());
    }

    public void clickBasicFunctionsDropdown() {
        this.clickElement(basicFunctionsDropdown);
    }

    private void clickDropdownItem(String text) {
        this.clickElement(By.id(text + "-item"));
    }

    public void clickAlertDropdownItem() {
        this.clickDropdownItem("alerts");
    }
}
