package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HelperCatch {

	WebDriver driver = null;
	Actions hover = null;
	WebElement webElement = null;

	public HelperCatch(WebDriver driver) {

		this.driver = driver;

	}

	public void hoverHelper(WebElement webElement) {
		hover = new Actions(driver);
		hover.moveToElement(webElement).perform();
	}

	public void exceptionObjRemovedFromDom() {

	}

}
