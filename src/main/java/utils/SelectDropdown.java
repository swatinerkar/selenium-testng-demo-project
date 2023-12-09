package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
	Select select;

	private static SelectDropdown selectCommonMethods;
	
	private SelectDropdown() {}

	public static SelectDropdown getSelectClassObject() {
		if (selectCommonMethods == null)
			selectCommonMethods = new SelectDropdown();
		return selectCommonMethods;
	}

	public SelectDropdown setSelectObject(WebElement selectDropdownElement) {
		select = new Select(selectDropdownElement);
		return this;
	}

	public List<String> getDropdownOptionsAsList() {
		List<WebElement> allWebElementsFromDropdown = select.getOptions();
		List<String> allOptionsValue = new ArrayList<String>();
		for (WebElement option : allWebElementsFromDropdown) {
			allOptionsValue.add(option.getText());
		}
		return allOptionsValue;
	}

	public void selectDropdownOption(String visibleText) throws Exception {
		try {
			select.selectByVisibleText(visibleText);
		} catch (Exception e) {
			throw new Exception("Text is not present in dropdown: " + visibleText);
		}
	}

	public void selectDropdownOption(int index) throws Exception {
		try {
			select.selectByIndex(index);
		} catch (Exception e) {
			throw new Exception("Index is not present in dropdown: " + index);
		}
	}

}
