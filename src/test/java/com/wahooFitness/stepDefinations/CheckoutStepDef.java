package com.wahooFitness.stepDefinations;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wahooFitness.webPages.CheckourPage;
import com.wahooFitness.webPages.HomePage;
import com.wahooFitness.webPages.PopupPage;
import com.wahooFitness.webPages.ProductsPage;
import com.wahooFitness.webPages.YourCartPage;

import Utilities.BaseClass;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CheckoutStepDef extends BaseClass{
	
	WebDriver driver;
	WebDriverWait wait;
	ProductsPage product;
	PopupPage popup;
	YourCartPage cart;
	CheckourPage checkout;
	
	@Given("^I want to launch wahoofitness webapp$")
	public void i_want_to_launch_wahoofitness_webapp() throws Throwable {
		driver = BaseClass.openBrowser();
	}

	@Given("^I select two product and add to the cart$")
	public void i_select_two_product_and_add_to_the_cart() throws Throwable {
		
		HomePage home = new HomePage(driver);
		home.clickshop();
		
		product = new ProductsPage(driver);
		product.addproducts(2);
	}

	@When("^I remove a product from the cart$")
	public void i_remove_a_product_from_the_cart() throws Throwable {
		product.removeproducts();
	}

	@Then("^I see a popup with message is displayed$")
	public void i_see_a_popup_with_message_is_displayed() throws Throwable {
		popup = new PopupPage(driver);
		String text =popup.getPopupText();
		Assert.assertEquals("Check Message on Popup", "Are you sure you would like to remove this item from the shopping cart?", text);
	}

	@Then("^I accept the popup$")
	public void i_accept_the_popup() throws Throwable {
		popup.acceptpopup();
	}

	@When("^I click on edit cart link$")
	public void i_click_on_edit_cart_link() throws Throwable {
		product.clickviewandeditcart();
	}

	@Then("^I cart page is displayed$")
	public void i_cart_page_is_displayed() throws Throwable {
		cart = new YourCartPage(driver);
		String text = cart.getpagename();
		Assert.assertEquals("Page Title", "YOUR CART", text);
	}

	@Then("^I update quantity of the item in the cart$")
	public void i_update_quantity_of_the_item_in_the_cart() throws Throwable {
		cart.enterQuantity("10");
	}

	@Then("^I click on update cart$")
	public void i_click_on_update_cart() throws Throwable {
		cart.clickonupdatecart();
	}

	@Then("^I see the prices reflect the change$")
	public void i_see_the_prices_reflect_the_change() throws Throwable {
		Assert.assertEquals(cart.getsubtotalprice(), cart.getUnitprice()*10);
	}
	
	@When("^I click on checkout button$")
	public void i_click_on_checkout_button() throws Throwable {
		cart.clickproceedtocheckout();
	}

	@Then("^I see checkout details page$")
	public void i_see_checkout_details_page() throws Throwable {
		checkout = new CheckourPage(driver);
		String text = checkout.getpageTitle();
		Assert.assertEquals("Page Title", "Checkout", text);
	}

	@When("^I click on place order button$")
	public void i_click_on_place_order_button() throws Throwable {
		checkout.clickPlaceOrder();
	}

	@Then("^I Error messages appear$")
	public void i_Error_messages_appear() throws Throwable {
		String errormessage = checkout.getemailErrorMessage();
		Assert.assertEquals("This is a required field.", errormessage);
		String errormessagefirstname = checkout.getFirstnameErrorMessage();
		Assert.assertEquals("This is a required field.", errormessagefirstname);
		String errormessagelastname = checkout.getLastnameErrorMessage();
		Assert.assertEquals("This is a required field.", errormessagelastname);
		String errormessagestreet = checkout.getStreetErrorMessage();
		Assert.assertEquals("This is a required field.", errormessagestreet);
		String errormessagecity = checkout.getStreetErrorMessage();
		Assert.assertEquals("This is a required field.", errormessagecity);
		String errormessagetelephone = checkout.gettelephoneErrorMessage();
		Assert.assertEquals("This is a required field.", errormessagetelephone);
	}
	
	@When("^I enter email name address phone$")
	public void i_enter_email_name_address_phone(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		
		checkout.enteremailid(data.get(0).get(0));
		checkout.enterfirstname(data.get(0).get(1));
		checkout.enterlastname(data.get(0).get(2));
		checkout.enterstreet(data.get(0).get(3));
		checkout.entercity(data.get(0).get(4));
		checkout.selectcountry(data.get(0).get(5));
		checkout.selectregion(data.get(0).get(6));		
		checkout.enterpostcode(data.get(0).get(7));
		checkout.entertelephonenumer(data.get(0).get(8));
	}

	@When("^I change shipping method to express shipping$")
	public void i_change_shipping_method_to_express_shipping(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();		
		checkout.clickshipping();
		handlewebAppearance(1000);
		
		checkout.entercardnumber(data.get(0).get(0));
		checkout.enterexpdate(data.get(0).get(1));
		checkout.entercvc(data.get(0).get(2));

		handlewebAppearance(1000);
	}

	@Then("^I see the payment id declined with error message$")
	public void i_see_the_payment_id_declined_with_error_message() throws Throwable {
		handlewebAppearance(1000);
		String text = checkout.getdeclinemessage();
		Assert.assertEquals("Check Decline Message", "Your card was declined. Your request was in live mode, but used a known test card.", text);
		driver.quit();
	}

}
