package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SelectDropdown;

public class ProductPageObjects {

	@FindBy(className = "title")
	WebElement txt_productPageTitle;
	@FindBy(className = "product_sort_container")
	WebElement dropDown_productSortContainer;

	public ProductPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getProductPageTitle() {
		return txt_productPageTitle.getText();
	}

	public List<String> getDropdownOptions_sort() {
		return SelectDropdown.getSelectClassObject().setSelectObject(dropDown_productSortContainer)
				.getDropdownOptionsAsList();
	}

	public void selectOptionFromDropdown(String visibleText) throws Exception {
		SelectDropdown.getSelectClassObject().setSelectObject(dropDown_productSortContainer)
				.selectDropdownOption(visibleText);
	}
}
