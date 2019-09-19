package SeleniumAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtendReport{
    WebDriver driver;

	@BeforeTest
	public void beforeTest() {
//		inititalReport("ExtentReport.0.html");
//		ChromeDriverManager.getInstance().version("2.46").setup();
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_01() {
//		logTestCase("TC_01");
		Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
	}

	@Test
	public void TC_02() {
//		logTestCase("TC_02");
		Assert.assertEquals("http://demo.guru99.com/v4/", driver.getCurrentUrl());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
//		getResult(result);
	}

	@AfterClass
	public void afterClass() {
//		exportReport();
		driver.quit();
	}
}
