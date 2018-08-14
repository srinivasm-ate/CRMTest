package com.crm.qa.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String browser = prop.getProperty("browser");

	public TestBase() throws IOException {
		FileInputStream fis = new FileInputStream("/CRMTest/src/main/java/com/crm/qa/config/crmconfig.properties");
		prop.load(fis);
	}

	public static void Intialization() {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromdriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

}