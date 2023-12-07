/**
 * 
 */
package stepdefination;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverManager;
import webPages.Stack_Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 */
public class Stack_SD {
	
	private WebDriver driver;
	Stack_Page SP;
	@Given("Login DsAlsgo website with valid username {string} and password {string} and Navigate to Stack page.")
	public void login_dsAlgo(String username, String pwd) {
		 driver = DriverManager.getDriver();
			System.out.println("I am inside Login SD file");
			driver.get("https://dsportalapp.herokuapp.com/login");
			 SP = new Stack_Page(driver);
			 SP.login(username,pwd);
				System.out.println("Current title of the page : " + driver.getTitle());
				
	    
	}


	@When("The user clicks on Operations in Stack link.")
	public void clicks_on_operations_in_stack_link() {
	    SP.operations_click();
	}

	@Then("The user must be directed to Operations in Stack page.")
	public void the_user_must_be_directed_to_operations_in_stack_page() {
	   try {
		SP.validate_navigatePage_operations();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Given("The user is in Operations in Stack page.")
	public void the_user_is_in_operations_in_stack_page() {
	   try {
		SP.NavigatePage_operations();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@When("The user clicks on TryHere button.")
	public void the_user_clicks_on_try_here_button() {
	   SP.click_Tryhere();
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test.")
	public void try_editor_with_a_run_button_to_test() {
	   SP.goto_runEditor_page();
	}

	@When("The user clicks on Implementation link.")
	public void the_user_clicks_on_implementation_link() {
	    SP.implementation_click();
	}

	@Then("The user must be directed to Implementation in Stack page.")
	public void the_user_must_be_directed_to_implementation_in_stack_page() {
	    try {
			SP.validate_navigatePage_implementation();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("The user is in Implementation in Stack page.")
	public void the_user_is_in_implementation_in_stack_page() {
	    try {
			SP.NavigatePage_implementation();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("The user is in Applications page after logging in.")
	public void the_user_is_in_applications_page_after_logging_in() {
	    try {
			SP.NavigatePage_applications();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("The user clicks on Applications link.")
	public void the_user_clicks_on_applications_link() {
	   SP.applications_click();
	}

	@Then("The user must be directed to Applications in Stack page.")
	public void the_user_must_be_directed_to_applications_in_stack_page() {
	    try {
			SP.validate_navigatePage_applications();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("The user is in Applications in Stack page.")
	public void the_user_is_in_applications_in_stack_page() {
	  try {
		SP.NavigatePage_applications();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Given("The user is in Operations in Stack page after logging in.")
	public void the_user_is_in_operations_in_stack_page_after_logging_in() {
	    try {
			SP.NavigatePage_operations();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("The user clicks on Practice Questions link.")
	public void the_user_clicks_on_practice_questions_link() {
	    SP.PracticeInput_Click();
	}

	@Then("The user must be directed to Practice Questions page of Stack.")
	public void the_user_must_be_directed_to_practice_questions_page_of_stack() {
	    try {
			SP.validate_navigatePage_Practice();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
