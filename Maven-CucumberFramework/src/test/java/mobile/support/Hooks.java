package mobile.support;

import config.Config;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.MobileDriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static config.Constants.DEFAULT_TIMEOUT;

public class Hooks extends MobileTestRunner {

    private static boolean isSetup = false;
    private static MobileDriverFactory factory;
    private RemoteWebDriver driver;
    public Config config;

    public RemoteWebDriver getDriver() {
        return driver;
    }

    @Before(order = 1)
    public void beforeAll() {
        if (!isSetup) {
            config = new Config(); // Set the config values directly in the Config class (not in Hooks).
            factory = new MobileDriverFactory(config);
        }
    }

    @Before(order = 2)
    public void beforeScenario() {

        try {
            driver = factory.createDriver();
            driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After(order = 1)
    public void afterAll(Scenario scenario) {
        isSetup = false;
    }

    @After(order = 2)
    public void afterScenario(Scenario scenario) {

        if (driver != null) {
            driver.quit();
        }
    }
}
