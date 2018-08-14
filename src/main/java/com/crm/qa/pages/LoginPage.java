package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="input[@name='username']")
	static
	WebElement uname;
	
	@FindBy(xpath="input[@name='password']")
	WebElement pword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement logo;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public static String title()
	{
		return driver.getTitle();
	}
	public boolean logocheck()
	{
		return logo.isDisplayed();
	}
	public HomePage login(String un, String pwd)
	{
		uname.sendKeys(un);
		pword.sendKeys(pwd);
		login.click();
		return new HomePage();
		
	}

}
