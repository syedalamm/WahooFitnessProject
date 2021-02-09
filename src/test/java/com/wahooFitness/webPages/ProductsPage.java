package com.wahooFitness.webPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class ProductsPage extends BaseClass{

	@FindBy(xpath="//li[@class='item']/div[2]/div[@class='actions']//button/span[text()='Add to Cart']")
	List<WebElement> addproducts;
	
	@FindBy(xpath="//div[@class='product actions']/div/a/span[text()='Remove']")
	List<WebElement> removeproducts;
	
	@FindBy(xpath = "//a/span[text()='View and Edit Cart']")
	WebElement viewandeditcart;
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addproducts(int value) throws Exception {
		for(int i=0; i<value; i++){
			addproducts.get(i).click();
			Thread.sleep(2000);	
			if(i == value-1){
				break;
			}else{
				driver.findElement(By.id("btn-minicart-close")).click();
			}
		}
	}
	
	public void removeproducts() throws Exception{
		Thread.sleep(2000);
		removeproducts.get(0).click();
	}
	
	public void clickviewandeditcart(){
		viewandeditcart.click();
	}
	
	

}

	

