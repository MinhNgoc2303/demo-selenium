package SeleniumAPI;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DemoJQuery {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void Login() throws InterruptedException {
		driver.get("http://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
		
		String email = "ngoc" + randomemail() + "@gmail.com"; 
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		js.executeScript("$('input[name=\"emailid\"]').val('" +email+ "')");
		Thread.sleep(1000);
		js.executeScript("$('input[name=\"btnLogin\"]').click()");
		Thread.sleep(1000);
		String userID = js.executeScript("return $('td:contains(\"User ID :\")').siblings('td[align=\"center\"]').text()").toString();
		Thread.sleep(1000);
		String password = js.executeScript("return $('td:contains(\"Password :\")').siblings('td[align=\"center\"]').text()").toString().trim();
		Thread.sleep(1000);
		driver.get("http://demo.guru99.com/v4/");
		js.executeScript("$('input[name=\"uid\"]').val('"+userID+"')");
		Thread.sleep(1000);
		js.executeScript("$('input[name=\"password\"]').val('"+password+"')");
		Thread.sleep(1000);
		js.executeScript("$('input[name=\"btnLogin\"]').click()");
		Thread.sleep(1500);
		String msg = js.executeScript("return $('marquee:contains(\"Welcome To\")').text()").toString();
		
		Assert.assertTrue(msg.contains("Welcome To"));
	
		
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
	
	public String randomemail() {
		Random rand = new Random();
		int number = rand.nextInt(900000);
		String numberString = Integer.toString(number);
		return numberString;

	}
}
