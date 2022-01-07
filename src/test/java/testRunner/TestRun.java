package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = {".//Features/Customers.feature", ".//Features/Login.feature"}, 
                glue = "stepDefinitions",
                dryRun = true,
                monochrome = true,
				plugin = {"pretty","html:test-output"},
		        tags= {"@sanity", "@regression"}  //if we want run as AND case then use {"@sanity", "@regression"}
												//and for OR case use {"@sanity, @regression"}
				)

public class TestRun {

}
