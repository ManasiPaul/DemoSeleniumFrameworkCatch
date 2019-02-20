import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentRpt {

	public static class ExtentTestNGReportBuilder {

		ExtentHtmlReporter htmlReporter;
		ExtentReports extent;

		@BeforeSuite
		public void TestSetup() {
			System.out.println("*********sahsas***1");
			htmlReporter = new ExtentHtmlReporter("Manasi.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}

		@Test
		public void Test1() throws Exception {
			System.out.println("*********sahsas***");
			ExtentTest test = extent.createTest(" Last Practice test", "Sample description");

			// log(Status, details)
			test.log(Status.INFO, "This step shows usage of log(status, details)");

			// info(details)
			test.info("This step shows usage of info(details)");

			// log with snapshot
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			// test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

		}
		
		@Test
		public void Test2() throws Exception {
			System.out.println("*********sahsas***");
			ExtentTest test = extent.createTest("MyLastTest4.0.9", "Sample description");

			// log(Status, details)
			test.log(Status.INFO, "This step shows usage of log(status, details)");

			// info(details)
			test.info("This step shows usage of info(details)");

			// log with snapshot
			test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			// test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

		}
		
		@AfterTest
		
		public void teardown() {
			// calling flush writes everything to the log file
	        extent.flush();
		}
	}

}
