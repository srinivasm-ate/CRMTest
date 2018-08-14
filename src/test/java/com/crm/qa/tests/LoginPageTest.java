package com.crm.qa.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class LoginPageTest extends TestBase
{
	LoginPage lpage;
	HomePage hpage;
	
	public LoginPageTest() throws IOException
	{
		super();
		lpage=new LoginPage();
	}
	
	@BeforeMethod
	public void setup()
	{
		Intialization();
	}
	
	@Test(priority=0)
	public void logotest()
	{
		boolean b=lpage.logocheck();

		assertTrue(b);
	}
	
	@Test(priority=1)
	public void logintest()
	{
		hpage=lpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void Titletest()
	{
		String title=lpage.title();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
