package com.tv.admin.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tv.admin.base.BaseClass;

public class NewProductPage extends BaseClass {

	@FindBy(id = "products")
	WebElement productsLink;
	@FindBy(css = "div[class='action_items'] a")
	WebElement newProductLink;
	@FindBy(id = "product_title")
	WebElement titleField;
	@FindBy(id = "product_sku")
	WebElement skuField;
	@FindBy(id = "product_description")
	WebElement descriptionField;
	@FindBy(name = "commit")
	WebElement createProduct;
	@FindBy(css = "input[type='submit']")
	WebElement updateProduct;
	@FindBy(css = "div[class='flash flash_notice']")
	WebElement flashMessage;
	@FindBy(css = "li[id='product_title_input'] [class='inline-errors']")
	WebElement titleMandatoryError;
	@FindBy(css = "li[id='product_sku_input'] [class='inline-errors']")
	WebElement skuMandatoryError;
	@FindBy(css = "li[id='product_description_input'] [class='inline-errors']")
	WebElement descriptionMandatoryError;

	public int maxLengthDefinedTitle = 40;
	public int maxLengthDefinedSku = 10;

	public NewProductPage() {
		PageFactory.initElements(driver, this);
	}

	public void mandatoryFieldsValidation() {
		productsLink.click();
		newProductLink.click();
		createProduct.click();
		log.debug("Product Title Mandatory Error message is displayed as " + titleMandatoryError.isDisplayed());
		log.debug("Product Sku Mandatory Error message is displayed as " + skuMandatoryError.isDisplayed());
		log.debug("Product Description Mandatory Error message is displayed as "
				+ descriptionMandatoryError.isDisplayed());
	}

	public void attributesValidation(String title, String sku, String description) {
		productsLink.click();
		newProductLink.click();
		titleField.sendKeys(title);
		String typedValueTitle = titleField.getAttribute("value");

		int size = typedValueTitle.length();

		if (size <= maxLengthDefinedTitle) {
			log.info("Max character functionality is working fine.");
		}

		else {
			log.info("No limit is set.");
		}
		skuField.sendKeys(sku);
		String typedValueSku = skuField.getAttribute("value");
		int sizeSku = typedValueSku.length();
		if (sizeSku <= maxLengthDefinedSku) {
			log.info("Max character functionality is working fine.");
		} else {
			log.info("No limit is set.");
		}
		descriptionField.sendKeys(description);
		createProduct.click();
	}

	public void uniqueProductValidation(String title, String sku, String description) {
		productsLink.click();
		newProductLink.click();
		titleField.sendKeys(title);
		skuField.sendKeys(sku);
		descriptionField.sendKeys(description);
		createProduct.click();
		log.debug("Product Title Mandatory Error message is displayed as " + titleMandatoryError.isDisplayed());
		log.debug("Product Sku Mandatory Error message is displayed as " + skuMandatoryError.isDisplayed());
	}
}
