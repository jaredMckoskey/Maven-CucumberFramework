package web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CareersPage extends PageObject {

    private RemoteWebDriver driver;

    public CareersPage(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        trait();
    }

    @Override
    public void trait() {
        Assert.assertTrue("Careers page was not displayed.", pageTrait.isDisplayed());
    }

    @Override
    public WebElement getElement(String element) {

        switch (element.toUpperCase()) {
            case "CAREERS HEADER":
                return careersHeader;
            case "KEYWORDS FILTER":
                return keywordsFilter;
            default:
                throw new IllegalArgumentException(
                        String.format("Could not get element by name: %s. Is it implemented?", element)
                );
        }
    }

    // * * * * * * * * * * * * * * * * CAREERS PAGE SELECTORS * * * * * * * * * * * * * * * * //
    @FindBy(how = How.CLASS_NAME, using = "job_listings")
    public static WebElement pageTrait;

    @FindBys({
            @FindBy(how = How.CLASS_NAME, using = "fusion-page-title-captions"),
            @FindBy(how = How.CSS, using = "h1")
    })
    public static WebElement careersHeader;

    @FindBy(how = How.ID, using = "search_keywords")
    public static WebElement keywordsFilter;


}