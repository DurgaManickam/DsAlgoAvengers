package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.pageobjects.Landing_Page;
import com.dsalgoproject.utilities.AppConstants;
import com.dsalgoproject.utilities.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landing_Steps {

	private WebDriver driver = DriverFactory.getDriver();
	private Landing_Page landingPage = new Landing_Page(driver);

	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() {
		driver.get(AppConstants.LANDING_PAGE_URL);
	}

	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		landingPage.click_get_started();
	}

	@Then("The user should land in DS Algo portal page")
	public void the_user_should_land_in_ds_algo_portal_page() {
		Assert.assertEquals(driver.getCurrentUrl(), AppConstants.HOME_PAGE_URL);
	}

	@Then("The user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() {
		Assert.assertEquals(driver.getCurrentUrl(), AppConstants.HOME_PAGE_URL);
	}
}
