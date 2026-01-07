package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
	(
			features = {"C:\\Users\\dkwan\\eclipse-practice\\CoverfoxLenovo\\CoverfoxMaven1\\src\\test\\resources\\Feature\\Home_Page.feature"},
			glue = {"stepdefination","hooks"},
			plugin = {"pretty", "html:target/cucumber-reports/reports.html","json:target/cucumber.json"},
			//publish = true
			dryRun = false
				
	)
public class R_Home_Page extends AbstractTestNGCucumberTests {

}
