package com.ui.test;

import static com.constants.Browser.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public abstract class TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	protected HomePage homePage;

	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Launches home page of the website")

	public void setUp(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("true") boolean isHeadless, ITestResult result) {

		this.isLambdaTest = isLambdaTest;
		WebDriver lamddaDriver;

		if (isLambdaTest) {

			lamddaDriver = LambdaTestUtility.initializeLamdaTestSession(Browser.valueOf(browser.toUpperCase()),
					result.getMethod().getMethodName());

			homePage = new HomePage(lamddaDriver);
		}

		else {
			logger.info("Loads the home Page of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {

		return homePage;
	}

	@AfterMethod
	public void tearDown() {
		if (isLambdaTest) {

			LambdaTestUtility.quitSession();
		}

		else {
			homePage.quitBrowser();
		}

	}

}
