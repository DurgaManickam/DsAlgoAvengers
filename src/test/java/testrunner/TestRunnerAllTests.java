package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.dsalgoproject.hooks.Hooks;

// Test Runner file to test all the features in Chrome Browser - - used in testngAllTests.xml
@CucumberOptions(features = "src/test/resources/com/dsalgoproject/features", glue = {
		"com.dsalgoproject.stepdefinitions", "com.dsalgoproject.hooks" }, plugin = { "pretty",
				"html:target/allTestsCucumberReports/allTestCucumberReport.html",
				"json:target/allTestsCucumberReports/allTestCucumberReportJson.json",
				"junit:target/allTestsCucumberReports/allTestCucumberReportXml.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, tags = "not @signout", monochrome = true)
public class TestRunnerAllTests extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browser) {
		Hooks.setBrowser(browser);
	}

}