package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.dsalgoproject.hooks.Hooks;

// Runner file to Test Cross Browser Testing - used in testng.xml
@CucumberOptions(features = "src/test/resources/com/dsalgoproject/features", glue = {
		"com.dsalgoproject.stepdefinitions", "com.dsalgoproject.hooks" }, plugin = { "pretty",
				"html:target/crossBrowserCucumberReports/cbCucumberReport.html",
				"json:target/crossBrowserCucumberReports/cbCucumberReportJson.json",
				"junit:target/crossBrowserCucumberReports/cbCucumberReportXml.xml",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, tags = "@landing or @graph", monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

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