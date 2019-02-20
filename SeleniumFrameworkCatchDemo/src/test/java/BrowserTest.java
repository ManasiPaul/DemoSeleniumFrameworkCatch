
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserTest {

	public static void main(String[] args) {

		String projectpath = System.getProperty("user.dir");

		System.out.println("Projectpath" + projectpath);

		// System.setProperty("webdriver.gecko.driver", projectpath +
		// "/drivers/geckodriver/geckodriver" );
		// WebDriver firefoxdriver = new FirefoxDriver();
		// firefoxdriver.get("https://www.seleniumhq.org/");

		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver");

		WebDriver chromedriver = new ChromeDriver();

		chromedriver.get("https://www.catch.com.au/");
		chromedriver.manage().window().maximize();
		chromedriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		/*
		 * try { Thread.sleep(3600); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */

		Actions hover = new Actions(chromedriver);
		WebElement webElement = chromedriver.findElement(By.xpath("//a[@class='item is-category womens-fashion']"));

		hover.moveToElement(webElement).perform();

		chromedriver.findElement(By.xpath("//a[contains(text(),\"Women's Shoes\")]")).click();

		JavascriptExecutor je = (JavascriptExecutor) chromedriver;

		/*
		 * try { Thread.sleep(3600); } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		je.executeScript("scroll(0,400)");

		chromedriver.findElement(By.xpath("//label[@title='Women']")).click();

		/*
		 * try { Thread.sleep(3600); } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		WebElement WebElement1 = chromedriver.findElement(By.xpath("//label[@title='Cotswold']"));

		je.executeScript("arguments[0].scrollIntoView(true)", WebElement1);
		je.executeScript("scroll(0,400)");

		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		WebElement1.click();

		/*
		 * try { Thread.sleep(4000); } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		WebElement webElement2 = chromedriver.findElement(By.xpath(
				"//a[@title='View Cotswold Womens/Ladies Oxerton Waterproof Hiking Boots (Grey) - FS4936']//img[@class='img-responsive lazyloaded']"));

		hover.moveToElement(webElement2).perform();
		/*
		 * try { Thread.sleep(3600); } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		chromedriver
				.findElement(By.xpath("//div[@id='1883156']//a[@title='Select Size'][contains(text(),'Select Size')]"))
				.click();

		/*
		 * try { Thread.sleep(3600); } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		je.executeScript("scroll(0,200)");
		chromedriver.findElement(By.xpath("//label[@for='attribute-455968']")).click();

		/*
		 * try { Thread.sleep(3600); } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		je.executeScript("scroll(0,400)");

		System.out.println("*********************");

		try {
			chromedriver.findElement(By.xpath("//div[@class='button-controller btn-cart']//button[@type='submit']"))
					.click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			chromedriver.findElement(By.xpath("//div[@class='button-controller btn-cart']//button[@type='submit']"))
					.click();
		}

		System.out.println("*********************");
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		try {
			chromedriver.findElement(By.xpath("//a[@class='proceed-to-cart btn success full']")).click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			chromedriver.findElement(By.xpath("//a[@class='proceed-to-cart btn success full']")).click();
		}

		je.executeScript("scroll(0,500)");

		chromedriver.findElement(By.xpath("//a[@class='btn success full upper large']")).click();
		
		chromedriver.close();
		chromedriver.quit();
		
		System.out.println("****Test is Successfull****");

	}

}
