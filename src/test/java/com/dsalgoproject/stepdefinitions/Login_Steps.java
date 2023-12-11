package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.dsalgoproject.pageobjects.Login_Page;
import com.dsalgoproject.utilities.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps {

	private WebDriver driver = DriverFactory.getDriver();;
	private Login_Page login = new Login_Page(driver);;

	@Given("User must launch a browser and navigate to the DSAlgo website.") // https://dsportalapp.herokuapp.com/

	public void the_browser_must_be_open() {

		System.out.println("I am inside Login SD file");

		driver.get("https://dsportalapp.herokuapp.com/");

		System.out.println("Current URL of the page : " + driver.getCurrentUrl());

	}

	@When("User clicks on Get started button")
	public void start_button() {

		System.out.println("start button code");

		login.Getstarted();

	}

	@Then("User navigates to Signin Page")
	public void user_navigates_to_signin_page() {
		try {
		login.Signin_Page();
		}catch(AssertionError e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void enter_valid_username_password(String uname, String passwrd) {

		try {
			login.loginValidUser(uname, passwrd);
		} catch (Throwable e) {

			e.printStackTrace();
			System.out.println("Error  " + e.getMessage());
		}

	}

	@And("click on Login button")
	public void click_on_login_button() {
		login.clickLogin();

	}

	@And("^validate logins \"(.*)\" and \"(.*)\"$")
	public void validate_login(String uname, String passwrd) {
		login.LoginValidate(uname, passwrd);
	}

	@Then("^Valid User must navigate to Home Page with the message \"You are logged in\" and with the username \"(.*)\" on the top$")
	public void land_in_home_page(String uname) throws InterruptedException {
		try {
			login.IsItHomepage(uname);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
