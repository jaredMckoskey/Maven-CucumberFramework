package mobile.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen extends ScreenObject {

    private RemoteWebDriver driver;

    public BaseScreen(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        trait();
    }

    @Override
    public void trait() {
        Assert.assertTrue("Base screen was not displayed.", screenTrait.isDisplayed());
    }

    @Override
    public MobileElement getElement(String element) {

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

    // * * * * * * * * * * * * * * * * GLOBAL SELECTORS * * * * * * * * * * * * * * * * //
    @AndroidFindBy(id = "todo")
    @iOSFindBy(id = "todo")
    public static MobileElement screenTrait;

    @AndroidFindBy(id = "todo")
    @iOSFindBy(id = "todo")
    public static MobileElement someElement1;

    @AndroidFindBy(id = "todo")
    @iOSFindBy(id = "todo")
    public static MobileElement someElement2;
}