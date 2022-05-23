package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	public HomePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@class='nav-item dropdown']/a")
	WebElement linkdropdownDS;

	@FindBy(how=How.XPATH,using="//div[@class='dropdown-menu show']/a[contains(text(),'Linked List')]")
	WebElement linkedlist;
	
	@FindBy(how=How.XPATH,using="//div[@class='dropdown-menu show']/a[contains(text(),'Stack')]")
	WebElement stack;
	
	public void clickdropdownlink() {
		linkdropdownDS.click();
	}
	
	public void clickLinkedlist() {
		linkedlist.click();
	}

	public void clickStack() {
		stack.click();
	}
}
