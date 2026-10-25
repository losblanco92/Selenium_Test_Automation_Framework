package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver);
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {

		logger.info("Lanuching browser " + browserName);

		if (browserName == Browser.CHROME) {

			if (isHeadless) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");

				driver.set(new ChromeDriver(options));

			} else {
				driver.set(new ChromeDriver());
			}
		}

		if (browserName == Browser.EDGE) {

			if (isHeadless) {

				EdgeOptions options = new EdgeOptions();
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080");

				driver.set(new EdgeDriver(options));

			} else {
				driver.set(new EdgeDriver());
			}
		}

	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void goToWebsite(String url)

	{
		logger.info("Launching the website " + url);
		driver.get().get(url);

	}

	public void maximizeWindow()

	{
		logger.info("Maximizing the browser window");

		driver.get().manage().window().maximize();

	}

	public void clickOn(By by) {

		logger.info("Performing click");

		driver.get().findElement(by).click();

	}

	public void enterText(By by, String string) {

		logger.info("Entering text in the textbox " + string);

		driver.get().findElement(by).sendKeys(string);

	}

	public String getVisibleText(By by) {

		logger.info("Getting visible test");

		return driver.get().findElement(by).getText();

	}
	
	public void quitBrowser () {
		
		driver.get().quit();
		
	}

	public String takeScreenShot(String fileName) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		String timeStamp = dateFormat.format(date);

		String path = "./screenshots/" + fileName + "_"
				+ timeStamp + ".png";

		File screenShotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}
