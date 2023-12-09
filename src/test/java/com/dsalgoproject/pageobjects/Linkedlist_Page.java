package com.dsalgoproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Linkedlist_Page {
//Page Factory

	private WebDriver driver;

	@FindBy(xpath = "//a[@href='introduction']")
	WebElement introlink;
	@FindBy(xpath = "//a[@href='creating-linked-list']")
	WebElement create_linkedlist_link;
	@FindBy(xpath = "//a[@href='implement-linked-list-in-python']")
	WebElement implement_linkedlist_link;
	@FindBy(xpath = "//a[@href='types-of-linked-list']")
	WebElement typesof_linkedlist_link;
	@FindBy(xpath = "//a[@href='traversal']")
	WebElement traversal_link;
	@FindBy(xpath = "//a[@href='insertion-in-linked-list']")
	WebElement insertion_link;
	@FindBy(xpath = "//a[@href='deletion-in-linked-list']")
	WebElement deletion_link;
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
	@FindBy(xpath = "//a[@href='linked-list']")
	WebElement linkedlist_startbutton;
	@FindBy(xpath = "//a[@href='/linked-list/practice']")
	WebElement Practice;

	@FindBy(xpath = "//div[@class='dropdown-menu show']//a[@href='/linked-list' and text()='Linked List']")
	WebElement linkedlist_dropdown;
	@FindBy(xpath = "//div[@class='nav-item dropdown']//a[@class='nav-link dropdown-toggle']")
	WebElement dropdown_List;

	private final String INTRODUCTION_URL = "https://dsportalapp.herokuapp.com/linked-list/introduction/";
	private final String CREATE_LL_URL = "https://dsportalapp.herokuapp.com/linked-list/creating-linked-list/";
	private final String TYPESOF_LL_URL = "https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/";
	private final String IMPLEMENT_PYTHON_LL_URL = "https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/";
	private final String TRAVERSAL_LL_URL = "https://dsportalapp.herokuapp.com/linked-list/traversal/";
	private final String INSERTION_LL_URL = "https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/";
	private final String DELETION_LL_URL = "https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/";
	private final String PRACTICEQUESTION_LL_URL = "https://dsportalapp.herokuapp.com/linked-list/practice";

	private final String RUN_BUTTON_LINK = "https://dsportalapp.herokuapp.com/tryEditor";
	private String newURL;

	public Linkedlist_Page(WebDriver driver) {
		// Initialize elements using PageFactory
		System.out.println("Inside constructor of linkedlist page");
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/*
	 * 1. choose Linkedlist from Dropdown.
	 */
	public void login(String username, String pwd) {
		uname.sendKeys(username);
		passcode.sendKeys(pwd);
		SignInBtn.click();
		System.out.println("Current URL of the page : " + driver.getCurrentUrl());
		dropdown_List.click();
		linkedlist_dropdown.click();

	}

	/*
	 * methods for clicking the menu links in Linkedlist page
	 * 
	 */
	public void click_introlink() {
		introlink.click();
	}

	public void click_createlinkedlist() {

		create_linkedlist_link.click();
	}

	public void implement_LL_link() {
		implement_linkedlist_link.click();
	}

	public void typesof_LL_link() {
		typesof_linkedlist_link.click();
	}

	public void traversal_click() {
		traversal_link.click();
	}

	public void insertion_click() {
		insertion_link.click();
	}

	public void deletion_click() {
		deletion_link.click();
	}

	public void PracticeInput_Click() {
		Practice.click();
	}

	/*
	 * method : validating if the user is directed to the correct page after
	 * clicking the options inside LinkedList page
	 */

	public void validate_navigatePage() throws InterruptedException {
		newURL = driver.getCurrentUrl();

		System.out.println("Current URL of the page : " + driver.getCurrentUrl());

		if (INTRODUCTION_URL.equals(newURL)) {
			System.out.println("Navigated to Introduction link page");
		} else {
			System.out.println("introduction link is failed");
		}

		if (CREATE_LL_URL.equals(newURL)) {
			System.out.println("Navigated to create LinkedList page");
		} else {
			System.out.println("create LinkedList is failed");
		}

		if (TYPESOF_LL_URL.equals(newURL)) {

			System.out.println("Navigated to typesof LinkedList page.");
		} else {
			System.out.println("typesof LinkedList is failed");
		}
		if (IMPLEMENT_PYTHON_LL_URL.equals(newURL)) {

			System.out.println("Navigated to implement LinkedList in python page.");
		} else {

			System.out.println("implement LinkedList in python is failed");
		}

		if (TRAVERSAL_LL_URL.equals(newURL)) {
			System.out.println("Navigated to traversal LinkedList page.");
		} else {
			System.out.println("traversal LinkedList is failed");
		}

		if (INSERTION_LL_URL.equals(newURL)) {
			System.out.println("Navigated to insertion LinkedList page.");
		} else {
			System.out.println("insertion LinkedList is failed");
		}
		if (DELETION_LL_URL.equals(newURL)) {
			System.out.println("Navigated to deletion LinkedList page.");
		} else {
			System.out.println("deletion LinkedList is failed");
		}
		if (PRACTICEQUESTION_LL_URL.equals(newURL)) {
			System.out.println("Navigated to practice questions  LinkedList page.");
			Thread.sleep(500);
		} else {
			try {

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}

	// method :The user must navigate the page that is clicked inside Linked list
	// page
	public void NavigatePage_Intro() {

		if (INTRODUCTION_URL.equals(newURL)) {
			System.out.println("Introduction link  is passed");
		} else {
			driver.get(INTRODUCTION_URL);
		}
	}

	public void NavigatePage_create() {
		if (CREATE_LL_URL.equals(newURL)) {
			System.out.println("create LinkedList is passed");
		} else {
			driver.get(CREATE_LL_URL);
		}
	}

	public void NavigatePage_typesOF() {
		if (TYPESOF_LL_URL.equals(newURL)) {

			System.out.println("create LinkedList is passed");
		} else {
			driver.get(TYPESOF_LL_URL);
		}
	}

	public void NavigatePage_implementPython() {
		if (IMPLEMENT_PYTHON_LL_URL.equals(newURL)) {

			System.out.println("implement LinkedList in python is passed");
		} else {
			driver.get(IMPLEMENT_PYTHON_LL_URL);
		}
	}

	public void NavigatePage_traversal() {
		if (TRAVERSAL_LL_URL.equals(newURL)) {
			System.out.println("traversal LinkedList is passed");
		} else {
			driver.get(TRAVERSAL_LL_URL);
		}
	}

	public void NavigatePage_deletion() {
		if (DELETION_LL_URL.equals(newURL)) {
			System.out.println("deletion LinkedList is passed");
		} else {
			driver.get(DELETION_LL_URL);
		}
	}

	public void NavigatePage_insertion() {
		if (INSERTION_LL_URL.equals(newURL)) {
			System.out.println("insertion LinkedList is passed");
		} else {
			driver.get(INSERTION_LL_URL);
		}
	}

	public void NavigatePage_practice() {
		if (PRACTICEQUESTION_LL_URL.equals(newURL)) {
			System.out.println("practice questions  LinkedList is clicked");
		} else {
			driver.get(PRACTICEQUESTION_LL_URL);
		}
	}

	// method for Tryhere button
	public void click_Tryhere() {
		Tryhere_button.click();
		System.out.println("Tryhere button is clicked");

	}

	// method : tryEditor with a Run button to test
	public void goto_runEditor_page() {
		driver.navigate().to(RUN_BUTTON_LINK);
		textarea.sendKeys("print('Hi this is a python print')");
		if (runbutton.isDisplayed() && runbutton.isEnabled()) {
			System.out.println("inside runbutton code");
			runbutton.click();
		}

	}
}
