package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "step_definitions",
        plugin = {
                "html:target/cucumber-failed-reports.html"
        },
        dryRun = false
)

public class FailedTestRunner {

}
