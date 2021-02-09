package com.wahooFitness.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class PopupPage extends BaseClass {
	
	@FindBy(xpath = "/html/body/div[9]/aside[2]/div[2]/div/div")
	WebElement popup;
	
	@FindBy(xpath = "//button/span[text()='OK']")
	WebElement ok;
	
	
	public PopupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPopupText() throws Exception{
		Thread.sleep(2000);
		return popup.getText();
	}
	
	public void acceptpopup(){
		ok.click();
	}
}
