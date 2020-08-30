package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = ".//Features/",
				glue = "stepDefinitions",
				dryRun = false,
				monochrome = true,
				strict = false,
				plugin = {"pretty","html:test-output"},
				tags = {"@sanity"}
		
		)
public class simpleRunner {

}
