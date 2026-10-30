package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class ProductPage extends BrowserUtility {

	private static final By PRODUCT_HEADING_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By PRODUCT_NAME_LOCATOR = By.xpath("//h5[@itemprop='name']/a");
	private static final By MORE_BTN_LOCATOR = By.xpath("(//a[contains(@class,'button lnk_view')])");
	private static final By ITEM_LOCATOR = By.xpath("(//a[@title='Printed Dress'])[1]");

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchedProductTitle() {

		return getVisibleText(PRODUCT_HEADING_LOCATOR);
	}

	public boolean getProductNameList(String searchTerm) {

		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));

		List<String> productNameList = getAllVisibleText(PRODUCT_NAME_LOCATOR);

		return productNameList.stream().allMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
	}

	public ProductDetailsPage addProductAt(int index) {

	
		scrollTo(getAll(ITEM_LOCATOR));
		mouseHover(getAll(PRODUCT_NAME_LOCATOR).get(index));
		clickOn(getAll(MORE_BTN_LOCATOR).get(index));
		
		return new ProductDetailsPage(getDriver());
		

	}


}
