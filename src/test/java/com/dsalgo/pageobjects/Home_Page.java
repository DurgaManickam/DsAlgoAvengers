package com.dsalgo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.utilities.Events;


public class Home_Page {

	@FindBy(linkText = "NumpyNinja")
	WebElement numpyNinja;
	@FindBy(css = "a.nav-link.dropdown-toggle")
	WebElement dataStructuresDropDown;
	@FindBy(xpath = "//a[@href='/register']")
	WebElement register;
	@FindBy(xpath = "//a[@href='/login']")
	WebElement signin;
	@FindBy(xpath = "//a[@href='/data-structures-introduction']")
	WebElement dsIntroduction;
	@FindBy(xpath = "//a[@href='/array']")
	WebElement array;
	@FindBy(xpath = "//a[@href='/linked-list']")
	WebElement linked_list;
	@FindBy(xpath = "//a[@href='/stack']")
	WebElement stack;
	@FindBy(xpath = "//a[@href='/queue']")
	WebElement queue;
	@FindBy(xpath = "//a[@href='/tree']")
	WebElement tree;
	@FindBy(xpath = "//a[@href='/graph']")
	WebElement graph;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement errorMessage;
	@FindBy(xpath = "//a[@class='dropdown-item']")
	List<WebElement> dropDownOptions;
	@FindBy(xpath = "//div[@class='card h-100']")
	List<WebElement> panes;

	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void click_numpyNinja() {
		Events.click(numpyNinja, "NumpyNinja");
	}
	public void click_dropDown() {
		Events.click(dataStructuresDropDown, "Data Structures");
	}
	
	public void click_register() {
		Events.click(register, "Register");
	}
	
	public void click_signin() {
		Events.click(signin, "Sign in");
	}
	
	public int getTotalDropdownOptions() {
		return dropDownOptions.size();
	}
	public int getTotalPanes() {
		return panes.size();
	}
	public String getMessage() {
		return errorMessage.getText();
	}
	public void getDropDownSelectedOption(String selectedOption) {
		System.out.println(selectedOption);
		switch (selectedOption) {
		case "Arrays":
			Events.click(array, selectedOption);
			break;
		case "Linked List":
			Events.click(linked_list, selectedOption);
			break;
		case "Stack":
			Events.click(stack, selectedOption);
			break;
		case "Queue":
			Events.click(queue, selectedOption);
			break;
		case "Tree":
			Events.click(tree, selectedOption);
			break;
		case "Graph":
			Events.click(graph, selectedOption);
			break;
		default:
			break;
		}
	}
	
	public void getPaneSelectedOption(WebDriver driver,String selectedOption, String buttonText) {
		WebElement getStarted = driver.findElement(By.xpath("//*[@class = 'card-title' and text() ='"+selectedOption+"']/following-sibling::a[text()='"+buttonText+"']"));
		Events.click(getStarted, selectedOption);
	}
	
	public void getRegisterOrSignIn(String string) {
		switch (string) {
		case "Register":
			Events.click(register, string);
			break;
		case "Sign in":
			Events.click(signin, string);
		default:
			break;
		}
	}
}
