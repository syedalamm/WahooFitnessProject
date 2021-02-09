package com.wahooFitness.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//a/span[text()='SHOP']")
	WebElement shop;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickshop() throws Exception {
		Thread.sleep(2000);
		shop.click();
	}

}
