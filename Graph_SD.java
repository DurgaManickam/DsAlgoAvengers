package stepdefination;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverManager;
import io.cucumber.java.en.Given;
import webPages.GraphPage;

public class Graph_SD {
	private WebDriver driver = DriverManager.getDriver();
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
}
