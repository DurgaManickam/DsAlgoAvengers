package com.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgo.pageobjects.Landing_Page;
import com.dsalgo.utilities.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landing_Steps {
	
	private WebDriver driver = DriverFactory.initializeDriver();
    private Landing_Page landingPage = new Landing_Page(driver);
	
	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() {
		driver.get("https://dsportalapp.herokuapp.com/");
	}

	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
	    landingPage.click_get_started();
	}

	@Then("The user should land in DS Algo portal page")
	public void the_user_should_land_in_ds_algo_portal_page() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/home");
	}

	@Then("The user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/home");
	}
}
