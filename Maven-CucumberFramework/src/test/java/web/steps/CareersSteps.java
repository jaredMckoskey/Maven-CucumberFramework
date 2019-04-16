package web.steps;

import cucumber.api.java.en.Then;
import web.support.Hooks;
import org.junit.Assert;
import web.pages.CareersPage;

public class CareersSteps {

    private CareersPage page;

    public CareersSteps(Hooks hooks) {
        this.page = new CareersPage(hooks.getDriver());
    }

    @Then("^I verify the \"([^\"]*)\" is displayed on the careers page$")
    public void i_verify_the_is_displayed_on_the_careers_page(String element) throws Throwable {
        Assert.assertTrue(
            String.format("%s was not displayed.", element),
            page.getElement(element).isDisplayed()
        );
    }
}
