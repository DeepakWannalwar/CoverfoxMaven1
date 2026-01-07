package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM1_Home_Page {


		//1) Data members
		@FindBy(xpath = "//*[text()='Get Started']") private WebElement getStartedButton;
		
		//2) constructor
		public POM1_Home_Page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//3) Methods
		public void clickOnGetStartedButton()
		{
			getStartedButton.click();
			System.out.println("clicking on getStartedButton");
		}
		
	
}
