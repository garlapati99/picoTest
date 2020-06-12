package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "com.ocbc.accesslogin",
        plugin = {
                "pretty",
                "html:target/html",
                "json:target/json/file.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class Runner {

}
