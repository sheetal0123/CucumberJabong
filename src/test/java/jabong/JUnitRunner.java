package jabong;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, strict = false, features = "src/test/resources/", glue = "jabong", tags = {
		"@negativeScenario", "@positiveScenario" }, monochrome = true, plugin = { "pretty",
		"html:target/cucumber",
		"json:target_json/cucumber.json",
		"junit:taget_junit/cucumber.xml"
})

public class JUnitRunner {

}
