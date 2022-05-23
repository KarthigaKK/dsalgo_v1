package com.dsalgo.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.utilities.WaitHelper;

public class StackPage {

	public WebDriver ldriver;
	

	public StackPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	

	@FindBys(@FindBy( xpath="//div[@id='content']//li")) List<WebElement>  listLinks; 
	
	@FindBy (xpath="//a[contains(text(),'Operations in Stack')]")
	@CacheLookup
	WebElement linkOperations;
	
	@FindBy (xpath="//a[contains(text(),'Implementation')]")
	@CacheLookup
	WebElement linkImplementation;
	
	@FindBy (xpath="//a[contains(text(),'Applications')]")
	@CacheLookup
	WebElement linkApplications;
	
	@FindBy (xpath="//a[contains(text(),'Try here>>>')]")
	WebElement btnTryHere;
	
	@FindBy (xpath="//div[@class='CodeMirror-code']/div/pre/span/span")
	WebElement txtAreaEditor;
	
	@FindBy (xpath="//button[contains(text(),'Run')]")
	WebElement btnrun;
	
	//Action Methods
	
	public List<WebElement> getListLinks()
	{
		return listLinks;
		
			
	}
	
	public void clicklinkOperations()
	{
		linkOperations.click();
	}
	
	public void clicklinkImplementation()
	{
		linkImplementation.click();
	}
	
	public void clicklinkApplications()
	{
		linkApplications.click();
	}
	
	public void btnRun()
	{
		btnrun.click();
	}
	
	public void setTxtAreaEditor(String code)
	{
		 txtAreaEditor.sendKeys(code);
	}
	
	public void clickTxtAreaEditor()
	{
		txtAreaEditor.click();
		
	}
	
	public void btnTryHere()
	{
		btnTryHere.click();
	}
}
