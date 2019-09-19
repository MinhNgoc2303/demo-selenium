package SeleniumAPI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section04_UserInteraction {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);
		
	}

	@Test(invocationCount = 4)
	public void Exercise01HoverAction() {
		driver.get("https://www.24h.com.vn/");
		WebElement hoverList = driver.findElement(By.xpath("//a[text()='Danh mục']"));
		Actions hover = new Actions(driver);
		hover.moveToElement(hoverList).perform();
		WebElement hoverSoccer = driver.findElement(By.xpath("//a[text()='Bóng đá']"));
		hover.moveToElement(hoverSoccer).perform();
		WebElement hoverMatch = driver.findElement(By.xpath("//a[text()='Lịch thi đấu bóng đá']"));
		hover.moveToElement(hoverMatch).perform();
		hoverMatch.click();
		
		String title = driver.getTitle();
		Assert.assertEquals("Lịch thi đấu Bóng Đá Anh, Ý TBN C1, Kết quả Tỉ lệ cược 24h", title);
	}
	
	//@Test
	public void ClickAndHoldAction() throws InterruptedException {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> listNumbers = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		Actions clickHold = new Actions(driver);
		clickHold.clickAndHold(listNumbers.get(0)).clickAndHold(listNumbers.get(7)).click().perform();
		clickHold.release();
		List<WebElement> numberSelected = driver.findElements(By.xpath("//ol[@id='selectable']//li[contains(@class,'ui-selected')]"));
		int selected = numberSelected.size();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[@id='selectable']//li[contains(@class,'ui-selected')]")));
		Assert.assertEquals(selected, 8);
		System.out.println(selected);
		}
	
	//@Test
	public void RightClick() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement btnRightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions rightClick = new Actions(driver);
		rightClick.contextClick(btnRightClick).build().perform();
		WebElement hoverClick = driver.findElement(By.xpath("//span[text()='Quit']"));
		Actions hover = new Actions(driver);
		hover.moveToElement(hoverClick).perform();
		hoverClick.click();
		String textAlert = driver.switchTo().alert().getText();
		Assert.assertEquals(textAlert, "clicked: quit");
		driver.switchTo().alert().accept();
	
	}
	
	//@Test
	public void DoubleClick() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement btnDoubleClick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions doubleClick = new Actions(driver);
		doubleClick.doubleClick(btnDoubleClick).perform();
		String textDoubleClick = driver.switchTo().alert().getText();
		String expectedResult = "You double clicked me.. Thank You..";
		Assert.assertEquals(textDoubleClick, expectedResult);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	//@Test
	public void dragAndDrop() throws InterruptedException {
		driver.get("https://interactjs.io/");
		WebElement dragFrom = driver.findElement(By.xpath("//div[@id='yes-drop']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='inner-dropzone']"));
		Actions drag = new Actions(driver);
		drag.clickAndHold(dragFrom).moveToElement(target).release(target).build().perform();
		String droppedActual = dragFrom.getText();
		String droppedExpected = "Dropped";
		Assert.assertEquals(droppedActual, droppedExpected);
	}
	
	//@Test
	public void keyboardAction() {
		driver.get("http://demo.guru99.com/v4/");
		WebElement txtUserID = driver.findElement(By.xpath("//input[@name='uid']"));
		WebElement txtPass= driver.findElement(By.xpath("//input[@name='password']"));
		txtUserID.sendKeys(Keys.TAB);
		String textPass = "123456";
		txtPass.sendKeys(textPass);
		txtPass.sendKeys(Keys.chord(Keys.SHIFT,"tab"));
		String textUser="MinhNgoc";
		txtUserID.sendKeys(textUser);
		//txtUserID.sendKeys(Keys.chord(Keys.CONTROL,"tab"));
		driver.navigate().to("hrrtps://google.com");
		
		
	}
	@AfterClass
	public void AfterClass() {
		driver.quit();;
		
	}
}
