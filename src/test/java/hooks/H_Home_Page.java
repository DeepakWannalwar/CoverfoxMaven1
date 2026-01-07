package hooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.DriverFactory.Driver_Factory;
import com.UtilityMethods.Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class H_Home_Page {

	@Before
	public void launchBrowser() throws IOException
	{
		Driver_Factory.initBrowser(Utility.readDataFromPropertiesFile("browser"));
	}
	@After(order = 1)
	public void tearDown()
	{
		Driver_Factory.getdriver().quit();
		Reporter.log("CLosing browser", true);
	}
	@BeforeStep
	public void sleepTime() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("Pause------------------------------------");
	}
	
	@After(order = 2)
	public void takeScreenShot(Scenario scenario)
	{	
		boolean result = scenario.isFailed(); 
		
		if(result)
		{
			byte[] ss = ((TakesScreenshot)Driver_Factory.getdriver()).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(ss, "image.jpeg", scenario.getName());
			 Reporter.log("Taking screen shot ", true);
		}
		// boolean--> True then scenario is Failed
				// boolean--> False then scenario is Pass
	}	
}
