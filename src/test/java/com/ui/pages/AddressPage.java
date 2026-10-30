package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressRecord;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY_NAME_INPUT_BOX_LOCATOR = By.id("company");
	private static final By ADDRESS_INPUT_BOX_LOCATOR = By.id("address1");
	private static final By CITY_INPUT_BOX_LOCATOR = By.id("city");
	private static final By ZIPCODE_INPUT_BOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_INPUT_BOX_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_INPUT_BOX_LOCATOR = By.id("phone_mobile");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By ADDRESS_ALIAS_LOCATOR = By.id("alias");
	private static final By ADDRESS_HEADING_LOCATOR= By.tagName("h3");

	public AddressPage(WebDriver driver) {
		super(driver);

	}

	public String saveAddress(AddressRecord addressRecord) {
		enterText(CITY_INPUT_BOX_LOCATOR, addressRecord.city());
		enterText(ZIPCODE_INPUT_BOX_LOCATOR, addressRecord.zipCode());
		enterText(HOME_PHONE_INPUT_BOX_LOCATOR, addressRecord.phoneNumber());
		enterText(MOBILE_PHONE_INPUT_BOX_LOCATOR, addressRecord.mobileNumber());
		enterText(COMPANY_NAME_INPUT_BOX_LOCATOR, addressRecord.company());

		enterText(ADDRESS_INPUT_BOX_LOCATOR, addressRecord.address());

		clearText(ADDRESS_ALIAS_LOCATOR);
		enterText(ADDRESS_ALIAS_LOCATOR, addressRecord.addressAlias());
         
		By stateOptionLocator = By.xpath(String.format("//option[text()='%s']", addressRecord.state()));
		selectValueFromDropDown(STATE_DROPDOWN_LOCATOR, stateOptionLocator);

		clickOn(SUBMIT_BUTTON_LOCATOR);
		
	  return getVisibleText(ADDRESS_HEADING_LOCATOR);

	}

}
