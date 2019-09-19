package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebCommand {
	WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void TestCase01() {
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();

//		String currentUrl = driver.getCurrentUrl();
//		System.out.println("Current url: " + currentUrl);
//
//		String pageSource = driver.getPageSource();
//		System.out.println("Current page source: " + pageSource);
//		
//		String titlePage = driver.getTitle();
//		System.out.println("Titile of page is: " + titlePage);
//		
//		driver.navigate().to("https://www.google.com/");
//		driver.navigate().back();
//		driver.navigate().forward();
		String username="mngr207732";
		String password = "ytAqugu";
		WebElement txtUserId = driver.findElement(By.xpath("//input[@name='uid']"));
		txtUserId.sendKeys(username);
		String attribute = txtUserId.getAttribute("onkeyup");
		System.out.println("Attribute userId: " + attribute);
		
		String textUserId = driver.findElement(By.xpath("//td[contains(text(),'Password')]")).getText();
		System.out.println("Get text user Id: "+ textUserId );
		
		WebElement txtPass = driver.findElement(By.xpath("//input[@name='password']"));
		String textPass = driver.findElement(By.xpath("//td[contains(text(),'UserID')]")).getText();
		System.out.println("Get text password: " + textPass);
		txtPass.sendKeys(password);
		//txtUserId.clear();
		
		WebElement btnLogin = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		btnLogin.click();
		
		String actualPage = driver.getTitle();
		String expectedPage = "Guru99 Bank Manager HomePage";
		
		Assert.assertEquals(actualPage,expectedPage);
		
		//driver.switchTo().alert().accept();
		
	}
	

	@AfterClass
	public void AfterClass() {
		driver.close();

	}

}
