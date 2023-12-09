package com.dsalgoproject.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.pageobjects.Array_Page;
import com.dsalgoproject.pageobjects.Login_Page;
import com.dsalgoproject.utilities.AppConstants;
import com.dsalgoproject.utilities.DriverFactory;
import com.dsalgoproject.utilities.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Arrays_Steps {
	WebDriver driver = DriverFactory.getDriver();
	Array_Page array_Page = new Array_Page(driver);
	Login_Page login_Page = new Login_Page(driver);
	private String runOutput;
	private String submitOutput;

	@Given("Login to DsAlsgo website with valid username {string} and password {string} and navigate to Array page.")
	public void loginToDSAlgoBeforeArray(String username, String pasword) {

		System.out.println("I am inside Login SD file");
		driver.get("https://dsportalapp.herokuapp.com/login");

		try {
			login_Page.loginValidUser(username, pasword);
			login_Page.clickLogin();
		} catch (Throwable e) {
			System.out.println(e);
		}
	}

	@Given("The user is on the Array Page after logged in")
	public void check_if_user_in_arrayPage() {
		System.out.println(AppConstants.ARRAY_PAGE_URL);
		driver.get(AppConstants.ARRAY_PAGE_URL);

		Assert.assertEquals(driver.getCurrentUrl(), AppConstants.ARRAY_PAGE_URL);
	}

	@When("The user clicks {string} button")
	public void clicking_on_button_from_array_page(String array_options) {
		array_Page.click_array_options(array_options, driver);
	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String url) {
		Assert.assertEquals(url, driver.getCurrentUrl());
	}

	@Given("The user is in the {string} page after clicking on the option")
	public void the_user_is_in_the_page_after_clicking_on_the_option(String array_options) {
		// must be in array page
		switch (array_options) {
		case "Arrays in Python":
			driver.get(AppConstants.ARRAY_PAGE_PYTHON_URL);
			break;
		case "Arrays using List":
			driver.get(AppConstants.ARRAY_PAGE_USING_LIST_URL);
			break;
		case "Basic Operations in List":
			driver.get(AppConstants.ARRAY_PAGE_BASIC_OPERATIONS_URL);
			break;
		case "Applications of Array":
			driver.get(AppConstants.ARRAY_PAGE_APP_OF_ARRAY_URL);
			break;
		case "Pratice Questions":
			driver.get(AppConstants.ARRAY_PAGE_PRACTICE);
			break;
		default:
			break;
		}
	}

	@When("The user clicks {string} button in {string} page")
	public void click_try_Here_in_array_options(String string, String string2) {
		array_Page.click_tryHere();
	}

	@Then("The user will be redirected to a page having an tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		Assert.assertEquals(driver.getCurrentUrl(), AppConstants.TRY_EDITOR_URL);
	}

	@Given("The user is in the TryEditor page")
	public void user_in_try_editor_page() {
		driver.get(AppConstants.TRY_EDITOR_URL);
	}

	@When("The user passes {string} to textarea and click Run button")
	public void input_text_to_Editor(String questionString) {
		array_Page.inputQuestion(questionString, driver);
		array_Page.clickRun();
	}

	@Then("Validate the {string} with actual result")
	public void validate_run_result(String actualOutput) {
		String expectedOutput = array_Page.get_output();
		Assert.assertEquals(actualOutput, expectedOutput);
	}

	@Then("Validate the alert box {string}")
	public void invalid_text_alert_message(String actualOutput) {
		String expectedOutput = array_Page.invalidate_run(driver);
		Assert.assertEquals(actualOutput, expectedOutput);
	}

	@When("^The user passes input as number to textarea and click Run button$")
	public void invalid_number_as_input(DataTable uservalues) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		// Write the code to handle Data Table
		List<String> inputNumberList = uservalues.asList(String.class);

		// Assuming you want to use the first row of the DataTable
		String inputNumber = inputNumberList.get(0);

		// Assume you have a method to pass inputNumber to the textarea and click Run
		// button
		array_Page.inputQuestion(inputNumber, driver);
	}

	@Then("The output should be null")
	public void number_as_input_result(DataTable dataTable) {
		List<String> inputNumberList = dataTable.asList(String.class);
		Assert.assertNull(inputNumberList.get(0));

	}

	@Given("The user is on any of the links in the Array Page after logged in")
	public void options_array() {
		driver.get(AppConstants.ARRAY_PAGE_PYTHON_URL);
		Assert.assertEquals(AppConstants.ARRAY_PAGE_PYTHON_URL, driver.getCurrentUrl());
	}

	@Then("The user should be redirected to page")
	public void redirected_to_practice(DataTable dataTable) {
		List<String> data = dataTable.asList(String.class);
		Assert.assertEquals(AppConstants.ARRAY_PAGE_PRACTICE, data.get(0));

	}

	@Given("The user is in the Practice page")
	public void the_user_is_in_the_practice_page() {
		driver.get(AppConstants.ARRAY_PAGE_PRACTICE);
		Assert.assertEquals(AppConstants.ARRAY_PAGE_PRACTICE, driver.getCurrentUrl());
	}

	@When("The user clicks the {string} link")
	public void the_user_clicks_the_link(String questionText) {
		array_Page.click_question(questionText);
	}

	@Then("The user should be redirected to {string} contains a question,an tryEditor with Run and Submit buttons")
	public void redirected_to_question_page(String expectedOutput) {
		Assert.assertEquals(driver.getCurrentUrl(), expectedOutput);
	}

	@When("enters answer from excelfile for {int} in tryEditor")
	public void enters_sheet_name_and_rownumber_row_number_in_try_editor(Integer rowNumber)
			throws IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		System.out.println(AppConstants.TEST_DATA_EXCEL_PATH);
		List<Map<String, String>> testdata = reader.getData(AppConstants.TEST_DATA_EXCEL_PATH,
				AppConstants.ARRAY_PRACTICE_QUES_ANSWER_SHEET);
		String question = testdata.get(rowNumber).get("practiceQuestion");
		String code = testdata.get(rowNumber).get("answer");
		runOutput = testdata.get(rowNumber).get("RunButtonOutput");
		submitOutput = testdata.get(rowNumber).get("SubmitButtonOutput");
		System.out.println(question);
		array_Page.practice_ques_inp(code, driver);
		Thread.sleep(2000);

	}

	@When("clickRun button")
	public void click_run() {
		array_Page.clickRun();
	}

	@When("clickSubmit button")
	public void click_submit() {
		array_Page.clickSubmit();
	}

	@Then("Validate the runoutput")
	public void validate_the_runoutput() {
		Assert.assertEquals(array_Page.get_output(), runOutput);
	}

	@Then("Validate the submitoutput")
	public void validate_the_submitoutput() {
		Assert.assertEquals(array_Page.get_output(), submitOutput);
	}
}
