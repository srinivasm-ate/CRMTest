package com.crm.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	String browsername;

	public TestBase() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("/CRMTest/src/main/java/com/crm/qa/config/crmconfig.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void intilization() {
		browsername=prop.getProperty("chrome");
		if (browsername.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("WebDriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
}