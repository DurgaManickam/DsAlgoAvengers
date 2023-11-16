package driverFactory;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverManager {
	
	private  static WebDriver driver;
	
	private DriverManager() {
        // private constructor to prevent instantiation
    }
	
	
	public  static WebDriver getDriver() {
		
		  System.out.println("Initializing WebDriver");
		
		if(driver==null) {
			
		 ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.setScriptTimeout(Duration.ofSeconds(30));
		chromeOptions.setPageLoadTimeout(Duration.ofMillis(30000));
	
		chromeOptions.addArguments("start-maximized");
		 driver = new ChromeDriver(chromeOptions);
		  }
		  
		return driver;
	}
	
	
	   public  static void quitDriver() {
		 System.out.println("Quitting WebDriver");
		
	        if (driver != null) {
	            driver.quit();
	           driver=null;
	        }
	 }
	
}


