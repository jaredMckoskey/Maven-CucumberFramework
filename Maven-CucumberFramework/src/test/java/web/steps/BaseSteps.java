package web.steps;

import cucumber.api.java.en.When;
import web.support.Hooks;
import web.pages.BasePage;

public class BaseSteps {

    private BasePage page;

    public BaseSteps(Hooks hooks) {
        this.page = new BasePage(hooks.getDriver());
    }

    @When("^I click the \"([^\"]*)\" in the global navbar$")
    public void i_click_the_in_the_global_navbar(String element) throws Throwable {
        page.getElement(element).click();
    }
}
