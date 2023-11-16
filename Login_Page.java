package webPages;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverManager;

public class Login_Page {

	private WebDriver driver;
	// 1.By Locators :
	private By username = By.id("id_username");
	private By startbutton = By.xpath("//a[@href='/home']/button[@class='btn']");
	private By password = By.id("id_password");
	private By SignInBtn = By.xpath("//input[@type='submit']");
	private By Signinlink = By.xpath("//a[@href='/login']");
	private By message = By.xpath("//div[@class='alert alert-primary']");
	private By loggedin_userid = By.xpath("//div[@class='navbar-nav']//ul//a[2]");
	String username_entered;
	private By errormessage_login=By.xpath("//div[@class='alert alert-primary']");

	// 2.constructor
	public Login_Page(WebDriver driver) {

		this.driver = driver;
	}

	public void clickLogin() {

		driver.findElement(SignInBtn).click();
		System.out.println("logged in successfully");
	}

	public void IsItHomepage() {

		String ExpectedMSg = "You are logged in";
		String msg = driver.findElement(message).getText();
		System.out.println("the value of message    :" + msg);
		Assert.assertEquals(ExpectedMSg, msg);

		String logged_user = driver.findElement(loggedin_userid).getText();

		System.out.println("the value of logged in user details    " + logged_user);

		System.out.println("The value of Login userid send through input  " + username_entered);

		Assert.assertEquals(logged_user.toLowerCase(), username_entered.toLowerCase());
		System.out.println("The value of Login userid through input + value at top right corner of logged in page  "
				+ username_entered + logged_user);
		System.out.println("Successful Login to Home Page");

	}

	public void Getstarted() {

		System.out.println("inside getstarted code");
		driver.findElement(startbutton).isDisplayed();
		driver.findElement(startbutton).click();

		System.out.println("Am inside Getstarted and clicking the signin link");

	}

	public void Signin_Page() {
		System.out.println("Am inside signin page link code");
		driver.findElement(Signinlink).click();
		System.out.println("Clicked Signin link and landed on Login home page");

	}

	public void loginValidUser(String uname, String passwrd) throws Throwable {
		//| numpyninja@123 | Qwerty@123 |
		System.out.println("Am inside the valid user section");
		username_entered = uname;
		driver.findElement(username).sendKeys(uname); 
		System.out.println("entered username successfully");
         driver.findElement(password).sendKeys(passwrd);
     	Thread.sleep(1000);

		System.out.println("entered password successfully");
		
if(!(uname.equalsIgnoreCase("numpyninja@123") && passwrd.equalsIgnoreCase("Qwerty@123"))) {
			
			String Err_message=driver.findElement(errormessage_login).getText();//error message :Invalid Username and Password
	     	assertTrue(Err_message.contains("Invalid username"));
		    System.out.println(Err_message);
	         DriverManager.quitDriver();
	          }
			if(uname.equals("")) {
				System.out.println("blank username entered.Enter valid value"+uname);//modify code
				 DriverManager.quitDriver();
			}
			if(passwrd.equals("")){
				System.out.println("blank password entered.Enter valid value"+passwrd);//modify code
				 DriverManager.quitDriver();
			}
	}

	}

