package com.dsalgoproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signout_Page {
	private WebDriver driver;
	@FindBy(xpath = "//div[@class='navbar-nav']//ul//a[3][@href='/logout']") //// div[@class='navbar-nav']//ul//a[3]
	WebElement signout_button;

	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passcode;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement SignInBtn;

	public Signout_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		uname.sendKeys(username);
		passcode.sendKeys(password);
		SignInBtn.click();
	}

	public void signout() {
		signout_button.click();
	}

	public void validatesignoutuser(String url) {
		System.out.println("Inside validate page  :" + url);
		String pageUrl = driver.getCurrentUrl();

		try {
			assert pageUrl.contains(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("user logged out successfully" + driver.getCurrentUrl());

	}

}
