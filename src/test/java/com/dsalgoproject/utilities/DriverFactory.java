package com.dsalgoproject.utilities;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	private static WebDriver driver;
	private static ConfigurationReader configReader = new ConfigurationReader(AppConstants.CONFIG_PROPERTIES_FILE_NAME);

	public static WebDriver initializeDriver(String browserType) {
		if (driver == null) {
			if ("chrome".equalsIgnoreCase(browserType)) {
				ChromeOptions options = chromeCapabilities();
				driver = new ChromeDriver(options);
			} else if ("firefox".equalsIgnoreCase(browserType)) {
				FirefoxOptions options = firefoxCapabilities();
				driver = new FirefoxDriver(options);
			} else if ("edge".equalsIgnoreCase(browserType)) {
				EdgeOptions options = edgeCapabilities();
				driver = new EdgeDriver(options);
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configReader.getImplicitWaitTimeout()));
			return driver;
		} else {
			return driver;
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		System.out.println("Quitting WebDriver");
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	private static ChromeOptions chromeCapabilities() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setAcceptInsecureCerts(true);
		options.setScriptTimeout(Duration.ofSeconds(30));
		options.setPageLoadTimeout(Duration.ofMillis(30000));
		options.setImplicitWaitTimeout(Duration.ofSeconds(configReader.getImplicitWaitTimeout()));
		options.addArguments("start-maximized");
		options.addArguments("--incognito");
		return options;
	}

	private static FirefoxOptions firefoxCapabilities() {
		FirefoxOptions options = new FirefoxOptions();
		// Add Firefox-specific capabilities if needed
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setAcceptInsecureCerts(true);
		options.setScriptTimeout(Duration.ofSeconds(30));
		options.setPageLoadTimeout(Duration.ofMillis(30000));
		options.setImplicitWaitTimeout(Duration.ofSeconds(configReader.getImplicitWaitTimeout()));
		options.addArguments("--start-maximized");
		options.addArguments("-private");
		return options;
	}

	private static EdgeOptions edgeCapabilities() {
		EdgeOptions options = new EdgeOptions();
		// Add edge-specific capabilities if needed
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setAcceptInsecureCerts(true);
		options.setScriptTimeout(Duration.ofSeconds(30));
		options.setPageLoadTimeout(Duration.ofMillis(30000));
		options.setImplicitWaitTimeout(Duration.ofSeconds(configReader.getImplicitWaitTimeout()));
		options.addArguments("--start-maximized");
		options.addArguments("--inprivate");
		return options;
	}
}
