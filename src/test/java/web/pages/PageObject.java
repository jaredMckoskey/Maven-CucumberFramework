package web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    private RemoteWebDriver driver;

    public PageObject(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void trait() {
    }

    public WebElement getElement(String element) {
        return null;
    }


}

