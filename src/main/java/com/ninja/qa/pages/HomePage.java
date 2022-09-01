package com.ninja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninja.qa.base.TestBase;

public class HomePage extends TestBase {

	//Page Factory --OR
	
	@FindBy(xpath = "//input[@name= 'search']")
	WebElement searchEdit;
	
	@FindBy(xpath = "//button[@type= 'button' and @class = 'btn btn-default btn-lg']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//button[@type= 'button' and @class = 'btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement cartBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Desktops') and @class = 'dropdown-toggle']")
	WebElement menuDesktops;
	
	@FindBy(xpath = "//a[contains(text(),'Components') and @class = 'dropdown-toggle']")
	WebElement manuComponents;
	
	@FindBy(xpath = "//a[contains(text(),'Tablets')]")
	WebElement manuTablets;
	
	@FindBy(xpath = "//a[contains(text(),'Software')]")
	WebElement manuSoftware;
	
	@FindBy(xpath = "//a[text()='Cameras']")
	WebElement menuCameras;
	
	//Initialization Page Objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateTitle()
	{
		return driver.getTitle();
	}
	public boolean validateSearchbox()
	{
		return searchEdit.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		searchEdit.sendKeys(un);
		searchEdit.sendKeys(pwd);
		searchBtn.click();
		
		return new HomePage();
	}
}
