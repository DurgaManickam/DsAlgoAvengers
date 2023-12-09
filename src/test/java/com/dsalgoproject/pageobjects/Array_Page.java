package com.dsalgoproject.pageobjects;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dsalgoproject.utilities.LoggerLoad;

public class Array_Page {
	@FindBy(xpath = "//a[@href='arrays-in-python']")
	WebElement array_in_python;
	@FindBy(xpath = "//a[@href='arrays-using-list']")
	WebElement array_using_list;
	@FindBy(xpath = "//a[@href='basic-operations-in-lists']")
	WebElement basic_operations_in_lists;
	@FindBy(xpath = "//a[@href='applications-of-array']")
	WebElement applications_of_array;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement tryhere;
	@FindBy(xpath = "//a[@href='/array/practice']")
	WebElement practice_questions;
	@FindBy(xpath = "//a[@href='/question/1']")
	WebElement question1;
	@FindBy(xpath = "//a[@href='/question/2']")
	WebElement question2;
	@FindBy(xpath = "//a[@href='/question/3']")
	WebElement question3;
	@FindBy(xpath = "//a[@href='/question/4']")
	WebElement question4;
	// @FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div/textarea")
	@FindBy(xpath = "//*[@id='answer_form']")
	WebElement questionInput;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement runButton;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitButton;
	@FindBy(id = "output")
	WebElement output;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div/textarea")
	WebElement code_editor;
	
	private String runResult;
	private String submitResult;

	public Array_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void click_array_options(String array_options, WebDriver driver) {
		switch (array_options) {
		case "Arrays in Python":
			array_in_python.click();
			break;
		case "Arrays using List":
			array_using_list.click();
			break;
		case "Basic Operations in List":
			basic_operations_in_lists.click();
			break;
		case "Applications of Array":
			applications_of_array.click();
			break;
		case "Practice Questions":
			practice_questions.click();
			break;
		default:
			break;
		}
	}

	public void click_tryHere() {
		tryhere.click();
	}

	public void click_question(String question) {
		switch (question) {
		case "Search the array":
			question1.click();
			break;
		case "Max Consecutive Ones":
			question2.click();
			break;
		case "Find Numbers with Even Number of Digits":
			question3.click();
			break;
		case "Squares of a  Sorted Array":
			question4.click();
			break;
		default:
			break;
		}
	}

	public void inputQuestion(String question, WebDriver driver) {
		// NEED TO CHECK
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement test = wait.until(ExpectedConditions.visibilityOf(questionInput));
		new Actions(driver).sendKeys(test, question).perform();
	}
	
	public void clickRun() {
		runButton.click();
	}

	public void clickRunInPractice() {
		try {
			runButton.click();
			runResult = output.getText();
			LoggerLoad.info("RUNN RESULT: "+runResult);
		} catch (Exception e) {
			LoggerLoad.info("Submit array page " + e.getLocalizedMessage());
		}
	}

	public void clickSubmitInPractice() {
		try {
			submitButton.click();
			LoggerLoad.info("CLICKED SUBMIT: "+submitResult);
			submitResult = output.getText();
			LoggerLoad.info("SUBMIT RESULT: "+submitResult);
		} catch (Exception e) {
			LoggerLoad.info("Submit array page " + e.getLocalizedMessage());
		}
	}

	public String get_run_output() {
		try {
			LoggerLoad.info("RUNN RESULT: "+runResult);
			return runResult;
		} catch (Exception e) {
			LoggerLoad.info("Submit array page " + e.getLocalizedMessage());
		}
		return null;
	}
	public String get_submit_output() {
		try {
			return submitResult;
		} catch (Exception e) {
			LoggerLoad.info("Submit array page " + e.getLocalizedMessage());
		}
		return null;
	}
	

	public String get_output() {
		return output.getText();
	}

	public String invalidate_run(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		alert.accept();
		driver.switchTo().defaultContent();
		return alert_text;
	}

	public void practice_ques_inp(String answer, WebDriver driver) throws InterruptedException {

		// Wait for the presence of the element
		By textareaLocator = By.xpath("//*[@id='answer_form']/div/div/div/textarea");
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement test2 = mywait.until(ExpectedConditions.presenceOfElementLocated(textareaLocator));

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement test2 = wait.until(ExpectedConditions.visibilityOf(code_editor));

		// Click on the code editor
//		test2.click();
		// test2.sendKeys("HElloo");
//		test2.clear();

		// Use Actions class to clear the contents and send new keys
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		System.out.println(answer);

		// new Actions(driver).sendKeys(test2, answer).perform();

		// use code_editor div
		// String escapedAnswer = answer.replace("'", "\\'").replace("\n", "\\n");
//
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("arguments[0].innerHTML='" + escapedAnswer + "';", test2);
		// // Taking as single line

		// split the python code into separate lines and send the codes line by line
		String[] str1 = answer.split("\n");
		int totalSpaces = 0;
		for (int i = 0; i < str1.length; i++) {
			// Remove all the white spaces and reset the cursor back to the beginning of the
			// current line
			for (int s = 0; s < totalSpaces; s++) {
				new Actions(driver).sendKeys(test2, Keys.BACK_SPACE).perform();
			}

			// Find out how many white spaces the current line has at the beginning
			totalSpaces = 0;
			for (int j = 0; j < str1[i].length(); j++) {
				// Check if the character is a whitespace character
				if (Character.isWhitespace(str1[i].charAt(j))) {
					totalSpaces += 1;
				} else {
					break;
				}
			}

			// send the current line to the editor text area
			new Actions(driver).sendKeys(test2, str1[i]).perform();

			// After each line, send "Enter" key to start new line for next line
			new Actions(driver).sendKeys(test2, Keys.ENTER).perform();
			// The python editor adds two spaces if the previous line has :
			if (str1[i].indexOf(':') > -1) {
				totalSpaces += 2;
			}
			// The python editor removes two spaces if the previous line has return
			// statement
			if (str1[i].contains("return ")) {
				totalSpaces -= 2;
			}
		}
	}

	


}
