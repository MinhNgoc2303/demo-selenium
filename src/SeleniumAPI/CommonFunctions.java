package SeleniumAPI;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	WebDriver driver;
	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
	}
	//ham khoi tao constractor
	
	public void navigateToUrl(String url) {
		driver.get(url);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	 public String getPageSourceUrl() {
		 return driver.getPageSource();
	 }
	 
	public void backToPage(String url) {
		 driver.navigate().to(url);
	}
	
	public void forwardTopage() {
		driver.navigate().back();
	}
	 
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void clickToElement(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public String getTextElement(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public void clearElement(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	
	public void inputElement(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	
	public void selectCombobox(String locator, String value) {
		Select combobox = new Select(driver.findElement(By.xpath(locator)));
		combobox.selectByVisibleText(value);
	}
	
	public String getTextComboboxSelected(String locator) {
		Select combobox = new Select(driver.findElement(By.xpath(locator)));
		return combobox.getFirstSelectedOption().getText();
	}
	public String getAttribute(String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}
	public int getSizeOfList(String locator) {
		List<WebElement> element = driver.findElements(By.xpath(locator));
		return element.size();
	}
	
	public boolean isElementDisplayed(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public boolean isElementSelected(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	
	public boolean isElementEnable(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public String getTextAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	public void inputAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
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
	
	public String getWindow() {
		return driver.getWindowHandle();
	}
	
	public void switchToIframe(String locator) {
		WebElement iframe = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(iframe);
	}
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	public void hoverMouse(String locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}
	public void doubleClick(String locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(locator));
		action.doubleClick().perform();
	}
	public void righClick(String locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(locator));
		action.contextClick(element).build().perform();
	}
	public void dragAndDrop(String locatorFrom, String locatorTarget) {
		WebElement elementFrom = driver.findElement(By.xpath(locatorFrom));
		WebElement elementTarget = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		action.clickAndHold(elementFrom).moveToElement(elementTarget).release().build().perform();
	}
	public void clickAndHold(String locator, int itemFrom, int itemTarget) {
		List<WebElement> listItems = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
		action.release();
	}
	public void sendKeyPress(String locator, Keys key) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(key);
	}
	public void uploadBySendKeys(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	public void executeScriptBrowser(String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript);
	}
	public void executeScriptElement(String locator, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		js.executeScript(javaScript, element);
	}
	
	public void scrollToBottomPage() {
		
	}
	public Object scrollToElement(String locator) {
		return locator;
		
	}
	public void highlightElement(String locator) {
		
	}
	public Object removeAttributeElement(String locator, String attribute) {
		return attribute;
	} 
	public void waitForElementPresence(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	public void waitForElementVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	public void waitForAlertPresence() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.alertIsPresent());
	}
}

