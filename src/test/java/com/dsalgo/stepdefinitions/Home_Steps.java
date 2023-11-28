package com.dsalgo.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgo.pageobjects.Home_Page;
import com.dsalgo.utilities.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home_Steps {

	private WebDriver driver = DriverFactory.initializeDriver();
	private Home_Page homePage = new Home_Page(driver);

	@Given("The user is on the Home Page")
	public void the_user_opens_home_page() {
		// if(!driver.getCurrentUrl().equalsIgnoreCase("https://dsportalapp.herokuapp.com/home"))
		// {
		driver.get("https://dsportalapp.herokuapp.com/home");
		// }
		Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/home");
	}

	@When("The user is in home page")
	public void the_user_is_in_home_page() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/home");
	}

	@Then("The user should see {int} panes with different data structures")
	public void the_user_should_see_panes_with_different_data_structures(Integer int1) {
		Assert.assertEquals(homePage.getTotalPanes(), int1);
	}

	@When("The user clicks {string} drop down")
	public void the_user_clicks_drop_down(String string) {
		homePage.click_dropDown();
	}

	@Then("The user should see {int} different data structure entries in that dropdown")
	public void the_user_should_see_different_data_structure_entries_in_that_dropdown(Integer count) {
		Assert.assertEquals(homePage.getTotalDropdownOptions(), count);
	}

	@When("The user selects {string} data structures from the drop down without Sign in.")
	public void the_user_selects_option_data_structures_from_the_drop_down_without_sign_in(String option) {
		homePage.click_dropDown();
		homePage.getDropDownSelectedOption(option);
	}

	@Then("It should alert the user with a message {string}")
	public void it_should_alert_the_user_with_a_message(String msg) {
		Assert.assertEquals(homePage.getMessage(), msg);
	}

	@When("The user clicks any of the {string} buttons below the data structures {string}")
	public void the_user_clicks_any_of_the_buttons_below_the_data_structures_option(String string, String option) {
		homePage.getPaneSelectedOption(driver, option, string);
	}

	@Then("Display the messsage {string}")
	public void display_the_message(String msg) {
		Assert.assertEquals(homePage.getMessage(), msg);
	}

	@When("The user clicks {string}")
	public void the_user_clicks(String string) {
		homePage.getRegisterOrSignIn(string);
	}

	@Then("The user should be redirected to Register form")
	public void the_user_should_be_redirected_to_register_form() {
		Assert.assertEquals(driver.getTitle(), "Registration");
	}

	@Then("The user should be redirected to Sign in form")
	public void the_user_should_be_redirected_to_sign_in_form() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.findElement(By.name("username")).sendKeys("numpyninja@123");
		driver.findElement(By.name("password")).sendKeys("Qwerty@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
}
