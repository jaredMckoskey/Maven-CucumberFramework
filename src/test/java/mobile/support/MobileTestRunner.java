package mobile.support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
            "pretty",
            "junit:target/test-results/mobile/cucumber-junit.xml",
            "html:target/test-results/mobile/cucumber-html",
            "json:target/test-results/mobile/cucumber-report.json"
    },
    features = {"src/test/resources/features/mobile"},
    glue = {"mobile.steps", "mobile.support"}
)
public class MobileTestRunner {
}
