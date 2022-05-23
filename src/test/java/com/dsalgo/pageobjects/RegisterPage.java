package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPage {
	
	WebDriver ldriver;
	public RegisterPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy (xpath="//a[contains(text(),' Register ')]")
	@CacheLookup
	WebElement linkRegister;
	
	@FindBy (name="username")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy (name="password1")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy (name="password2")
	@CacheLookup
	WebElement txtConfirmPassword;
	
	@FindBy (xpath="//input[@value='Register']")
	@CacheLookup
	WebElement btnRegister;
	
	@FindBy (xpath="//div[@class='alert alert-primary']")
	WebElement RegistrationMessage;
	
	@FindBy (xpath="//a[contains(text(),'Sign out')]")
	WebElement linkSignOut;
	//Action Methods
	
	public void clickRegisterLink() {
		linkRegister.click();
	}
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cpwd) {
		txtConfirmPassword.sendKeys(cpwd);
	}
	
	public void clickRegisterBtn() {
		btnRegister.click();
	}
	
	public void clickSignOutBtn() {
		linkSignOut.click();
	}

	public String registerMessage() {
		return RegistrationMessage.getText();
	}
}
