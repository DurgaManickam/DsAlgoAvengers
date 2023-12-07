package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Queue_Page {

	private WebDriver driver;
	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passcode;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement SignInBtn;
	@FindBy(xpath="//div[@class='dropdown-menu show']//a[@href='/queue' and text()='Queue']")
	WebElement queue_dropdown;
	@FindBy(xpath="//div[@class='nav-item dropdown']//a[@class='nav-link dropdown-toggle']")
	WebElement dropdown_List;
	@FindBy(xpath = "//div//button[@type='button']")
	WebElement runbutton;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[1]/textarea")
	WebElement textarea;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement Tryhere_button;
	

	public Queue_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username,String password) {
		uname.sendKeys(username);
		passcode.sendKeys(password);
		SignInBtn.click();
		System.out.println("Current URL of the page : " + driver.getCurrentUrl());
		dropdown_List.click();
		queue_dropdown.click();
	}
	public void click_Page(String pagename,String url) {
		System.out.println("Inside validate page  :"+pagename);
		 WebElement link = driver.findElement(By.partialLinkText(pagename));
	        link.click();
	        System.out.println("Navigated to :" +driver.getCurrentUrl());
	        
    }
	// method for Tryhere button
		public void click_Tryhere() {
			Tryhere_button.click();
			System.out.println("Tryhere button is clicked");
			textarea.sendKeys("print('Hi this is a python print')");
			System.out.println("tried python code in editor-introduction of linkedlist");
			if (runbutton.isDisplayed() && runbutton.isEnabled()) {
				System.out.println("inside runbutton code");
				runbutton.click();
			}
		}
	
	public void ValidatePage(String url) {
		System.out.println("Inside validate page  :"+url);
		String pageTitle = driver.getTitle();
		try {
        assert pageTitle.contains(url);
        }
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		System.out.println("Navigated to :" +driver.getCurrentUrl());
		
	}
}
