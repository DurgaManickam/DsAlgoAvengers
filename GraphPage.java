package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GraphPage {

	private WebDriver driver;
	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passcode;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement SignInBtn;
	@FindBy(xpath="//div[@class='dropdown-menu show']//a[@href='/graph' and text()='Graph']")
	WebElement graph_dropdown;
	@FindBy(xpath="//div[@class='nav-item dropdown']//a[@class='nav-link dropdown-toggle']")
	WebElement dropdown_List;
	public GraphPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username,String password) {
		uname.sendKeys(username);
		passcode.sendKeys(password);
		SignInBtn.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("landing into home page to proceed into Queue page option");
		System.out.println("Current URL of the page : " + driver.getCurrentUrl());
		dropdown_List.click();
		graph_dropdown.click();
	}
}
