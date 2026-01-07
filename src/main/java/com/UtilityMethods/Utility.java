package com.UtilityMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

			// 1) Screenshot
	
			public static void getScreenshot(WebDriver driver, String screenshotName) throws IOException
			{
				File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String simpleDate = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
				String path = System.getProperty("user.dir");		
				File des = new File(path+"\\CoverfoxSS\\"+screenshotName+"_"+simpleDate+".jpg");
				FileHandler.copy(scr, des);
				System.out.println("Screenshot Name "+ screenshotName);		
				System.out.println("Taking screenshot and saving at location "+des);
			}
			
			// 2) ScrollIntoView
			
			public static void scrollIntoView(WebDriver driver, WebElement webElement)
			{
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].scrollIntoView(true)", webElement);
				System.out.println("Scrolling into view upto "+webElement.getText());
			}
			
			// 3) explicitWait
			
			public static void explicitWait(WebDriver driver, long waitTime, WebElement webElement)
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));		
				wait.until(ExpectedConditions.visibilityOf(webElement));
				System.out.println("Waiting for element "+webElement);
			}
			
			// 4) excel reading
			
			public static String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
			{
				FileInputStream myFile = new FileInputStream("D:\\Deepak\\SeleniumData\\SeleniumData.xlsx");
				Sheet mySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
				String testData = mySheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
				System.out.println("Reading daat from excel "+testData);
				return testData;
			}
			
			// 5) .properties
			
			public static String readDataFromPropertiesFile(String key) throws IOException
			{
				Properties properties = new Properties();
				FileInputStream myPropertiesFile = new FileInputStream("C:\\Users\\dkwan\\eclipse-practice\\CoverfoxLenovo\\CoverfoxMaven1\\src\\main\\resources\\config\\config.properties");
				properties.load(myPropertiesFile);
				
				String value = properties.getProperty(key);
				System.out.println("Reading "+ key +" and value is "+value);
				return value;
				
			}
			
			// 6) dropDown Handling
			
			public static void handleDropDownUsingselectByVisibleText(WebElement element, String visibleText)
			{
				Select select = new Select(element);
				select.selectByVisibleText(visibleText);
				System.out.println("Handling drop down, value is "+ visibleText);
			}

}
