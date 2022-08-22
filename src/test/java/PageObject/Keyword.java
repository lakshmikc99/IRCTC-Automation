package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Keyword {
	public void clickWebElement(WebDriver Driver, WebElement element) {

		try {
			element.click();
		} catch (WebDriverException e) {
			//enables the WebDriver to interact with HTML elements within the browser
			JavascriptExecutor executor = (JavascriptExecutor) Driver;
			//provides two methods “executescript” & “executeAsyncScript” to run javascript on the selected window or current page.
			executor.executeAsyncScript("argument[0]", element);

		}

	}
}
