package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;


//import io.cucumber.junit.Cucumber;
//import org.junit.runner.RunWith;
//@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/com/dsalgoproject/features",
    glue = "com.dsalgoproject.stepdefinitions",
    plugin = {"pretty", "html:target/cucumberReports/cucumberReport.html",
    		"json:target/cucumberReports/cucumberReportJson.json",
    		"junit:target/cucumberReports/cucumberReportXml.xml",
    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    tags = "@home or @registerInvalidUserSheet",
    monochrome = true
    //"@home and @register or @registerInvalidUserSheet or @registerPageLogin"
    //or @wholeArray @array3 or @arrayPracticeQuestion or @gotoQuestionPage"
)
public class TestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}