package com.DriverFactory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.UtilityMethods.Utility;

public class Driver_Factory {

	static WebDriver driver;
	
	public static WebDriver initBrowser(String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			Reporter.log("Setting browser name as "+browserName, true);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			Reporter.log("Setting browser name as "+browserName, true);
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
			Reporter.log("Setting browser name as "+browserName, true);
		}
		
		driver.manage().window().maximize();
		driver.get(Utility.readDataFromPropertiesFile("url"));
		
		return driver;
	}
	
	public static WebDriver getdriver()
	{
		return driver;
	}
	
}
