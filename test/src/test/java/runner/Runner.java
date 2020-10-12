package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions(
		features= "C:\\Users\\Shalmalee\\git\\MasterRemote\\MasterRemote\\test\\src\\test\\java\\Features",
		glue="stepDefinition"
		)

public class Runner {

}
