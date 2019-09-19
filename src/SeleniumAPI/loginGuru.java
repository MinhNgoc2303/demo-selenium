package SeleniumAPI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginGuru {
	WebDriver driver;
	Alert alert;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://demo.guru99.com/v4/");
	}

	@Parameters({ "username01", "password01" })
	@Test
	public void TC01_Success(String username01, String password01) {
		WebElement USERNAME_TXT = driver.findElement(By.xpath("//input[@name='uid']"));
		USERNAME_TXT.sendKeys(username01);
		WebElement PASSWORD_TXT = driver.findElement(By.xpath("//input[@name='password']"));
		PASSWORD_TXT.sendKeys(password01);
		WebElement LOGIN_BTN = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		LOGIN_BTN.click();
		String EXPECTEDMESSAGE = driver.findElement(By.xpath("//marquee[contains(text(),'Welcome')]")).getText();
		Assert.assertTrue(EXPECTEDMESSAGE.contains("Welcome"));
		WebElement LOGOUT_BTN = driver.findElement(By.xpath("//a[text()='Log out']"));
		LOGOUT_BTN.click();
		alert = driver.switchTo().alert();
		alert.accept();

	}

	@Parameters({ "username02", "password02" })
	@Test
	public void TC02_Success(String username02, String password02) {
		WebElement USERNAME_TXT = driver.findElement(By.xpath("//input[@name='uid']"));
		USERNAME_TXT.sendKeys(username02);
		WebElement PASSWORD_TXT = driver.findElement(By.xpath("//input[@name='password']"));
		PASSWORD_TXT.sendKeys(password02);
		WebElement LOGIN_BTN = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		LOGIN_BTN.click();
		String EXPECTEDMESSAGE = driver.findElement(By.xpath("//marquee[contains(text(),'Welcome')]")).getText();
		Assert.assertTrue(EXPECTEDMESSAGE.contains("Welcome"));
		WebElement LOGOUT_BTN = driver.findElement(By.xpath("//a[text()='Log out']"));
		LOGOUT_BTN.click();
		alert = driver.switchTo().alert();
		alert.accept();

	}

	@Parameters({ "username03", "password03" })
	@Test
	public void TC03_Unsuccess(String username03, String password03) {
		WebElement USERNAME_TXT = driver.findElement(By.xpath("//input[@name='uid']"));
		USERNAME_TXT.sendKeys(username03);
		WebElement PASSWORD_TXT = driver.findElement(By.xpath("//input[@name='password']"));
		PASSWORD_TXT.sendKeys(password03);
		WebElement LOGIN_BTN = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		LOGIN_BTN.click();
		alert = driver.switchTo().alert();
		String ALERT_TXT = alert.getText();
		Assert.assertEquals(ALERT_TXT, "User or Password is not valid");
		alert.accept();

	}

	@AfterClass
	public void AfterClass() {
		driver.quit();
	}

}
