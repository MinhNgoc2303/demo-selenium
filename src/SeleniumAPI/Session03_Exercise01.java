package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Session03_Exercise01{

//	public Session03_Exercise01(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}

	WebDriver driver;
	CommonFunctions commonFunctions;

	@BeforeClass()
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		commonFunctions = new CommonFunctions(driver);

	}

	@Test
	public void Exercise01() {
		// driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		commonFunctions.navigateToUrl("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

		String user = "Vu Nguyen";
//		WebElement txtUser = driver.findElement(By.xpath("//input[@id='user-message']"));
//		txtUser.sendKeys(user);
		commonFunctions.inputElement("//input[@id='user-message']", user);
//		WebElement btnShowMessage = driver.findElement(By.xpath("//button[text()='Show Message']"));
//		btnShowMessage.click();
		commonFunctions.clickToElement("//button[text()='Show Message']");
		// String yourMess = driver.findElement(By.xpath("//label[text()='Your Message:
		// ']")).getText().trim();
		String yourMess = commonFunctions.getTextElement("//label[text()='Your Message: ']").trim();
		// String nameMess = driver.findElement(By.xpath("//span[text()='" + user +
		// "']")).getText();
		String nameMess = commonFunctions.getTextElement("//span[text()='" + user + "']");
		String messDisplayed = yourMess + "  " + nameMess;
		Assert.assertEquals("Your Message:  " + user, messDisplayed);

	}

	// @Test
	public void Exercise02() {
		// driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		commonFunctions.navigateToUrl("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		int a = 100, b = 50;
//		WebElement txtA = driver.findElement(By.xpath("//input[@id='sum1']"));
//		txtA.sendKeys(String.valueOf(a));
		commonFunctions.inputElement("//input[@id='sum1']", String.valueOf(a));

//		WebElement txtB = driver.findElement(By.xpath("//input[@id='sum2']"));
//		txtB.sendKeys(String.valueOf(b));
		commonFunctions.inputElement("//input[@id='sum2']", String.valueOf(b));

		WebElement btnTotal = driver.findElement(By.xpath("//button[text()='Get Total']"));
		btnTotal.click();

		String textTotal = driver.findElement(By.xpath("//label[text()=' Total a + b = ']")).getText().trim();
		int total = a + b;
		String.valueOf(total);
		String sum = textTotal + "  " + total;
		Assert.assertEquals("Total a + b =  " + total, sum);

	}

	// @Test
	public void Exercise03() {
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");

		WebElement btnCheck = driver.findElement(By.xpath("//button[@id='buttoncheck']"));
		btnCheck.click();

		WebElement text = driver.findElement(By.xpath("//p[text()='Radio button is Not checked']"));
		text.isDisplayed();

		WebElement btnRadioMaleGender = driver.findElement(By.xpath(
				"//div[text()='Radio Button Demo']/ancestor::div[@class='panel panel-default']//div[@class='panel-body']//input[@value='Male']"));
		btnRadioMaleGender.click();
		btnCheck.click();

		WebElement maleGender = driver.findElement(By.xpath("//p[text()=\"Radio button 'Male' is checked\"]"));
		maleGender.isDisplayed();

		WebElement btnRadioFemaleGender = driver.findElement(By.xpath(
				"//div[text()='Radio Button Demo']/ancestor::div[@class='panel panel-default']//div[@class='panel-body']//input[@value='Female']"));
		btnRadioFemaleGender.click();
		btnCheck.click();

		WebElement femaleGender = driver.findElement(By.xpath("//p[text()=\"Radio button 'Female' is checked\"]"));
		femaleGender.isDisplayed();

	}

	// @Test
	public void Exercise04() {
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		WebElement btnCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
		btnCheckbox.click();

		String messCheckBox = driver.findElement(By.xpath("//div[text()='Success - Check box is checked']")).getText();
		Assert.assertEquals(messCheckBox, "Success - Check box is checked");
	}

	// @Test(groups="Chrome01")
	public void Exercise05() {
		driver.get("https://www.facebook.com/");
		Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		selectDay.selectByVisibleText("14");
		Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		selectMonth.selectByVisibleText("Tháng 2");
		Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		selectYear.selectByVisibleText("2018");

		String selectedDay = selectDay.getFirstSelectedOption().getText();
		Assert.assertEquals("14", selectedDay);
		String selectedMonth = selectMonth.getFirstSelectedOption().getText();
		Assert.assertEquals("Tháng 2", selectedMonth);
		String selectedYear = selectYear.getFirstSelectedOption().getText();
		Assert.assertEquals("2018", selectedYear);

	}

	// @Test(groups="Chrome01")
	public void Section3Exercise01() {
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		WebElement btnGetCheckedValue = driver.findElement(By.xpath("//button[@id='buttoncheck']"));
		Assert.assertTrue(btnGetCheckedValue.isEnabled());
	}

	// @Test
	public void Section3Exercise02() {
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		WebElement txtEnable = driver.findElement(By.xpath("//form[@id='input-example']//input"));
		Assert.assertFalse(txtEnable.isEnabled());

	}

	// @Test
	public void Section3Exercise03() {
		driver.get("http://demo.guru99.com/test/radio.html");
		WebElement btnOption01 = driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
		if (!btnOption01.isSelected()) {
			btnOption01.click();
		}
		Assert.assertTrue(btnOption01.isSelected());
		WebElement checkboxCheck03 = driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
		if (!checkboxCheck03.isSelected()) {
			checkboxCheck03.click();
		}
		Assert.assertTrue(checkboxCheck03.isSelected());
	}

	@AfterClass()
	public void AfterClass() {
		driver.close();

	}

}
