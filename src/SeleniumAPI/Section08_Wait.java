package SeleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import com.google.common.base.Function;

public class Section08_Wait {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 1000);
		driver.manage().window().maximize();
	}

	// @Test
	public void TC01_InvisibleWait() {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		WebElement START_BTN = driver.findElement(By.xpath("//button[text()='Start']"));
		START_BTN.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
		String ACTUALMSGDISPLAY = driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText();
		String EXPECTEDMSGDISPLAY = "Hello World!";
		Assert.assertEquals(ACTUALMSGDISPLAY, EXPECTEDMSGDISPLAY);
	}

	// @Test
	public void TC02_VisiableWait() {
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		WebElement REMOVE_BTN = driver.findElement(By.xpath("//button[text()='Remove']"));
		REMOVE_BTN.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Add']")));
		WebElement ITGONE_LBL = driver.findElement(By.xpath("//p[@id='message']"));
		ITGONE_LBL.isDisplayed();
		WebElement ADD_BTN = driver.findElement(By.xpath("//button[text()='Add']"));
		ADD_BTN.isDisplayed();
	}

	 @SuppressWarnings("deprecation")
	//@Test
	public void TC03_FluentWait() {
		driver.get("https://www.w3schools.com/howto/howto_js_countdown.asp");
		WebElement COUNTDOWN = driver.findElement(By.xpath("//p[@id='countdown1']"));
		new FluentWait<WebElement>(COUNTDOWN).withTimeout(10000, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
		.until(new Function<WebElement, Boolean>() {
			public Boolean apply(WebElement element) {
				boolean FLAG = element.getText().contains("21h 49m 31s");
				return FLAG;
			}
		});

	}
	
	 @Test
		public void TC03_Example2() {
			driver.get("https://www.w3schools.com/howto/howto_js_countdown.asp");
			wait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//p[contains(text(),'30s')]"));
				}
				
			});
			String SUCCESSLBL = driver.findElement(By.xpath("//p[contains(text(),'30s')]")).getText();
			Assert.assertTrue(SUCCESSLBL.contains("30s"));
		}

	//@Test
	public void TC04_WaitProgressBar() {
		driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
		WebElement DOWNLOAD_BTN = driver.findElement(By.xpath("//button[@id='cricle-btn']"));
		DOWNLOAD_BTN.click();
		wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[contains(text(),'100%')]"));
			}
		});
		String SUCCESS_TXT = driver.findElement(By.xpath("//div[contains(text(),'100%')]")).getText();
		Assert.assertEquals(SUCCESS_TXT, "100%");
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
