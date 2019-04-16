package mobile.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class ScreenObject {

    private RemoteWebDriver driver;

    public ScreenObject(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void trait() {
    }

    public MobileElement getElement(String element) {
        return null;
    }


}

