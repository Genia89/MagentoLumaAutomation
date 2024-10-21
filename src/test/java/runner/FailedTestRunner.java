package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",       // This will run only the failed scenarios listed in rerun.txt
        glue = "step_definitions",
        plugin = {
                "html:target/cucumber-failed-reports.html"
        },
        dryRun = false                        // Set to true if you only want to check the mappings
)

public class FailedTestRunner {

}
