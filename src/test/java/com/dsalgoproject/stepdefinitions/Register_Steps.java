package com.dsalgoproject.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.pageobjects.Home_Page;
import com.dsalgoproject.pageobjects.Register_Page;
import com.dsalgoproject.utilities.AppConstants;
import com.dsalgoproject.utilities.DriverFactory;
import com.dsalgoproject.utilities.ExcelReader;
import com.dsalgoproject.utilities.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register_Steps {
	
	private WebDriver driver = DriverFactory.initializeDriver();
	private Register_Page registerPage = new Register_Page(driver);
	private Home_Page homePage = new Home_Page(driver);
	ExcelReader reader = new ExcelReader();
	private String expectedMessage;
	
	@Given("The user is in register page")
	public void the_user_is_in_register_page() {
	    driver.get(AppConstants.REGISTER_URL);
	    Assert.assertEquals(driver.getTitle(), "Registration");
	}
	
	@When("The user enters selects the data from {int} in valid excel sheet")
	public void read_valid_data_from_excel(Integer rowNumber){  
		List<Map<String, String>> testdata = null;
		try {
			if(testdata == null) {
				testdata = reader.getData(AppConstants.TEST_DATA_EXCEL_PATH, AppConstants.REGISTER_VALID_USER_TEST_SHEET);
			}
			String username = testdata.get(rowNumber).get("username");
		    String password = testdata.get(rowNumber).get("password");
		    String passwordConfirmation = testdata.get(rowNumber).get("passwordConfirmation");
		    expectedMessage = testdata.get(rowNumber).get("expectedOutput");
		    registerPage.enter_username(username);
		    registerPage.enter_password(password);
		    registerPage.enter_password_confirmation(passwordConfirmation);
		    Thread.sleep(2000);
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	@When("The user enters selects the data from {int} in invalid excel sheet")
	public void read_invalid_data_from_excel(Integer rowNumber){  
		List<Map<String, String>> testdata = null;
		try {
			if(testdata == null) {
				testdata = reader.getData(AppConstants.TEST_DATA_EXCEL_PATH, AppConstants.REGISTER_INVALID_USER_TEST_SHEET);
			}
			String username = testdata.get(rowNumber).get("username");
		    String password = testdata.get(rowNumber).get("password");
		    String passwordConfirmation = testdata.get(rowNumber).get("passwordConfirmation");
		    expectedMessage = testdata.get(rowNumber).get("expectedOutput");
		    System.out.println(username);
		    System.out.println(password);
		    System.out.println(passwordConfirmation);
		    System.out.println(expectedMessage);
		    registerPage.enter_username(username);
		    registerPage.enter_password(password);
		    registerPage.enter_password_confirmation(passwordConfirmation);
		    Thread.sleep(2000);
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}


	@When("Clicks on Register button")
	public void clicks_on_register_button() throws InterruptedException {
	    registerPage.click_register();
	    LoggerLoad.info("Clicked Register button");
	}

	@Then("The user is redirected to the Home Page")
	public void the_user_is_redirected_to_the_home_page() {
	    Assert.assertEquals(driver.getCurrentUrl(), AppConstants.HOME_PAGE_URL);
	}
	@Then("Validate the success message in home page.")
	public void validate_success_message() {
		LoggerLoad.info("Valid registered user redirected to home page and expected message:"+expectedMessage);
		Assert.assertEquals(homePage.getMessage(), expectedMessage);
	}
	
	@Then("Validate the error message.")
	public void validate_error_message() {
		LoggerLoad.info("Invalid registered user and expected message:"+expectedMessage);
		Assert.assertEquals(registerPage.getMessage(), expectedMessage);
	}
	
	@When("The user clicks on login button")
	public void click_login() {
		registerPage.click_Login();
	}
	@Then("Validate that the user redirected to the login page.")
	public void validate_user_in_login_page() {
		LoggerLoad.info("Clicked login in register page and redirected to login page.");
		Assert.assertEquals(driver.getCurrentUrl(), AppConstants.SIGN_IN_URL);
	}
}
