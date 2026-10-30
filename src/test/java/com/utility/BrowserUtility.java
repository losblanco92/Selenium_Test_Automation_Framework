package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private Logger logger = LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private WebDriverWait wait;

	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {

		logger.info("Lanuching browser " + browserName);

		if (browserName == Browser.CHROME) {

			if (isHeadless) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");

				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));

			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));

			}
		}

		if (browserName == Browser.EDGE) {

			if (isHeadless) {

				EdgeOptions options = new EdgeOptions();
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080");

				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));

			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));

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

		wait.until(ExpectedConditions.elementToBeClickable(by)).click();

	}

	public void clickOnCheckBox(By locator) {

		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

		logger.info("Checkbox selected successfully");
	}

	public void enterText(By by, String string) {

		logger.info("Entering text in the textbox " + string);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		element.sendKeys(string);

	}

	public String getVisibleText(By by) {

		logger.info("Getting visible test");

		return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();

	}

	public void clearText(By by) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
	}

	public String getVisibleText(WebElement element) {

		logger.info("Getting visible test");
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();

	}

	public List<String> getAllVisibleText(By by) {

		logger.info("Getting all visible test");

		List<WebElement> elementList = driver.get().findElements(by);
		List<String> productNameList = new ArrayList<String>();

		for (WebElement element : elementList) {
			productNameList.add(getVisibleText(element));

		}

		return productNameList;

	}

	public List<WebElement> getAll(By by) {

		logger.info("Getting the List");

		List<WebElement> elementList = driver.get().findElements(by);

		return elementList;

	}

	public void clickOn(WebElement webElement) {

		wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
	}

	public void mouseHover(WebElement webElement) {

		Actions actions = new Actions(getDriver());

		actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(webElement))).perform();

	}

	public void selectValueFromDropDown(By dropdownLocator, By optionLocator) {

		logger.info("Clicking the visible dropdown");
		driver.get().findElement(dropdownLocator).click();

		logger.info("Selecting the requested option");
		driver.get().findElement(optionLocator).click();
	}

	public void selectValueFromDropDown(By by, String text) {

		WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		Select select = new Select(webElement);
		select.selectByContainsVisibleText(text);

	}

	public void scrollTo(List<WebElement> list) {

		JavascriptExecutor js = (JavascriptExecutor) driver.get();

		for (WebElement element : list) {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}

	public void quitBrowser() {

		logger.info("Closing the browser");

		driver.get().quit();

	}

	public String takeScreenShot(String fileName) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		String timeStamp = dateFormat.format(date);

		String path = "./screenshots/" + fileName + "_" + timeStamp + ".png";

		File screenShotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}
