package SeleniumAPI;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section0506_IframeAndAlert {
	WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	//@Test
	public void TC01_handleIframe01() {
		driver.get("http://the-internet.herokuapp.com/iframe");
		WebElement iframeTinyMCE = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframeTinyMCE);
		WebElement editTable = driver.findElement(By.xpath("//body[@id='tinymce']"));
		String textIframe = "Minh Ngoc";
		editTable.clear();
		editTable.sendKeys(textIframe);
		String expectedText = editTable.getText();
		Assert.assertEquals(expectedText, textIframe);
		driver.switchTo().defaultContent();
		String txtTitle = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
		String expectedMsg = "An iFrame containing the TinyMCE WYSIWYG Editor";
		Assert.assertEquals(txtTitle, expectedMsg);
	}

	//@Test
	public void TC02_handleIframe02() throws InterruptedException {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		WebElement iframeResult = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(iframeResult);
		Thread.sleep(3000);
		WebElement txtLast = driver.findElement(By.xpath("//input[@name='lname']"));
		txtLast.isDisplayed();
		String firstName = "ngoc";
		WebElement txtFirstName = driver.findElement(By.xpath("//input[@name='fname']"));
		txtFirstName.sendKeys(firstName);
		WebElement btnSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		btnSubmit.click();
		Assert.assertEquals("fname=ngoc", "fname=" + firstName);

	}

	//@Test
	public void TC03_handleWithWindowPopup() {
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		WebElement txtFollow = driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]"));
		txtFollow.click();
		String twitterTitle = "Selenium Easy (@seleniumeasy) on Twitter";
		switchToWindowByTitle(twitterTitle);
		driver.close();
		String parentTitle = "Selenium Easy - Window Popup Modal Demo";
		switchToWindowByTitle(parentTitle);
		WebElement btnLike = driver.findElement(By.xpath("//a[contains(text(),'Like us On Facebook')]"));
		btnLike.click();
		String faceTitle = "Selenium Easy - Trang chủ | Facebook";
		switchToWindowByTitle(faceTitle);
		driver.close();
		switchToWindowByTitle(parentTitle);
		String expectedTitle = "Selenium Easy - Window Popup Modal Demo";
		Assert.assertEquals(parentTitle, expectedTitle);
	}

	//@Test
	public void TC04_normalAlert() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		WebElement btnJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		btnJSAlert.click();
		Alert alert = driver.switchTo().alert();
		String txtJSAlert = alert.getText();
		String expectedJSAlert = "I am a JS Alert";
		Assert.assertEquals(txtJSAlert, expectedJSAlert);
		alert.accept();
		String expectedResult = "You successfuly clicked an alert";
		String txtResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(txtResult, expectedResult);
	}

	 //@Test
	public void TC05_hanldleAlertConfirm() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		WebElement btnJSConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		btnJSConfirm.click();
		Alert alert = driver.switchTo().alert();
		String txtJSConfirm = alert.getText();
		String expectedJSConfirm = "I am a JS Confirm";
		Assert.assertEquals(txtJSConfirm, expectedJSConfirm);
		alert.dismiss();
		String txtCancel = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String expectedCancel = "You clicked: Cancel";
		Assert.assertEquals(txtCancel, expectedCancel);
	}

	//@Test
	public void TC06_handleAlertPrompts() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		WebElement btnJSPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		btnJSPrompt.click();
		Alert alert = driver.switchTo().alert();
		String txtJSPrompt = alert.getText();
		String expectedJSPrompt = "I am a JS prompt";
		Assert.assertEquals(txtJSPrompt, expectedJSPrompt);
		Thread.sleep(4000);
		String lblPrompt = "MinhNgoc";
		alert.sendKeys(lblPrompt);
		alert.accept();
		Thread.sleep(4000);
		String actualPromptMsg = "You entered: MinhNgoc";
		String expectedPromptResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(actualPromptMsg, expectedPromptResult);
	}
	
	@Test
	public void TC07_handleJavaScript() throws InterruptedException {
		driver.get("http://live.guru99.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement MYACCOUNT_BTN = driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']"));
		js.executeScript("arguments[0].click();", MYACCOUNT_BTN);
		WebElement CREATEACCOUNT_BTN = driver.findElement(By.xpath("//span[text()='Create an Account']"));
		js.executeScript("arguments[0].click();", CREATEACCOUNT_BTN);
		
		String firstName = "ngoc";
		String lastName = "phan";
		String emailAddress = "mimitran" + randomemail() + "@gmail.com";
		String password = "123456789";
		WebElement FIRSTNAME_TXT = driver.findElement(By.xpath("//input[@id='firstname']"));
		WebElement LASTNAME_TXT = driver.findElement(By.xpath("//input[@id='lastname']"));
		WebElement EMAILADDRESS_TXT = driver.findElement(By.xpath("//input[@id='email_address']"));
		WebElement PASSWORD_TXT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement CONFIRMPASSWORD_TXT = driver.findElement(By.xpath("//input[@id='confirmation']"));
		WebElement REGISTER_BTN = driver.findElement(By.xpath("//span[text()='Register']"));
		
		FIRSTNAME_TXT.sendKeys(firstName);
		LASTNAME_TXT.sendKeys(lastName);
		EMAILADDRESS_TXT.sendKeys(emailAddress);
		PASSWORD_TXT.sendKeys(password);
		CONFIRMPASSWORD_TXT.sendKeys(password);
		js.executeScript("arguments[0].click();", REGISTER_BTN);
		
		Thread.sleep(4000);
		String msgRegisterSuccess = driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText();
		String expectedResult = "Thank you for registering with Main Website Store.";
		Assert.assertEquals(msgRegisterSuccess, expectedResult);
		
		WebElement ACCOUNTHEADER_LBL = driver.findElement(By.xpath("//div[@class='page-header-container']//span[text()='Account']"));
		js.executeScript("arguments[0].click();", ACCOUNTHEADER_LBL);
		WebElement LOGOUT_LBL = driver.findElement(By.xpath("//a[text()='Log Out']"));
		js.executeScript("arguments[0].click();", LOGOUT_LBL);
		
		WebElement MYACCOUNTL_LBL = driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']"));
		js.executeScript("arguments[0].click();", MYACCOUNTL_LBL);
		WebElement EMAILADDRESSLOGIN_TXT = driver.findElement(By.xpath("//input[@id='email']"));
		EMAILADDRESSLOGIN_TXT.sendKeys(emailAddress);
		WebElement PASSWORDLOGIN_TXT = driver.findElement(By.xpath("//input[@id='pass']"));
		PASSWORDLOGIN_TXT.sendKeys(password);
		WebElement LOGIN_BTN = driver.findElement(By.xpath("//button[@id='send2']"));
		js.executeScript("arguments[0].click();", LOGIN_BTN);
		String curentTitle = driver.getCurrentUrl();
		String expectedTitle = "http://live.guru99.com/index.php/customer/account/index/";
		Assert.assertEquals(curentTitle, expectedTitle);

	}
	
	

	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String chidlWindows : allWindows) {
			driver.switchTo().window(chidlWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}
	
	public String randomemail() {
		Random rand = new Random();
		int number = rand.nextInt(9000000);
		String numberString = Integer.toString(number);
		return numberString;

	}

}
