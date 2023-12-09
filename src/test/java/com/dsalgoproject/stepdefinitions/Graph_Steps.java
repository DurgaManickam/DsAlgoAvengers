package com.dsalgoproject.stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.dsalgoproject.pageobjects.GraphPage;
import com.dsalgoproject.utilities.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Graph_Steps {
	private WebDriver driver = DriverFactory.getDriver();
	GraphPage GP = new GraphPage(driver);

	@Given("Login to DsAlsgo website with valid username {string} and password {string} and navigate to Graph page.")
	public void login_to_ds_alsgo_website_navigate_to_graph_page(String username, String password) {
		driver.get("https://dsportalapp.herokuapp.com/login");
		GP.login(username, password);
		System.out.println("Current URL of the page after selecting the dropdown option : " + driver.getCurrentUrl());
	}

	@Given("User navigates to Graph Representations.")
	public void user_navigates_to_graph_page() {
		driver.get("https://dsportalapp.herokuapp.com/graph/graph-representations/");
	}

	@Then("user in graph must be directed to {string}")
	public void user_in_graph_must_be_directed_to(String url) {
		assertEquals(driver.getCurrentUrl(), url);
	}
}