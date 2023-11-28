package com.dsalgo.utilities;

import org.openqa.selenium.WebElement;

public class Events {
	public static void click(WebElement element, String elementName) {
		if(element == null) {
			System.out.println(elementName + " Element not found");
		}else {
			element.click();
		}
	}
	
	public static void sendKeys(WebElement element, String elementName, CharSequence keysToSend) {
		if(element == null) {
			System.out.println(elementName + " Element not found");
		}else {
			element.sendKeys(keysToSend);
		}
	}
}
