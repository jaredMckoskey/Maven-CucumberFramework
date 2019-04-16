package web.support;

import config.Config;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.WebDriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

import static config.Constants.DEFAULT_URL;

public class Hooks extends WebTestRunner {

    private static boolean isSetup = false;
    private static WebDriverFactory factory;
    private RemoteWebDriver driver;
    public Config config;

    public RemoteWebDriver getDriver() {
        return driver;
    }

    @Before(order = 1)
    public void beforeAll() {
        if (!isSetup) {
            config = new Config(); // Set the config values directly in the Config class (not in Hooks).
            factory = new WebDriverFactory(config);
        }
    }

    @Before(order = 2)
    public void beforeScenario() throws MalformedURLException {
        driver = factory.createDriver();
        isSetup = true;

        driver.manage().window().maximize();
        driver.get(DEFAULT_URL);
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
