package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.dsalgoproject.pageobjects.Signout_Page;
import com.dsalgoproject.utilities.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signout_Steps {

	private WebDriver driver = DriverFactory.getDriver();
	Signout_Page sign = new Signout_Page(driver);

	@Given("Login to DsAlsgo website with valid username {string} and password {string} for validating signout button.")
	public void login_and_navigate_to_data_structures_page(String username, String password) {
		driver.get("https://dsportalapp.herokuapp.com/login");
		sign.login(username, password);
		System.out.println("Current URL of the page after selecting the dropdown option : " + driver.getCurrentUrl());
	}

	@When("user clicks on signout button.")
	public void clickon_signout() {
		sign.signout();
	}

	@Then("user must be logged out and navigate to Home page{string}.")
	public void validateLogout(String url) {
		sign.validatesignoutuser(url);
	}

}