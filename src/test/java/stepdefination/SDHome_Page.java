package stepdefination;

import com.DriverFactory.Driver_Factory;
import com.POM.POM1_Home_Page.POM1_HomePage;

import io.cucumber.java.en.*;

public class SDHome_Page {
	
	POM1_HomePage coverfoxHomePage = new POM1_HomePage(Driver_Factory.getdriver());
	

	@Given("I am on Home page")
	public void i_am_on_home_page() {
	    System.out.println("I am on Home page");
	}

	@When("I click on get started button")
	public void i_click_on_get_started_button() {
	   coverfoxHomePage.clickOnGetStartedButton();
	}
	@Then("Redirect to health plan page")
	public void redirect_to_health_plan_page() {
	    System.out.println("Redirect to health plan page");
	}
}
