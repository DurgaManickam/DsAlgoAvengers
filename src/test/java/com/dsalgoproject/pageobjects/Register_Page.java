package com.dsalgoproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgoproject.utilities.Events;

public class Register_Page {
	// Locators
	@FindBy(id = "id_username")
	WebElement username;
	@FindBy(id = "id_password1")
	WebElement password;
	@FindBy(id = "id_password2")
	WebElement passwordConfirmation;
	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerButton;
	@FindBy(xpath = "//a[text()='Login ']")
	WebElement loginButton;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement errorMessage;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Register_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enter_username(String username) {
		this.username.sendKeys(username);
	}

	public void enter_password(String password) {
		this.password.sendKeys(password);
	}

	public void enter_password_confirmation(String passwordConfirmation) {
		this.passwordConfirmation.sendKeys(passwordConfirmation);
	}

	public void click_register() {
		Events.click(registerButton, "Register");
	}

	public void click_Login() {
		Events.click(loginButton, "Login");
	}

	public String getMessage() {
		return errorMessage.getText();
	}
}
