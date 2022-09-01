package com.ninja.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() 
	{
		prop =new Properties();
		try {
			FileInputStream fp = new FileInputStream("D:\\WorkPlace\\SeleniumProject\\src\\main\\java\\com\\ninja\\qa\\config\\config.properties");
		prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization()
	{
		String broserName = prop.getProperty("browser");
		if(broserName.contains("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium setup\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if(broserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium setup\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
	}
}
