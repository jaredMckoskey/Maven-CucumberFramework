package web.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObject {

    private RemoteWebDriver driver;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        trait();
    }

    @Override
    public void trait() {
        Assert.assertTrue("Home page was not displayed.", pageTrait.isDisplayed());
    }

    @Override
    public WebElement getElement(String element) {

        switch (element.toUpperCase()) {
            case "SOME ELEMENT 1":
                return someElement1;
            case "SOME ELEMENT 2":
                return someElement2;
            default:
                throw new IllegalArgumentException(
                    String.format("Could not get element by name: %s. Is it implemented?", element)
                );
        }
    }

    // * * * * * * * * * * * * * * * * HOME PAGE SELECTORS * * * * * * * * * * * * * * * * //
    @FindBy(how = How.CLASS_NAME, using = "fusion-slider-container")
    public static WebElement pageTrait;

    @FindBy(how = How.ID, using = "someElement1")
    public static WebElement someElement1;

    @FindBy(how = How.CSS, using = "div[class='someElement2']")
    public static WebElement someElement2;
}