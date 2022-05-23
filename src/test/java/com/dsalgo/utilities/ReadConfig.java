package com.dsalgo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
		File src=new File(".//Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Error Message"+e.getMessage());
		}
		
	}
	
	//Read data from config file
	
	public String getApplicationURL() {
		return prop.getProperty("baseurl");
	}
	
	public String getUserName() {
		return prop.getProperty("username");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getRegisterPageTitle()
	{
		return prop.getProperty("registerpagetitle");
	}
	
	public String getLoginPageTitle() {
		return prop.getProperty("loginpagetitle");
	}
	
	public String getLinkedListPageTitle() {
		return prop.getProperty("linkedlistpagetitle");
	}
	
	public String getLoginSuccessMessage() {
		return prop.getProperty("loginsuccessmessage");
	}

	public String getLoginFailedMessage() {
		return prop.getProperty("logininfailed");
	}
	public String getInvalidUsername() {
		return prop.getProperty("invalidusername");
	}
	
	public String getinvalidpassword() {
		return prop.getProperty("invalidpassword");
	}
	
	public String getlogininfailed() {
		return prop.getProperty("logininfailed");
	}
	
	public String getregistrationsuccess() {
		return prop.getProperty("registrationsuccess");
	}
	
	public String getregistrationfailed() {
		return prop.getProperty("registrationfailed");
	}
	
	public String geteditorpage() {
		return prop.getProperty("editorpage");
	}
}
