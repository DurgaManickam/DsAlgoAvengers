package com.dsalgoproject.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.dsalgoproject.utilities.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private static String browser;

	public static void setBrowser(String browser) {
		Hooks.browser = browser;
	}

	@Before
	public void setUp(Scenario scenario) {
		DriverFactory.initializeDriver(browser);
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			// Quit WebDriver after taking the screenshot
			DriverFactory.quitDriver();
		}
	}

	@AfterAll
	public static void tearDown() {
		// Quit WebDriver after the last scenario
		DriverFactory.quitDriver();
	}
}
