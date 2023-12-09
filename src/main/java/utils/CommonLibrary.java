package utils;

import java.util.List;

import org.openqa.selenium.WebElement;

public class CommonLibrary {

//	To Select Radio button from mutliple radio options
	public void selectRadioButton(List<WebElement> radioButtons, String toBeSelected) {
		for (WebElement radioButton : radioButtons) {
			if (radioButton.getText().equalsIgnoreCase(toBeSelected)) {
				radioButton.click();
				break;
			}
		}
	}

//	To Select multiple options from multi choice checkboxes
	public void selectCheckbox(List<WebElement> checkboxes, List<String> listToBeSelected) {
		for (String value : listToBeSelected) {
			for (WebElement checkbox : checkboxes) {
				if (checkbox.getText().equalsIgnoreCase(value)) {
					checkbox.click();
					break;
				}
			}
		}
	}
}
