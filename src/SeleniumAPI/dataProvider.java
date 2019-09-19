package SeleniumAPI;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
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

	@Test(dataProvider = "account")
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
	@Test(dataProvider = "account")
	public void TC03_Unsuccess(String user, String pass) {
		WebElement USERNAME_TXT = driver.findElement(By.xpath("//input[@name='uid']"));
		USERNAME_TXT.sendKeys(user);
		WebElement PASSWORD_TXT = driver.findElement(By.xpath("//input[@name='password']"));
		PASSWORD_TXT.sendKeys(pass);
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

	@DataProvider(name = "account")
	public Object[][] account(Method method) {
		Object[][] result = null;
		if (method.getName().equals("TC01_Success")) {
			result = new Object[][] { { "mngr214186", "jypAmYd" }, { "mngr214187", "nadEmEq" } };
		} else {
			result = new Object[][] { { "vunguyen", "123456789" } };

		}
		return result;
	}
}
