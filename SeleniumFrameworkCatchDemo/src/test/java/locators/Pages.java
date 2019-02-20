
package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import utilities.HelperCatch;

public class Pages  {

	WebElement webElement = null;
	WebDriver driver = null;
	HelperCatch hc = new HelperCatch(driver);
	
	public Pages(WebDriver driver) {
		this.driver  = driver;

	}

	public void navigateToShoeProductBasedOnGender() {
		webElement = driver.findElement(By.xpath("//a[@class='item is-category womens-fashion']"));

		HelperCatch hc = new HelperCatch(driver);
		hc.hoverHelper(webElement);
		driver.findElement(By.xpath("//a[contains(text(),\"Women's Shoes\")]")).click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0,400)");

		driver.findElement(By.xpath("//label[@title='Women']")).click();
	}

	public void selectBrand() {

		webElement = driver.findElement(By.xpath("//label[@title='Cotswold']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", webElement);
		je.executeScript("scroll(0,400)");

		webElement.click();

	}

	public void selectShoeAndSelectSize() {

		webElement = driver.findElement(By.xpath(
				"//a[@title='View Cotswold Womens/Ladies Oxerton Waterproof Hiking Boots (Grey) - FS4936']//img[@class='img-responsive lazyloaded']"));

		HelperCatch hc = new HelperCatch(driver);
		hc.hoverHelper(webElement);

		driver.findElement(By.xpath("//div[@id='1883156']//a[@title='Select Size'][contains(text(),'Select Size')]"))
				.click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0,200)");

		driver.findElement(By.xpath("//label[@for='attribute-455968']")).click();
		je.executeScript("scroll(0,400)");

	}

	public void addToCartAndCheckoutFromProductScreeen() {
		
		

		try {
			driver.findElement(By.xpath("//div[@class='button-controller btn-cart']//button[@type='submit']")).click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			driver.findElement(By.xpath("//div[@class='button-controller btn-cart']//button[@type='submit']")).click();
		}

		try {
			driver.findElement(By.xpath("//a[@class='proceed-to-cart btn success full']")).click();
			
			
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			driver.findElement(By.xpath("//a[@class='proceed-to-cart btn success full']")).click();
		}
	}

	public void finalCheckOutScreen() {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0,500)");
		driver.findElement(By.xpath("//a[@class='btn success full upper large']")).click();
	}

}
