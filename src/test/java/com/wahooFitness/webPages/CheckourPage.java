package com.wahooFitness.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.BaseClass;

public class CheckourPage extends BaseClass{
	
	@FindBy(xpath="//*[@id='checkout']/div[1]/h1")
	WebElement checkoutpage;
	
	@FindBy(xpath = "//*[@id='customer-email-error']")
	WebElement emailerror;
	
	@FindBy(xpath = "//form[2]//input[@name='firstname']/..//div[@class='field-error']/span")
	WebElement firstnameerror;
	
	@FindBy(xpath = "//form[2]//input[@name='lastname']/..//div[@class='field-error']/span")
	WebElement lastnameerror;
	
	@FindBy(xpath = "//form[2]//input[@name='street[0]']/..//div[@class='field-error']/span")
	WebElement streeterror;
	
	@FindBy(xpath = "//form[2]//input[@name='city']/..//div[@class='field-error']/span")
	WebElement cityerror;
	
	@FindBy(xpath = "//form[2]//input[@name='telephone']/..//div[@class='field-error']/span")
	WebElement telephoneerror;
	
	@FindBy(xpath = "(//*[@name='username'])[1]")
	WebElement emailid;
	
	@FindBy(xpath = "//form[2]//input[@name='firstname']")
	WebElement firstname;
	
	@FindBy(xpath = "//form[2]//input[@name='lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//form[2]//input[@name='street[0]']")
	WebElement street;
	
	@FindBy(xpath = "//form[2]//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//form[2]//select[@name='country_id']")
	WebElement country;
	
	@FindBy(xpath = "//form[2]//select[@name='region_id']")
	WebElement region;
	
	@FindBy(xpath = "//form[2]//input[@name='postcode']")
	WebElement postcode;
	
	@FindBy(id = "s_method_amstrates_amstrates22")
	WebElement shipping;
	
	@FindBy(xpath = "//form[2]//input[@name='telephone']")
	WebElement telephone;
	
	@FindBy(xpath = "//*[@id='amasty_stripe_card_data']/div/iframe")
	WebElement frame;
	
	@FindBy(xpath = "//input[@name='cardnumber']")
	WebElement cardnumber;
	
	@FindBy(xpath = "//input[@name='exp-date']")
	WebElement expdate;
	
	@FindBy(xpath = "//input[@name='cvc']")
	WebElement cvc;
	
	@FindBy(xpath = "//*[@id='checkout']/div[3]/div/div")
	WebElement declinemessage;
	
	@FindBy(xpath = "//div[6]/div/div/button[contains(@title,'Place Order')]")
	WebElement placeOrder;
	
	WebDriver driver;
	
	public CheckourPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPlaceOrder(){
		javaScriptClick(placeOrder, driver);
	}
	
	public String getpageTitle() {
		return checkoutpage.getText();
	}
	
	public String getemailErrorMessage(){
		return emailerror.getText();
	}
	
	public String getFirstnameErrorMessage(){
		return firstnameerror.getText();
	}
	
	public String getLastnameErrorMessage(){
		return lastnameerror.getText();
	}
	
	public String getStreetErrorMessage(){
		return streeterror.getText();
	}
	
	public String gettelephoneErrorMessage(){
		return telephoneerror.getText();
	}
	
	public void enteremailid(String value){
		emailid.sendKeys(value);
	}
	
	public void enterfirstname(String value){
		firstname.sendKeys(value);
	}
	
	public void enterlastname(String value){
		lastname.sendKeys(value);
	}
	
	public void enterstreet(String value){
		street.sendKeys(value);
	}
	
	public void selectcountry(String value){
		Select sel = new Select(country);
		sel.selectByVisibleText(value);
	}
	
	public void selectregion(String value){
		Select sel = new Select(region);
		sel.selectByVisibleText(value);
	}
	
	public void enterpostcode(String value){
		postcode.clear();
		postcode.sendKeys(value);
	}
	
	public void clickshipping(){
		shipping.click();
	}
	
	public void entercardnumber(String value){
		driver.switchTo().frame(frame);
		cardnumber.sendKeys(value);
	}
	
	public void enterexpdate(String value){
		expdate.sendKeys(value);
	}
	
	public void entercvc(String value){
		cvc.sendKeys(value);
		driver.switchTo().defaultContent();
	}
	
	public String getdeclinemessage(){
//		javaScriptClick(element, driver);
		return declinemessage.getText();
	}

	public void entercity(String value) {
		city.sendKeys(value);
		
	}

	public void entertelephonenumer(String value) {
		telephone.sendKeys(value);
		
	}
}
