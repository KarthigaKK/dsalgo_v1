package com.dsalgo.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dsalgo.utilities.ReadConfig;

import io.qameta.allure.Step;

public class LoginPage {
	
	WebDriver ldriver;
	ReadConfig config=new ReadConfig();
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy (xpath="//a[contains(text(),'Sign in')]")
	WebElement linkSignin;
	
	@FindBy (name="username")
	WebElement txtLoginUser;
	
	@FindBy (name="password")
	WebElement txtLoginPwd;
	
	@FindBy (xpath="//input[contains(@value,'Login')]")
	WebElement btnSignin;
	
	@FindBy (xpath="//div[@class='alert alert-primary']")
	WebElement loginSuccessMessage;
	
	@FindBy (xpath="//div[@class='alert alert-primary']")
	WebElement RegistrationMessage;
	//Action Methods
	
	public void clickSignin() {
		linkSignin.click();
	}
	
	public void setLoginUser(String loginuser) {
		 txtLoginUser.sendKeys(loginuser);
		
	}
	
	public void setLoginPwd(String loginpwd) {
		 txtLoginPwd.sendKeys(loginpwd);
		
	}
	
	public void clickSigninBtn() {
		btnSignin.click();
	}
	
	public String loginSuccessMessage() {
		return loginSuccessMessage.getText();
	}
	
	
		@Step("verifying sign up link is displayed step....")
		public boolean VerifySignUpLink(){
			return linkSignin.isDisplayed();
		}
		
		public String getLoginPageTitle(){
			WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleContains(config.getLoginPageTitle()));
			return ldriver.getTitle();
		}
	
		public String registerMessage() {
			return RegistrationMessage.getText();
		}
}
