package tests;

import components.AlertsPageObject;
import components.TablePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CorrectTests extends BaseTest {
    public CorrectTests() {
        super("http://seleniumui.tc-sii.com");
    }

    @Test
    public void alertPopupShouldBeClosedCorrectly() {
        TablePageObject tablePageObject = new TablePageObject();
        tablePageObject.clickBasicFunctionsDropdown();
        tablePageObject.clickAlertDropdownItem();

        AlertsPageObject alertsPageObject = new AlertsPageObject();
        alertsPageObject.clickSimpleAlertButton();
        alertsPageObject.acceptAlert();

        Assert.assertTrue(alertsPageObject.getSimpleAlertLabelText().contains("OK button pressed"));
    }
}
