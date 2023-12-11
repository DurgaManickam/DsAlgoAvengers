package com.dsalgoproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Stack_Page {

	private WebDriver driver;
	@FindBy(xpath = "//a[@href='operations-in-stack']")
	WebElement operations;
	@FindBy(xpath = "//a[@href='implementation']")
	WebElement implementation;
	@FindBy(xpath = "//a[@href='stack-applications']")
	WebElement Stackapplications;

	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement Tryhere_button;
	@FindBy(xpath = "//div//button[@type='button']")

	WebElement runbutton;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[1]/textarea")
	WebElement textarea;

	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passcode;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement SignInBtn;
	@FindBy(xpath = "//a[@href='/stack/practice']")
	WebElement Practice;
	@FindBy(xpath = "//div[@class='dropdown-menu show']//a[@href='/stack' and text()='Stack']")
	WebElement Stack_dropdown;
	@FindBy(xpath = "//div[@class='nav-item dropdown']//a[@class='nav-link dropdown-toggle']")
	WebElement dropdown_List;
	private final String STACK_PRACTICE_URL = "https://dsportalapp.herokuapp.com/stack/practice";
	private final String OPERATIONS_URL = "https://dsportalapp.herokuapp.com/stack/operations-in-stack/";
	private final String IMPLEMENTATION_URL = "https://dsportalapp.herokuapp.com/stack/implementation/";
	private final String APPLICATIONS_URL = "https://dsportalapp.herokuapp.com/stack/stack-applications/";
	private final String RUN_BUTTON_LINK = "https://dsportalapp.herokuapp.com/tryEditor";
	private String newURL;

	public Stack_Page(WebDriver driver) {
		// Initialize elements using PageFactory

		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/*
	 * 1. choose Stack from Dropdown.
	 */
	public void login(String username, String pwd) {
		uname.sendKeys(username);
		passcode.sendKeys(pwd);
		SignInBtn.click();
		dropdown_List.click();
		Stack_dropdown.click();
		System.out.println("inside stack page  :" + driver.getCurrentUrl());

	}

	// methods for options inside Stack page

	public void operations_click() {
		operations.click();
	}

	public void implementation_click() {
		implementation.click();

	}

	public void applications_click() {
		Stackapplications.click();

	}

	public void PracticeInput_Click() {
		Practice.click();

	}

	public void click_Tryhere() {
		Tryhere_button.click();

	}

	// method : tryEditor with a Run button to test
	public void goto_runEditor_page() {
		driver.navigate().to(RUN_BUTTON_LINK);
		textarea.sendKeys("print('Hi this is a python print')");
		System.out.println("tried python code in Operations in Stack.");
		if (runbutton.isDisplayed() && runbutton.isEnabled()) {

			runbutton.click();
		}

	}

	/*
	 * method : validating if the user is directed to the correct page after
	 * clicking the options inside Stack page
	 */
	public void validateNavigatePage(String expectedURL, String pageName) throws InterruptedException {
		newURL = driver.getCurrentUrl();
		System.out.println("Current URL of the page : " + newURL);

		if (expectedURL.equals(newURL)) {
			System.out.println("Navigated to " + pageName + " page");
		} else {
			System.out.println(pageName + " link is failed");
		}
	}

	public void validate_navigatePage_operations() throws InterruptedException {
		validateNavigatePage(OPERATIONS_URL, "operations of stack");
	}

	public void validate_navigatePage_implementation() throws InterruptedException {
		validateNavigatePage(IMPLEMENTATION_URL, "implementation of stack");

	}

	public void validate_navigatePage_applications() throws InterruptedException {

		validateNavigatePage(APPLICATIONS_URL, "applications of stack");

	}

	public void validate_navigatePage_Practice() throws InterruptedException {

		validateNavigatePage(STACK_PRACTICE_URL, "practice questions of stack");

	}

	// user must navigate inside stack page
	public void NavigatePage_operations() throws InterruptedException {

		NavigatePage(OPERATIONS_URL, "operations of stack");

	}

	public void NavigatePage_implementation() throws InterruptedException {

		NavigatePage(IMPLEMENTATION_URL, "implementation of stack");
	}

	public void NavigatePage_applications() throws InterruptedException {
		NavigatePage(APPLICATIONS_URL, "applications of stack");
	}

	public void NavigatePage(String expectedURL, String pageName) throws InterruptedException {
		if (expectedURL.equals(newURL)) {
			System.out.println("The user is in " + pageName + "page");
		} else {
			driver.get(expectedURL);
		}
	}

}