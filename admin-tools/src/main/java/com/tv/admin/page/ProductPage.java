package com.tv.admin.page;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.tv.admin.base.BaseClass;

public class ProductPage extends BaseClass {

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
	@FindBy(css = "input[id='q_title']")
	WebElement filterTitle;
	@FindBy(css = "input[id='q_sku']")
	WebElement filterSku;
	@FindBy(css = "input[id='q_description']")
	WebElement filterDescription;
	@FindBy(css = "input[value='Filter']")
	WebElement filterSubmit;
	@FindBy(css = "a[class='edit_link member_link']")
	WebElement editLink;
	@FindBy(css = "a[class='delete_link member_link']")
	WebElement deleteLink;
	@FindBy(css = "div[class='flash flash_notice']")
	WebElement flashMessage;
	@FindBy(css = "input[id='collection_selection_toggle_all']")
	WebElement checkAllBox;
	@FindBy(css = "a[class='dropdown_menu_button']")
	WebElement batchActionButton;
	@FindBy(css = "a[class='batch_action']")
	WebElement deletDropDown;
	@FindBy(xpath = "//div[@class='ui-dialog-buttonset']/button[1]")
	WebElement okButton;
	@FindBy(css = "span[class='ui-dialog-title']")
	WebElement confirmText;
	@FindBys(@FindBy(xpath = "//table[@id='index_table_products']/tbody/tr/td[3]"))
	List<WebElement> titleTableList;
	@FindBy(css = "th[class='sortable col col-title'] a")
	WebElement sortClick;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public void productsLinks() {
		productsLink.click();
	}

	public void productCreation(String title, String sku, String description) {
		newProductLink.click();
		titleField.sendKeys(title);
		skuField.sendKeys(sku);
		descriptionField.sendKeys(description);
		createProduct.click();
		log.debug("Admin " + flashMessage.getText());
	}

	public void searchFilter(String title, String sku, String description) {
		filterTitle.sendKeys(title);
		filterSku.sendKeys(sku);
		filterDescription.sendKeys(description);
		filterSubmit.click();
	}

	public void updateProduct(String sku, String description) {
		editLink.click();
		skuField.sendKeys(sku);
		descriptionField.sendKeys(description);
		updateProduct.click();
	}

	public void deleteProduct(String items) {
		for (int i = 0; i < titleTableList.size(); i++) {
			String name = titleTableList.get(i).getText();
			if (name.contains(items)) {
				deleteLink.click();
				log.debug("Product Deletion Confirmation Error message is " + driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				log.debug("Admin " + flashMessage.getText());
			}
		}
	}

	public void deleteAllProduct() {
		checkAllBox.click();
		batchActionButton.click();
		deletDropDown.click();
		log.debug("Product Deletion Confirmation Error message is" + confirmText.getText());
		okButton.click();
		log.debug("Admin " + flashMessage.getText());
	}

	public void tableSort() {
		String[] beforeSortName = new String[titleTableList.size()];
		for (int i = 0; i < titleTableList.size(); i++) {
			beforeSortName[i] = titleTableList.get(i).getText().trim();
		}
		List<String> beforeSortedList = Arrays.asList(beforeSortName);
		log.info("Before Sort Names");
		log.debug("List of Product Before Sort is" + beforeSortedList);
		sortClick.click();
		String[] afterSortName = new String[titleTableList.size()];
		for (int i = 0; i < titleTableList.size(); i++) {
			afterSortName[i] = titleTableList.get(i).getText().trim();
		}
		List<String> afterSortedList = Arrays.asList(afterSortName);
		log.info("After Sort Names");
		log.debug("List of Product After Sort is " + afterSortedList);
		log.debug("List of Product Before Sort and After Sort is " + beforeSortedList.containsAll(afterSortedList));
		log.info("Sort Verified Successfully");
	}
}
