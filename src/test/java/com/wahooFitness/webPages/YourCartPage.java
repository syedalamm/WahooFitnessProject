package com.wahooFitness.webPages;
     

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;



	public class YourCartPage extends BaseClass {
	
		@FindBy(xpath="//*[@id='maincontent']/div[3]/div/div[2]/h1")
		WebElement pagename;
		
		@FindBy(xpath="//input[@title='Quantity']")
		WebElement quantity;
		
		@FindBy(xpath="//button[@name='update_cart_action']/span")
		WebElement updatecart;
		
		@FindBy(xpath="//td[@class='col price']//span[@class='price']")
		WebElement colprice;
		
		@FindBy(xpath="//td[@class='col subtotal']//span[@class='price']")
		WebElement colsubprice;
		
		@FindBy(xpath = "//button[@title='Proceed to Checkout']/span")
		WebElement proceedtocheckout;
		
		public YourCartPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		 public String getpagename()  {
			return pagename.getText();
		}
		 
		 public void enterQuantity(String value) throws Exception  {
			 Thread.sleep(2000);
			 quantity.clear();
			 quantity.sendKeys(value);
		}
		 
		 public void clickonupdatecart() {
			 updatecart.click();
		 }		 
		
		 public double getUnitprice(){
			 return Double.parseDouble(colprice.getText().replace("€", ""));
		 }
		 
		 public double getsubtotalprice(){
			 return Double.parseDouble(colsubprice.getText().replace("€", ""));
		 }
		 
		 public void clickproceedtocheckout(){
			 proceedtocheckout.click();			 
		 }
	}


