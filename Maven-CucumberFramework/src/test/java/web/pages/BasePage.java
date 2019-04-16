package web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends PageObject {

    private RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        trait();
    }

    @Override
    public void trait() {
        Assert.assertTrue("Base page was not displayed.", pageTrait.isDisplayed());
    }

    @Override
    public WebElement getElement(String element) {

        switch (element.toUpperCase()) {
            case "CAREERS LINK":
                return careersLink;
            case "SOME ELEMENT 2":
                return someElement2;
            case "SOME ELEMENT 3":
                return dhdjhd;
            default:
                throw new IllegalArgumentException(
                    String.format("Could not get element by name: %s. Is it implemented?", element)
                );
        }
    }

    // * * * * * * * * * * * * * * * * GLOBAL SELECTORS * * * * * * * * * * * * * * * * //
    @FindBy(how = How.CLASS_NAME, using = "fusion-standard-logo")
    public static WebElement pageTrait;

    @FindBy(how = How.CSS, using = "a[href='https://www.tapqa.com/careers/']")
    public static WebElement careersLink;

    @FindBy(how = How.CSS, using = "div[class='someElement2']")
    public static WebElement someElement2;

    @FindBy(how = How.CSS, using = "div[class='someElement2']")
    public static WebElement dhdjhd;
}