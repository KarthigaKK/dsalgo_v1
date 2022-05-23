package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetStartedPage {
	
	WebDriver ldriver;
	public GetStartedPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy (xpath="//button[@class='btn']")
	WebElement btnGetStarted;
	
	public void clickGetStarted() {
		btnGetStarted.click();
	}

}
