package com.dsalgo.utilities;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	private static WebDriver driver;

	public static WebDriver initializeDriver() {
		if (driver == null) {
			ChromeOptions options = browserCapablities();
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
		} else {
			return driver;
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static ChromeOptions browserCapablities() {
		ChromeOptions options = new ChromeOptions(); // to handle unexcepted conditions
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);// NORMAL wait for unpredictable delay
		options.setAcceptInsecureCerts(true);// driver understand code will proceed if certificate is invalid
		options.setScriptTimeout(Duration.ofSeconds(30));// google is not responding dialog
		options.setPageLoadTimeout(Duration.ofMillis(30000));// eg 404 error , wait till page loads after specified time
																// timeout exception
		options.setImplicitWaitTimeout(Duration.ofSeconds(30));// waiting for element
		options.addArguments("start-maximized"); // to open in maximum mode
		options.addArguments("--incognito");// open in incognito mode
		return options;
	}
	public static void quitDriver() {
		System.out.println("Quitting WebDriver");
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
