package web.steps;

import cucumber.api.java.en.Given;
import web.support.Hooks;
import web.pages.HomePage;

public class HomeSteps {

    private HomePage page;

    public HomeSteps(Hooks hooks) {
        this.page = new HomePage(hooks.getDriver());
    }

    @Given("^I on the tapqa homepage$")
    public void I_on_the_tapqa_homepage() {
        page.trait();
    }

}
