package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.dsalgoproject.pageobjects.Queue_Page;
import com.dsalgoproject.utilities.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Queue_Steps {
	private WebDriver driver = DriverFactory.getDriver();
	Queue_Page queue = new Queue_Page(driver);

	@Given("Login to DsAlsgo website with valid username {string} and password {string} and navigate to Queue page.")
	public void login_ds_alsgo_navigate_to_queue_page(String username, String password) {
		driver.get("https://dsportalapp.herokuapp.com/login");
		queue.login(username, password);
		System.out.println("Current URL of the page after selecting the dropdown option : " + driver.getCurrentUrl());
	}

	@Given("User navigates to Implementation of Queue in Python page.")
	public void practiceInput() {
		driver.get("https://dsportalapp.herokuapp.com/queue/implementation-lists/");
	}

	@When("user clicks on {string} with the corresponding {string}")
	public void user_clicks_on_with_the_corresponding(String pagename, String url) {
		queue.click_Page(pagename, url);
	}

	@Then("user in queue must be directed to {string}")
	public void user_must_be_directed_to(String url) {
		queue.ValidatePage(url);
	}

	@And("click on Tryhere button and click the run button.")
	public void clickon_Tryhere() {
		queue.click_Tryhere();
	}
}