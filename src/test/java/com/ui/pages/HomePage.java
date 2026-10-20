package com.ui.pages;

import static com.utility.PropertiesUtil.getProperty;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class HomePage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCTAOR = By.cssSelector(".login");

	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless);

		goToWebsite(getProperty("URL"));
		maximizeWindow();

	}

	public HomePage(WebDriver driver) {
		super(driver);

		goToWebsite(getProperty("URL"));
		maximizeWindow();

	}

	public LoginPage goToLoginPage() {

		logger.info("Trying to click on the login page to sign in");
		clickOn(SIGN_IN_LINK_LOCTAOR);
		return new LoginPage(getDriver());

	}

}
