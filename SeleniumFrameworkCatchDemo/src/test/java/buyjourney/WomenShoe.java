package buyjourney;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import locators.Pages;

public class WomenShoe {

	WebDriver driver = null;
	Actions hover = null;
	WebElement webElement = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	@BeforeSuite
	public void TestSetup() {

		htmlReporter = new ExtentHtmlReporter("Catch_Manasi.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setUpTest() {

		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver");

		driver = new ChromeDriver();
		driver.get("https://www.catch.com.au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void shoes() throws IOException {

		ExtentTest test = extent.createTest("Catch.com Test Journey", "Test Run By Manasi");

		
		Pages pages = new Pages(driver);

		pages.navigateToShoeProductBasedOnGender();
		test.pass("Successful in navigating to all womens Shoe Product");

		pages.selectBrand();
		test.pass("Successful in selecting shoe brand");

		pages.selectShoeAndSelectSize();
		test.pass("Successful in selecting shoe type and size");

		pages.addToCartAndCheckoutFromProductScreeen();
		test.pass("Successful in adding product to cart and checkout from product screen");

		pages.finalCheckOutScreen();
		test.pass("Successful in Checking out selected product from final checkout screen");

	}

	@AfterTest
	public void tearDownTest() {

		driver.close();
		driver.quit();

		System.out.println("******Test Successful******");
	}

	@AfterSuite
	public void teardown() {
		extent.flush();
	}

}
