package com.dsalgoproject.pageobjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dsalgoproject.utilities.LoggerLoad;

public class Login_Page {

	private WebDriver driver;
	// 1.By Locators :
	private By username = By.id("id_username");

	private By startbutton = By.xpath("//a[@href='/home']/button[@class='btn']");
	private By password = By.id("id_password");
	private By SignInBtn = By.xpath("//input[@type='submit']");
	private By Signinlink = By.xpath("//a[@href='/login']");

	private By loggedin_userid = By.xpath("//div[@class='navbar-nav']//ul//a[2]");
	String username_entered;

	private By message_login = By.xpath("//div[contains(@class,'alert-primary')]");

	private static final String ERR_MSG_INVALID_CREDENTIALS = "Invalid Username and Password";
	private static final String REAL_LOGINID = "numpyninja@123";
	private static final String REAL_PASSWORD = "Qwerty@123";
	private static final String HOMEPAPAGEEXPECTED_URL = "https://dsportalapp.herokuapp.com/home";
	private static final String EXPECTEDMSG = "You are logged in";

	// 2.constructor
	public Login_Page(WebDriver driver) {

		this.driver = driver;
	}

	public void clickLogin() {

		driver.findElement(SignInBtn).click();

	}

	public void LoginValidate(String userid, String UserPassword) {

		if (userid.isBlank() && !(UserPassword.isBlank())) {
			loginValidationError();
		}

		else if (UserPassword.isBlank() && !(userid.isBlank())) {
			loginValidationError();
		} else if (UserPassword.isBlank() && (userid.isBlank())) {

			loginValidationError();
		}

		else if (!(userid.isBlank() && UserPassword.isBlank())) {
			if (!((userid.equalsIgnoreCase(REAL_LOGINID)) && UserPassword.equalsIgnoreCase(REAL_PASSWORD))) {
				String err_message = getErrorMessage(message_login);

				if (err_message.equalsIgnoreCase(ERR_MSG_INVALID_CREDENTIALS)) {
					System.out.println("username and password input is invalid :" + err_message);
				}
			}

			else {
				System.out.println("signin button is clicked successfully and needs validation.");
			}
		}
	}

	private String getErrorMessage(By messageLocator) {
		try {
			WebElement msg_text = driver.findElement(messageLocator);
			return msg_text.getText();
		} catch (NoSuchElementException e) {

			return "Error message element not found";
		}
	}

	public void loginValidationError() {
		WebElement activeElement = driver.switchTo().activeElement();
		String errormsg = activeElement.getAttribute("validationMessage");// Please fill out this field
		System.out.println("Actual message appeared on screen  : " + errormsg);

	}

	public void IsItHomepage(String uname) {

		String homepage_url = driver.getCurrentUrl();
		if (HOMEPAPAGEEXPECTED_URL.equalsIgnoreCase(homepage_url)) {

			String msg = getErrorMessage(message_login);
			String logged_user = getErrorMessage(loggedin_userid);

			if (EXPECTEDMSG.equalsIgnoreCase(msg) && logged_user.equalsIgnoreCase(uname)) {
				System.out.println("Successful Login to Home Page");
			}
		} else {

			System.out.println("FAIL: You are not logged in.Current URL is :" + driver.getCurrentUrl());
		}

	}

	public void Getstarted() {

		driver.findElement(startbutton).isDisplayed();
		driver.findElement(startbutton).click();
	}

	public void Signin_Page() {
		try {
			driver.findElement(Signinlink).click();
		}catch(AssertionError e) {
			LoggerLoad.info(e.getMessage());
		}
	}

	public void loginValidUser(String uname, String passwrd) throws Throwable {

		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(passwrd);

	}

}