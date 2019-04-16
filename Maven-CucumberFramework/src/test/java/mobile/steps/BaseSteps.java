package mobile.steps;

import mobile.screens.BaseScreen;
import mobile.support.Hooks;

public class BaseSteps {

    private BaseScreen screen;

    public BaseSteps(Hooks hooks) {
        this.screen = new BaseScreen(hooks.getDriver());
    }
}
