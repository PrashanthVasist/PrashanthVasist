package com.tv.admin.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tv.admin.base.BaseClass;

public class FilterPage extends BaseClass {

	@FindBy(id = "products")
	WebElement productsLink;
	@FindBy(css = "input[id='q_title']")
	WebElement filterTitle;
	@FindBy(css = "input[id='q_sku']")
	WebElement filterSku;
	@FindBy(css = "input[id='q_description']")
	WebElement filterDescription;
	@FindBy(css = "input[value='Filter']")
	WebElement filterSubmit;
	@FindBy(css = "div[id='search-status-_sidebar_section'] h3")
	WebElement searchStatus;
	@FindBy(css = "a[class='clear_filters_btn']")
	WebElement clearFilterBtn;
	@FindBy(css = "div[class='panel_contents'] h4")
	WebElement currentFilter;
	@FindBy(css = "li[class='current_filter current_filter_title_contains'] span")
	WebElement titleContains;
	@FindBy(css = "li[class='current_filter current_filter_title_contains'] b")
	WebElement titleSearch;
	@FindBy(css = "div[id='q_sku_input'] select")
	WebElement skuDropdownFilter;
	@FindBy(css = "li[class='current_filter current_filter_title_contains'] b")
	WebElement skuSearch;
	@FindBy(css = "div[id='q_title_input'] select")
	WebElement titleDropdownFilter;
	@FindBy(css = "td[class='col col-sku']")
	WebElement skuDisplayed;
	@FindBy(css = "div[id='q_description_input'] select")
	WebElement descriptionDropdownFilter;
	@FindBy(css = "div[class='pagination_information']")
	WebElement totalProduct;
	@FindBy(css = "td[class='col col-title']")
	WebElement titleDisplayed;
	@FindBy(css = "td[class='col col-description']")
	WebElement descriptionDisplayed;
	@FindBy(css = "span[class='blank_slate']")
	WebElement productNotFound;

	public FilterPage() {
		PageFactory.initElements(driver, this);
	}

	public void clearFilter(String title, String sku, String description) {
		productsLink.click();
		filterTitle.sendKeys(title);
		filterSku.sendKeys(sku);
		filterDescription.sendKeys(description);
		clearFilterBtn.click();
	}

	public void searchStatus(String title, String sku, String description) {
		productsLink.click();
		filterTitle.sendKeys(title);
		filterSku.sendKeys(sku);
		filterDescription.sendKeys(description);
		filterSubmit.click();
		log.debug("Product Search Status displayed is " + searchStatus.isDisplayed());
		log.debug("Product Current Filter displayed is " + currentFilter.isDisplayed());
	}

	public void containsFilter(String dropdown, String title) {
		productsLink.click();
		titleDropdownFilter.sendKeys(dropdown);
		filterTitle.sendKeys(title);
		filterSubmit.click();
		log.debug("Product Contains Filter displayed is " + titleDisplayed.getText().contains(title));
		log.debug("Total number of Products after Starts With Filter is " + totalProduct.getText());
	}

	public void equalsFilter(String dropdown, String sku) {
		productsLink.click();
		skuDropdownFilter.sendKeys(dropdown);
		filterSku.sendKeys(sku);
		filterSubmit.click();
		log.debug("Product Equals Filter displayed is " + skuDisplayed.getText().contains(sku));
		log.debug("Total number of Products after Starts With Filter is " + totalProduct.getText());
	}

	public void startsWithFilter(String dropdown, String description) {
		productsLink.click();
		descriptionDropdownFilter.sendKeys(dropdown);
		filterDescription.sendKeys(description);
		filterSubmit.click();
		log.debug("Product Starts With Filter Matches with Searched Product is "
				+ descriptionDisplayed.getText().contains(description));
		log.debug("Total number of Products after Starts With Filter is " + totalProduct.getText());
	}

	public void endsWithFilter(String dropdown, String title) {
		productsLink.click();
		titleDropdownFilter.sendKeys(dropdown);
		filterTitle.sendKeys(title);
		filterSubmit.click();
		log.debug("Product Ends With Filter displayed is " + titleDisplayed.getText().contains(title));
		log.debug("Total number of Products after Starts With Filter is " + totalProduct.getText());
	}

	public void productNotFound(String dropdown, String description) {
		productsLink.click();
		descriptionDropdownFilter.sendKeys(dropdown);
		filterDescription.sendKeys(description);
		filterSubmit.click();
		log.debug("products Not Found " + productNotFound.getText());
	}
}
