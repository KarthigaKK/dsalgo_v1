package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedListPage {
	
	WebDriver ldriver;
	
	public LinkedListPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
				
	}
	
	@FindBy (xpath="//a[@class='list-group-item' and @href='introduction']")
	WebElement linkIntro;
	
	@FindBy (xpath="//a[contains(text(),'Creating Linked LIst')]")
	WebElement linkCreateLinkedList;
	
	@FindBy (xpath="//a[contains(text(),'Types of Linked List')]")
	WebElement linkTypesOfLinkedList;
	

	@FindBy (xpath="//a[contains(text(),'Implement Linked List in Python')]")
	WebElement linkImplementLinkedList;
	
	@FindBy (xpath="//a[contains(text(),'Traversal')]")
	WebElement linkTraversal;
	
	@FindBy (xpath="//a[contains(text(),'Insertion')]")
	WebElement linkInsertion;
	
	@FindBy (xpath="//a[contains(text(),'Deletion')]")
	WebElement linkDeletion;
	
	@FindBy (xpath="//a[contains(text(),'Try here>>>')]")
	WebElement btnTryHere;
	
	@FindBy (xpath="//div[@class='CodeMirror-code']/div/pre/span/span")
	WebElement txtAreaEditor;
	
	@FindBy (xpath="//button[contains(text(),'Run')]")
	WebElement btnrun;
	
	//Action Method
	public void clickLinkIntro()
	{
		linkIntro.click();
	}
	
	public void clickLinkCreate()
	{
		linkCreateLinkedList.click();
	}
	
	public void btnTryHere()
	{
		btnTryHere.click();
	}
	
	public WebElement getTxtAreaEditor()
	{
		 return txtAreaEditor;
	}

	public WebElement getLinkCreate()
	{
		return linkCreateLinkedList;
	}
	
	public void clickTxtAreaEditor()
	{
		txtAreaEditor.click();
		
	}
	public void setTxtAreaEditor(String code)
	{
		 txtAreaEditor.sendKeys(code);
	}
	

	public void btnRun()
	{
		btnrun.click();
	}
	
	public void clickTypesofLink()
	{
		linkTypesOfLinkedList.click();
	}
	
	public void clickImplementLink()
	{
		linkImplementLinkedList.click();
	}
	
	public void clickTraversal()
	{
		linkTraversal.click();
	}
	
	public void clickInsertion()
	{
		linkInsertion.click();
	}
	
	public void clickDeletion()
	{
		linkDeletion.click();
	}
}
