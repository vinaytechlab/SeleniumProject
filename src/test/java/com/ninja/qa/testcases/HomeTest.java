package com.ninja.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.qa.base.TestBase;
import com.ninja.qa.pages.HomePage;

public class HomeTest extends TestBase {

	HomePage homePage;

	public HomeTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		String title = homePage.validateTitle();
		Assert.assertEquals(title, "Your Store","Home Page Title Not Matched");
	}

	@Test (priority = 2)
	public void searchboxtest() {
		boolean isDisplay = homePage.validateSearchbox();
		Assert.assertTrue(isDisplay);
	}
//	@Test (priority = 3)
//	public void loginTest() {
//		homePage = homePage.login(prop.getProperty("username"),prop.getProperty("password"));
//	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
