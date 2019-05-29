import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserSetup;

//import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//import java.time.Instant;


public class  MyFirstTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowserSetup().getWebDriver();
    }

    //Exercises

    @Test
    public void Alert1() throws InterruptedException {
        driver.get("http://seleniumui.tc-sii.com");

        WebElement menuBasics = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][1]"));
        menuBasics.click();
        WebElement menuAlerts = driver.findElement(By.id("alerts-item"));
        menuAlerts.click();
        WebElement simpleAlertButton = driver.findElement((By.xpath("//button[@id='simple-alert']")));
        simpleAlertButton.click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.getPageSource().contains("OK button pressed"));
    }

    @Test
    public void Alert2() throws InterruptedException {
        driver.get("http://seleniumui.tc-sii.com");

        WebElement menuBasics = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][1]"));
        menuBasics.click();
        WebElement menuAlerts = driver.findElement(By.id("alerts-item"));
        menuAlerts.click();
        WebElement promptButton = driver.findElement((By.xpath("//button[@id='prompt-alert']")));
        promptButton.click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.getPageSource().contains("Hello Lord Vader! How are you today?"));
    }

    @Test
    public void Alert3() throws InterruptedException {
        driver.get("http://seleniumui.tc-sii.com");

        WebElement menuBasics = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][1]"));
        menuBasics.click();
        WebElement menuAlerts = driver.findElement(By.id("alerts-item"));
        menuAlerts.click();
        WebElement confirmButton = driver.findElement((By.xpath("//button[@id='confirm-alert']")));
        confirmButton.click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.getPageSource().contains("You pressed OK!"));
        confirmButton.click();
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.getPageSource().contains("You pressed Cancel!"));
    }

    public void waitForAlert(WebDriver driver) throws InterruptedException {
        int i = 0;
        while (i++ < 10) {
            try {
                Alert alert = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                Thread.sleep(1000);
                continue;
            }
        }
    }

    @Test
    public void Alert4() throws InterruptedException {
        driver.get("http://seleniumui.tc-sii.com");

        WebElement menuBasics = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][1]"));
        menuBasics.click();
        WebElement menuAlerts = driver.findElement(By.id("alerts-item"));
        menuAlerts.click();
        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='delayed-alert']"));
        confirmButton.click();

        waitForAlert(driver);
        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.getPageSource().contains("OK button pressed"));
    }

    @Test
    public void Form1() throws InterruptedException {
        driver.get("http://seleniumui.tc-sii.com");

        WebElement menuBasics = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][1]"));
        menuBasics.click();
        WebElement menuForm = driver.findElement(By.id("form-item"));
        menuForm.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='inputFirstName3']"));
        firstName.sendKeys("Denerys");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='inputLastName3']"));
        lastName.sendKeys("Targaryen");
        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail3']"));
        email.sendKeys("DankaT@got.com");

        List<WebElement> radios = driver.findElements(By.xpath("//input[@name='gridRadiosSex']"));
        Random gen = new Random();
        WebElement radio = radios.get(gen.nextInt(radios.size()));
        radio.click();

        WebElement age = driver.findElement(By.xpath("//input[@id='inputAge3']"));
        age.sendKeys("89");

        List<WebElement> radios2 = driver.findElements(By.xpath("//input[@name='gridRadiosExperience']"));
        Random gen2 = new Random();
        WebElement radio2 = radios2.get(gen2.nextInt(radios2.size()));
        radio2.click();


        WebElement profession = driver.findElement(By.xpath("//input[@id='gridCheckAutomationTester']"));
        profession.click();

        List<WebElement> continents = driver.findElements(By.xpath("//select[@id='selectContinents']/option"));
        Random gen3 = new Random();
        Select drpDown = new Select(driver.findElement(By.id("selectContinents")));
        drpDown.selectByIndex(gen3.nextInt(continents.size()));

        Select customSelect = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        customSelect.selectByVisibleText("Switch Commands");
        customSelect.selectByVisibleText("Wait Commands");
//upload file
        WebElement uploadFile = driver.findElement(By.id("chooseFile"));
//        System.out.println(System.getProperty("user.dir") + "\\plik.txt");
        uploadFile.sendKeys(System.getProperty("user.dir") + "\\plik.txt.txt");

        WebElement singInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        singInButton.click();
        Assert.assertTrue(driver.getPageSource().contains("Form send with success"));
    }

    @Test
    public void iframes() throws InterruptedException {
        driver.get("http://seleniumui.tc-sii.com");

        WebElement menuBasics = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][1]"));
        menuBasics.click();
        WebElement menuIframes = driver.findElement(By.id("iframes-item"));
        menuIframes.click();

        driver.switchTo().frame("iframe1");
        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Agata");
        WebElement lastName = driver.findElement(By.id("inputSurname3"));
        lastName.sendKeys("Soxoxo");
        WebElement singIn = driver.findElement(By.xpath("//button[@type='submit']"));
        singIn.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");
        WebElement login = driver.findElement(By.id("inputLogin"));
        login.sendKeys("AgataS");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("AgataSss");

        Select continents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        continents.selectByVisibleText("Asia");

        WebElement radio3 = driver.findElement(By.id("gridRadios3"));
        radio3.click();
        WebElement singIn2 = driver.findElement(By.xpath("//button[@type='submit']"));
        singIn2.click();

        driver.switchTo().defaultContent();
        menuBasics.click();

    }

    @Test
    public void tables() throws InterruptedException {
        driver.get("http://seleniumui.tc-sii.com");

        WebElement menuBasics = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][1]"));
        menuBasics.click();
        WebElement menuTables = driver.findElement(By.id("table-item"));
        menuTables.click();

        for (int i = 1; i < 14; i++) {
            WebElement row = driver.findElement(By.xpath("/html/body/main/div/table/tbody/tr[" + i +"]"));
            for(int j = 1; j < 6; j++) {
                row.findElement(By.xpath("/td[" + j + "]")).getText();
            }
        }

        List<String[]> abc = new LinkedList<>();

//        row.forEach(wiersz -> {
//            System.out.println(wiersz.getText());
//            abc.add(wiersz.getText().split(" "));
//        });

        abc.forEach(wiersz -> {
            if(wiersz[3].contains("Switzerland") && Integer.parseInt(wiersz[4]) > 4000) {
                System.out.println(wiersz[0] + wiersz[1]);
            }
        });

    }

    @Test
    public void windowsTabs() throws InterruptedException {
        driver.get("http://seleniumui.tc-sii.com");

        WebElement menuBasics = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][1]"));
        menuBasics.click();
        WebElement menuWindows = driver.findElement(By.id("windows-tabs-item"));
        menuWindows.click();

        String mainWindow = driver.getWindowHandle();

        WebElement newBrowWindow = driver.findElement(By.id("newBrowserWindow"));
        newBrowWindow.click();

        String winHandleBefore = driver.getWindowHandle();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        Form1();

        driver.switchTo().defaultContent();
        driver.close();
        driver.switchTo().window(winHandleBefore);
        WebElement newMessWindow = driver.findElement(By.id("newMessageWindow"));
        newMessWindow.click();



    }


//    @Test
//    public void internetTest() throws InterruptedException {
//        driver.get("http://the-internet.herokuapp.com/");
//
//        WebElement arElements = driver.findElement(By.xpath("//a[@href='/add_remove_elements/']"));
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/add_remove_elements/']")));
//        arElements.click();
//
//        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='addElement()']")));
//        WebElement addElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button")));
//        addElement.click();
//
//       WebElement delete = driver.findElement(By.xpath("//button[@class='added-manually']"));
//
//        delete.click();
//    }
//
//    @Test
//    public void internetTestCheckbox() throws InterruptedException {
//        driver.get("http://the-internet.herokuapp.com/");
//
//        WebElement checkboxes = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
//       checkboxes.click();
//       WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
//        checkbox1.click();
//
//        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
//        checkbox2.click();
//        checkbox1.click();
//
//    }
//
//    @Test
//    public void internetDropDown() throws InterruptedException {
//        driver.get("http://the-internet.herokuapp.com/");
//
//        WebElement checkboxes = driver.findElement(By.xpath("//a[@href='/dropdown']"));
//        checkboxes.click();
//
//        Select drpDown = new Select(driver.findElement(By.id("dropdown")));
//        drpDown.selectByVisibleText("Option 1");
//        drpDown.selectByVisibleText("Option 2");
//
//    }
//
//    @Test
//    public void internetDynControls() throws InterruptedException {
//        driver.get("http://the-internet.herokuapp.com/");
//
//        WebElement dynControls = driver.findElement(By.xpath("//a[@href='/dynamic_controls']"));
//        dynControls.click();
//
//        WebElement checkdyn1 = driver.findElement(By.xpath("//input[@label='blah']"));
//        checkdyn1.click();
//
//        WebElement removeButt = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
//        removeButt.click();
//        //wait
//        //asercja
//        WebElement enableButt = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
//        enableButt.click();
//        //wait, asercja
//    }

//    @AfterMethod
//    public void after() {
//        driver.close();;
//    }


//    @Test
//    public void allegroTest() {
//
//        driver.get("https://allegro.pl/");
//        WebElement searchInput = driver.findElement(By.name("string"));
//        searchInput.clear();
//        searchInput.sendKeys("selenium");
//        WebDriverWait wait;
//       // wait = new WebDriverWait(driver,10);
//        //WebElement Rodo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someid")));
//        WebElement searchButtonRodo = driver.findElement(By.cssSelector("button._13q9y _8tsq7 _7qjq4 _qozgg"));
//        searchButtonRodo.click();
//        WebElement searchButton = driver.findElement(By.cssSelector("button[data-role='search-button']"));
//        searchButton.click();
//    }

//    public void searchTest() {
//        // open duckduckgo website
//        driver.get("https://duckduckgo.com/");
//
//        // find search input and type "google"
//        WebElement searchInput = driver.findElement(By.id("search_form_input_homepage"));
//        searchInput.sendKeys("Google");
//
//        // find search button and click it
//        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
//        searchButton.click();
//
//        // find all search results
//        List<WebElement> searchResults = driver.findElements(By.className("result__body"));
//
//        for (WebElement result : searchResults) {
//            // find 'deeper' in each element
//            // find title in each result and print text from it
//            System.out.println(result.findElement(By.className("result__title")).getText());
//            // find url in each result and print text from it
//            System.out.println(result.findElement(By.className("result__extras__url")).getText());
//        }
//
//        // get text from the title of sidebar
//        String sidebarTitle = driver.findElement(By.cssSelector(".module__title__link")).getText();
//
//        // assert that sidebar title text equals "Google"
//        Assert.assertEquals(sidebarTitle, "Google");
//    }
}
