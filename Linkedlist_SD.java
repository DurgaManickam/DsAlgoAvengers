package stepdefination;


import org.openqa.selenium.WebDriver;


import driverFactory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webPages.Linkedlist_Page;

public class Linkedlist_SD {

	private WebDriver driver= DriverManager.getDriver();
	Linkedlist_Page lp= new Linkedlist_Page(driver);

							
	
	@Given("Login to DsAlsgo website with valid username {string} and password {string} and navigate to Linkedlist page.")
	public void login_dsalsgo_(String username, String pasword) {
		
			System.out.println("I am inside Login SD file");
			driver.get("https://dsportalapp.herokuapp.com/login");
			
			 lp.login(username, pasword);
			 System.out.println("after navigating to the linked list page and current url is " + driver.getCurrentUrl());
				
	}

	@When("The user clicks Introduction link")
	public void clicks_introduction_link() {
		lp.click_introlink();

	}

	@Then("The user should be directed to Introduction of Linked List Page")
	public void goto_introduction_page() {
		try {
			lp.validate_navigatePage();
		} catch (Exception e) {
		}
	}

	@Given("The user is in the Introduction of Linked list page")
	public void introduction__page() {
		lp.NavigatePage_Intro();

	}

	@Given("The user is in Types of Linked List page")
	public void types_LL_page() {
		lp.NavigatePage_typesOF();
	}

	@When("The user clicks Try Here button")
	public void clicks_try_here_button() {
		lp.click_Tryhere();

	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test")
	public void run_button_to_test() throws InterruptedException {
		try {
			lp.goto_runEditor_page();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@When("The user clicks the Creating a Linked List link")
	public void clickcreate_linkedlist_link() {
		System.out.println("inside create linkedlist method and current url is :"+driver.getCurrentUrl());
		lp.click_createlinkedlist();

	}

	@Then("The user should be directed to Creating Linked List Page")
	public void goto_creating_linked_list_page() {
		try {
			lp.validate_navigatePage();
		} catch (Exception e) {
		}
	}

	@Given("The user is in the Creating a Linked List of Linked list page")
	public void create_LL_page() {
		lp.NavigatePage_create();

	}

	@When("The user clicks the Types of Linked List link")
	public void click_typesOf_LL_link() {
		lp.typesof_LL_link();

	}

	@Then("The user should be directed to Types of Linked List Page")
	public void Goto_typesOf_LL_page() {
		try {
			lp.validate_navigatePage();
		} catch (Exception e) {
		}
	}

	@When("The user clicks the Implement Linked List in Python link")
	public void click_implement_LL__python_link() {
		lp.implement_LL_link();

	}

	@Then("The user should be directed to Implement Linked List in Python Page")
	public void the_user_should_be_directed_to_implement_linked_list_in_python_page() {
		try {
			lp.validate_navigatePage();
		} catch (Exception e) {
		}
	}

	@Given("The user is in the Implement Linked List in Python page")
	public void the_user_is_in_the_implement_linked_list_in_python_page() {
		lp.NavigatePage_implementPython();
	}

	@When("The user clicks the Traversal link")
	public void the_user_clicks_the_traversal_link() {
		lp.traversal_click();

	}

	@Then("The user should be directed to Traversal Page")
	public void the_user_should_be_directed_to_traversal_page() {
		try {
			lp.validate_navigatePage();
		} catch (Exception e) {

		}
	}

	@Given("The user is in the Traversal page")
	public void the_user_is_in_the_traversal_page() {
		lp.NavigatePage_traversal();
	}

	@When("The user clicks the Insertion link")
	public void the_user_clicks_the_insertion_link() {
		lp.insertion_click();

	}

	@Then("The user should be directed to Insertion Page")
	public void the_user_should_be_directed_to_insertion_page() {
		try {
			lp.validate_navigatePage();
		} catch (Exception e) {

		}
	}

	@Given("The user is in the Insertion page")
	public void the_user_is_in_the_insertion_page() {
		lp.NavigatePage_insertion();
	}

	@When("The user clicks the Deletion link")
	public void the_user_clicks_the_deletion_link() {
		lp.deletion_click();

	}

	@Then("The user should be directed to Deletion Page")
	public void the_user_should_be_directed_to_deletion_page() {
		try {
			lp.validate_navigatePage();
		} catch (Exception e) {

		}
	}

	@Given("The user is in the Deletion page")
	public void the_user_is_in_the_deletion_page() {

		lp.NavigatePage_deletion();
	}

	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() {
		lp.PracticeInput_Click();

	}

	@Then("The user should be redirected to Practice page")
	public void the_user_should_be_redirected_to_practice_page() {
		try {
			lp.validate_navigatePage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
