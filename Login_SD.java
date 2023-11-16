package stepdefination;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverManager;
import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webPages.Login_Page;



public class Login_SD {

	private WebDriver driver;
	  private Login_Page login;
	
	@Given("User must launch a browser and navigate to the DSAlgo website")// https://dsportalapp.herokuapp.com/
	
	public void the_browser_must_be_open() {
		
		 driver = DriverManager.getDriver();
		 
		System.out.println("I am inside Login SD file");
		 login = new Login_Page(driver);
		
			driver.get("https://dsportalapp.herokuapp.com/");
			System.out.println("Current title of the page : " + driver.getTitle());
			System.out.println("Current URL of the page : " + driver.getCurrentUrl());
		
		
	}
	@When("User clicks on Get started button")
	public void start_button() {
		
		 System.out.println("start button code");
		
		 login.Getstarted();
			
		
	}

	@Then("User navigates to Signin Page")
	public void user_navigates_to_signin_page() {
	   //login=new Login_Page(driver);
		login.Signin_Page();
	   
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void enter_valid_username_password(String uname, String passwrd) {
		
			try {
				login.loginValidUser(uname, passwrd);
			}  catch (Throwable e) {
				
				e.printStackTrace();
				System.out.println("Error  "+e.getMessage());
			}
		

	}

	@And("click on Login button")
	public void click_on_login_button() {
		login.clickLogin();

	}

	@Then("User must navigate to Home Page with the message \"You are logged in\" and with the user name on the top")
	public void land_in_home_page() throws InterruptedException {
		try {
		login.IsItHomepage();
		Thread.sleep(1000);}
		catch(Exception e) {
			System.out.println("invalid credentials were entered so cannot goto homePage"+e.getMessage());
		}
		
	}
	

}
