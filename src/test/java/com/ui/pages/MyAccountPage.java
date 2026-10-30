package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
    private static final By SEARCH_BOX_LOCATOR = By.id("search_query_top");
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//button[@name='submit_search']");
    private static final By ADD_ADDRESS_LOCATOR = By.xpath("//a[@title='Add my first address']");
    
	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	public String getUserName() {

	return getVisibleText(USER_NAME_LOCATOR);
	}
	
	
	public ProductPage searchProduct (String product) {
		
		enterText(SEARCH_BOX_LOCATOR, product);
		
		clickOn(SEARCH_BUTTON_LOCATOR);
		
		return new ProductPage(getDriver());
		
		
	}
	
	
	public AddressPage goToaddAddress ()
	{
		
		clickOn(ADD_ADDRESS_LOCATOR);
		
		return new AddressPage(getDriver());
	}

}
