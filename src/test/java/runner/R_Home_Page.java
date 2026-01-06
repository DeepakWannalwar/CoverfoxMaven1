package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
	(
			features = {"C:\\Users\\Lenovo\\eclipse-workspace\\CoverfoxMaven1\\src\\test\\resources\\Feature\\Home_Page.feature"},
			glue = {"stepdefination"},
			plugin = {"pretty", "html:target/cucumber-reports/reports.html","json:target/cucumber.json"},
			publish = true
			//dryRun = false
				
	)
public class R_Home_Page extends AbstractTestNGCucumberTests {

}
