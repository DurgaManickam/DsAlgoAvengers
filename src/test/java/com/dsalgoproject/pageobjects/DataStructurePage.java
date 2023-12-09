package com.dsalgoproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataStructurePage {

	private WebDriver driver;
	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passcode;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement SignInBtn;

	@FindBy(xpath = "//a[@href='data-structures-introduction' and text()='Get Started']")
	WebElement getstart_ds_button;
	@FindBy(xpath = "//div//button[@type='button']")
	WebElement runbutton;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[1]/textarea")
	WebElement textarea;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement Tryhere_button;

	public DataStructurePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		uname.sendKeys(username);
		passcode.sendKeys(password);
		SignInBtn.click();
		getstart_ds_button.click();
		System.out.println("Current URL of the page : " + driver.getCurrentUrl());

	}

	public void click_Page_DataStructure(String pagename, String url) {
		System.out.println("Inside validate page of DS pages :" + pagename);
		WebElement link = driver.findElement(By.partialLinkText(pagename));
		link.click();
		System.out.println("Navigated to :" + driver.getCurrentUrl());

	}

	public void click_Tryhere() {
		Tryhere_button.click();
		System.out.println("Tryhere button is clicked in datastructure");
		textarea.sendKeys("print('Hi this is a python print')");
		if (runbutton.isDisplayed() && runbutton.isEnabled()) {
			System.out.println("inside runbutton code");
			runbutton.click();
		}
	}

	public void ValidatePage_DataStructure(String url) {
		System.out.println("Inside validate page  :" + url);
		String pageUrl = driver.getCurrentUrl();

		try {
			assert pageUrl.contains(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Navigated to :" + driver.getCurrentUrl());

	}
}