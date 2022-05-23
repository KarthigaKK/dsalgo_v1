package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TryEditorPage {
	
	WebDriver ldriver;
	public  TryEditorPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy (xpath="//form[@id='answer_form']/div/div/div/textarea")
	@CacheLookup
	WebElement editorTextBox;
	
	@FindBy (xpath="//button[@type='button']")
	@CacheLookup
	WebElement runBtn;
	
	@FindBy (xpath="//pre[@id='output']")
	@CacheLookup
	WebElement output;
	
	//action methods
	public void setTextBoxValue(String code) {
	   editorTextBox.sendKeys(code); 		
	}
	
	public void runBtn() {
		runBtn.click();
	}
	
	public String getOutput() {
		return output.getText();
	}
	

}
