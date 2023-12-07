package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.utilities.Events;

/**
 * Dsalgo portal page - Landing Page
 */
public class Landing_Page {
	
	// $x("//button[text()='Get Started']")
	@FindBy(xpath = "//button[text()='Get Started']") 
	WebElement getStarted;
	
	public Landing_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void click_get_started() {
		Events.click(getStarted, "Get Started");
		// if suppose getStarted.click();
	}
}
