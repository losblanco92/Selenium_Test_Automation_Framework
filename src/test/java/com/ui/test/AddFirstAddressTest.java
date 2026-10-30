package com.ui.test;

import static com.utility.FakerUtility.getFakeAddress;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pojo.AddressRecord;

@Listeners(com.ui.listeners.TestListener.class)
public class AddFirstAddressTest extends TestBase {

	private AddressPage addressPage;
	private AddressRecord address;

	@BeforeMethod(description = "Logging in with valid first time user credentails")
	public void loginWithValidCredentails() {
		
		
		addressPage = homePage.goToLoginPage().doLoginWith("pikace9130@fun4k.com", "Test@1234").goToaddAddress();
	     
		address= getFakeAddress();
	
	}

	@Test
	public void addFirstAddress() {

		String actualAddress= addressPage.saveAddress(getFakeAddress());
		
		Assert.assertEquals(actualAddress, address.addressAlias().toUpperCase());
	}

}
