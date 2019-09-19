package SeleniumAPI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section07_UploadFile {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);
	}

	//@Test
	public void TC01_EX01_sendkeys() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/upload/");
		String pathImage = "C:\\Users\\ngoctmphan\\SELENIUM\\exerciseSelenium\\Exercise_Selenium\\image\\01.png";
		WebElement BROWSER_BTN = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		BROWSER_BTN.sendKeys(pathImage);
		WebElement TERN_CKB = driver.findElement(By.xpath("//input[@id='terms']"));
		TERN_CKB.click();
		WebElement SUBMIT_BTN = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		SUBMIT_BTN.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@id='res']")));
		String msgDisplay = driver.findElement(By.xpath("//h3[@id='res']")).getText();
		Assert.assertTrue(msgDisplay.contains("has been successfully uploaded."));
	}
	//@Test
	public void TC02_EX01_Robot() throws InterruptedException, AWTException {
		StringSelection select = new StringSelection("C:\\Users\\ngoctmphan\\Desktop\\01.png");
		WebElement BROWSER_BTN = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		BROWSER_BTN.click();

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		WebElement TERN_CKB = driver.findElement(By.xpath("//input[@id='terms']"));
		TERN_CKB.click();
		WebElement SUBMIT_BTN = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		SUBMIT_BTN.click();
		Thread.sleep(2000);
		String msgDisplay = driver.findElement(By.xpath("//h3[@id='res']")).getText();
		Assert.assertTrue(msgDisplay.contains("has been successfully uploaded."));
	}
	//@Test
	public void TC03_EX02_sendKeys() {
		driver.get("http://the-internet.herokuapp.com/upload");
		WebElement BROWSER_BTN = driver.findElement(By.xpath("//input[@id='file-upload']"));
		String pathImage = "C:\\Users\\ngoctmphan\\SELENIUM\\exerciseSelenium\\Exercise_Selenium\\image\\luffy.png";
		BROWSER_BTN.sendKeys(pathImage);
		WebElement UPLOAD_BTN = driver.findElement(By.xpath("//input[@id='file-submit']"));
		UPLOAD_BTN.click();
		String actualMsgUploaded = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
		String expectedMsgUploaded = "File Uploaded!";
		Assert.assertEquals(actualMsgUploaded, expectedMsgUploaded);
	}
	//@Test
	public void TC04_EX02_Robot() throws AWTException, InterruptedException {
		driver.get("http://the-internet.herokuapp.com/upload");
		StringSelection select = new StringSelection("C:\\Users\\ngoctmphan\\Desktop\\luffy.png");
		WebElement BROWSER_BTN = driver.findElement(By.xpath("//input[@id='file-upload']"));
		BROWSER_BTN.click();

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		WebElement UPLOAD_BTN = driver.findElement(By.xpath("//input[@id='file-submit']"));
		UPLOAD_BTN.click();
		String actualMsgUploaded = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
		String expectedMsgUploaded = "File Uploaded!";
		Assert.assertEquals(actualMsgUploaded, expectedMsgUploaded);
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();

	}

}
