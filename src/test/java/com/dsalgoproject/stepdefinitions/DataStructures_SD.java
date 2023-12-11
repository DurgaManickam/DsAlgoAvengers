package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.dsalgoproject.pageobjects.DataStructurePage;
import com.dsalgoproject.utilities.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataStructures_SD {
	private WebDriver driver = DriverFactory.getDriver();
	DataStructurePage ds = new DataStructurePage(driver);

	@Given("Login to DsAlsgo website with valid username {string} and password {string} and navigate to DataStructures page.")
	public void login_and_navigate_to_data_structures_page(String username, String password) {
		driver.get("https://dsportalapp.herokuapp.com/login");
		ds.login(username, password);
		System.out.println("Current URL of the page after selecting the dropdown option : " + driver.getCurrentUrl());
	}

	@When("user in DS page clicks on {string} with the corresponding {string}")
	public void user_ds_page_clicks_link(String pagename, String url) {
		ds.click_Page_DataStructure(pagename, url);

	}

	@Then("user must be directed to {string} of DS page")
	public void user_navigate_to_ds_page(String url) {
		ds.ValidatePage_DataStructure(url);
	}

	@Then("click on Tryhere button in DS page and click the run button.")
	public void click_tryhere_button_in_ds_page_and_click_the_run_button() {
		ds.click_Tryhere();
	}

	@Given("User navigates to DataStructures Time complexity page.")
	public void user_navigates_to_data_structures_representations() {
		driver.get("https://dsportalapp.herokuapp.com/data-structures-introduction/time-complexity/");
	}
}